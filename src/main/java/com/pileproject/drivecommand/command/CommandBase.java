package com.pileproject.drivecommand.command;

import java.util.HashMap;

import com.pileproject.drivecommand.machine.DeviceType;
import com.pileproject.drivecommand.model.CommandType;

public abstract class CommandBase {
	private CommandType mType;
	private HashMap<String, Object> mArgs;
	
	public CommandBase(CommandType type, HashMap<String, Object> args) {
		mType = type;
		mArgs = args;
	}
	
	/**
	 * Get its command type
	 * 
	 * @return CommandType
	 */
	public CommandType getCommandType() {
		return mType;
	}
	
	/**
	 * Get the device type which is used in its command
	 * 
	 * @return DeviceType
	 */
	public DeviceType getDeviceType() {
		return mType.getDeviceType();
	}
	
	/**
	 * Get the arguments
	 * 
	 * @return HashMap
	 */
	public HashMap<String, Object> getArgs() {
		return mArgs;
	}
}
