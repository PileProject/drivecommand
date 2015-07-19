package com.pile_drive.drivecommand.command;

import java.util.HashMap;

import com.pile_drive.drivecommand.model.CommandType;

public class CommandFactory {
	
	/**
	 * Create command
	 * @param type
	 * @param args
	 * @return command
	 */
	public static CommandBase createCommand(CommandType type, HashMap<String, Object> args) {
		return new Command(type, args);
	}
}
