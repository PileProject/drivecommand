package com.pileproject.drivecommand.machine.device.output;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.device.DeviceBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

import java.util.HashMap;

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
	 */
	public void forward() {
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("speed", mSpeed);
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
		exec(cmd);
	}
	
	/**
	 * Move motor backward
	 */
	public void backward() {
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("speed", -mSpeed);
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
		exec(cmd);
	}
	
	/**
	 * Stop motor
	 */
	public void stop() {
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("speed", 0);
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
		exec(cmd);
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
