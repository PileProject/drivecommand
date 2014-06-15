package com.pile_drive.drivecommand.model;

import java.util.HashMap;

public interface IProtocol {
	HashMap<String, Object> exec(int port, ICommand cmd);
}
