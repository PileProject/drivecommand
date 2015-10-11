package com.pileproject.drivecommand.command;

import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.model.CommandType;

import java.util.Map;

public abstract class CommandBase {
	private CommandType mType;
	private Map<String, Object> mArgs;
	
	public CommandBase(CommandType type, Map<String, Object> args) {
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
	public Map<String, Object> getArgs() {
		return mArgs;
	}
}
