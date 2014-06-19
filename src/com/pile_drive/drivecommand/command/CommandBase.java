package com.pile_drive.drivecommand.command;

import java.util.HashMap;

import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.CommandType;

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
	 * @return
	 */
	public CommandType getCommandType() {
		return mType;
	}
	
	/**
	 * Get the device type which is used in its command
	 * @return
	 */
	public DeviceType getDeviceType() {
		return mType.getDeviceType();
	}
	
	/**
	 * Get the arguments
	 * 
	 * @return
	 */
	public HashMap<String, Object> getArgs() {
		return mArgs;
	}
}
