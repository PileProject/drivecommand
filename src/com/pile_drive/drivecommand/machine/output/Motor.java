package com.pile_drive.drivecommand.machine.output;

import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class Motor extends DeviceBase {
	private int mSpeed = 50; // initial value
	
	public Motor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Set speed (0 - 100%)
	 * if the speed is out of the range,
	 * this method do nothing.
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		if (speed < 0 || speed > 100) return;
		mSpeed = speed;
	}
	
	/**
	 * Move motor forward
	 * 
	 * @return valid
	 */
	public boolean forward() {
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("speed", mSpeed);
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
		HashMap<String, Object> res = exec(cmd);
		return (Boolean) res.get("valid");
	}
	
	/**
	 * Move motor backward
	 * 
	 * @return valid
	 */
	public boolean backward() {
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("speed", -mSpeed);
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
		HashMap<String, Object> res = exec(cmd);
		return (Boolean) res.get("valid");
	}
	
	/**
	 * Stop motor
	 * 
	 * @return valid
	 */
	public boolean stop() {
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("speed", 0);
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
		HashMap<String, Object> res = exec(cmd);
		return (Boolean) res.get("valid");
	}
	
	/**
	 * Get the speed of motor
	 * 
	 * @return speed (0 - 100%)
	 */
	public int getSpeed() {
		return mSpeed;
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.MOTOR;
	}
	
}
