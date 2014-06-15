package com.pile_drive.drivecommand.command;

import java.util.HashMap;

import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ICommand;

public class CommandFactory {
	public ICommand createCommand(CommandType type, HashMap<String, Object> args) {
		return new Command();
	}
}
