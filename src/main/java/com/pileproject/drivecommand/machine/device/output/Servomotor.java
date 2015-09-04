package com.pileproject.drivecommand.machine.device.output;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.device.DeviceBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

import java.util.HashMap;

public class Servomotor extends DeviceBase {
	
	public Servomotor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Set the angle to this servomotor
	 */
	public void setAngle(int angle) {
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("speed", angle);
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
		exec(cmd);
	}
	
	/**
	 * Get the angle of the servomotor
	 */
	public int getAngle() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_SERVO_ANGLE, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer) res.get("value");
	}

	@Override
	public DeviceType getDeviceType() {
		return DeviceType.SERVOMOTOR;
	}
	
}
