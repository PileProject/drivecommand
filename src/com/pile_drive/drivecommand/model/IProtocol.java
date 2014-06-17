package com.pile_drive.drivecommand.model;

import java.util.HashMap;

import com.pile_drive.drivecommand.command.ICommand;

public interface IProtocol {
	HashMap<String, Object> exec(int port, ICommand cmd);
}
