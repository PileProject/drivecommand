package com.pile_drive.drivecommand.command;

import java.util.HashMap;

import com.pile_drive.drivecommand.model.CommandType;

public class Command extends CommandBase {
	public Command(CommandType type, HashMap<String, Object> args) {
		super(type, args);
	}
}
