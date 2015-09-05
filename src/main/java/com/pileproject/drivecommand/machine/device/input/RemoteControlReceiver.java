package com.pileproject.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.device.DeviceBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

import java.util.HashMap;

public class RemoteControlReceiver extends DeviceBase {

	public RemoteControlReceiver(InputPort port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Get pushed buttons on the controller.
	 * 
	 * @return button number
	 */
	public int getRemoteButton() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_REMOTECONTROLLER_BUTTON, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer)res.get("value");
	}

	/**
	 * Get distance between this device and the controller.
	 * 
	 * @return distance [cm] TODO: not tested
	 */
	public int getRemoteDistance() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_REMOTECONTROLLER_DIST, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer)res.get("value");
	}

	@Override
	public DeviceType getDeviceType() {
		return DeviceType.REMOTECONTROL_RECIEVER;
	}
}
