package com.pile_drive.drivecommand.machine;

import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class LineSensor extends DeviceBase {
	
	public LineSensor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	int getSensorValue() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_LINE_VALUE, null);
		HashMap<String, Object> value = exec(cmd);
		return (Integer)value.get("value");
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.LINE_SENSOR;
	}
}
