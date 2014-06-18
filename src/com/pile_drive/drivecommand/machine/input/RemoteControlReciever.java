package com.pile_drive.drivecommand.machine.input;

import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class RemoteControlReciever extends DeviceBase {

	public RemoteControlReciever(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	public int getRemoteButton() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_REMOTECONTROLLER_BUTTON, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer)res.get("value");
	}

	public int getRate() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_REMOTECONTROLLER_DIST, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer)res.get("value");
	}

	@Override
	public DeviceType getDeviceType() {
		return DeviceType.REMOTECONTROL_RECIEVER;
	}
}
