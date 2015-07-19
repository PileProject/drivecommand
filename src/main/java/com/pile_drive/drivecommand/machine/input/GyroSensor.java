package com.pile_drive.drivecommand.machine.input;

import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

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
