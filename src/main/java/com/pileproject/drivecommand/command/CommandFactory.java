package com.pileproject.drivecommand.command;

import com.pileproject.drivecommand.model.CommandType;

import java.util.HashMap;

public class CommandFactory {
	
	/**
	 * Create command
	 *
	 * @param type
	 * @param args
	 * @return command
	 */
	public static CommandBase createCommand(CommandType type, HashMap<String, Object> args) {
		return new Command(type, args);
	}
}
