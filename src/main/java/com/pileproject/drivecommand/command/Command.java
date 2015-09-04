package com.pileproject.drivecommand.command;

import com.pileproject.drivecommand.model.CommandType;

import java.util.HashMap;

public class Command extends CommandBase {
	public Command(CommandType type, HashMap<String, Object> args) {
		super(type, args);
	}
}
