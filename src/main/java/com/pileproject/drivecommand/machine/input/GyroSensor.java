package com.pileproject.drivecommand.machine.input;

import java.util.HashMap;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.DeviceBase;
import com.pileproject.drivecommand.machine.DeviceType;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

public class GyroSensor extends DeviceBase {

	public GyroSensor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}

	public int getRate() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_GYRO_RATE, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer)res.get("value");
	}

	public int getAngle() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_GYRO_ANGLE, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer)res.get("value");
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.GYRO_SENSOR;
	}
}
