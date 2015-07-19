package com.pileproject.drivecommand.machine.input;

import java.util.HashMap;

import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.DeviceBase;
import com.pileproject.drivecommand.machine.DeviceType;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

public class LineSensor extends DeviceBase {
	
	public LineSensor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Get light sensor value
	 * @return sensor value (0 ~ 100%)
	 */
	public int getSensorValue() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_LINE_VALUE, null);
		HashMap<String, Object> value = exec(cmd);
		return (Integer)value.get("value");
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.LINE_SENSOR;
	}
}
