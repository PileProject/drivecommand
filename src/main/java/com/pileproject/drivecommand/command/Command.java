package com.pileproject.drivecommand.command;

import com.pileproject.drivecommand.model.CommandType;

import java.util.Map;

public class Command extends CommandBase {
	public Command(CommandType type, Map<String, Object> args) {
		super(type, args);
	}
}
