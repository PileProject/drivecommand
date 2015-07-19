package com.pileproject.drivecommand.command;

import java.util.HashMap;

import com.pileproject.drivecommand.model.CommandType;

public class Command extends CommandBase {
	public Command(CommandType type, HashMap<String, Object> args) {
		super(type, args);
	}
}
