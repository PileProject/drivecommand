package com.pile_drive.drivecommand.model;

import java.io.IOException;
import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.model.com.ICommunicator;

public abstract class ProtocolBase {
	protected final ICommunicator mCommunicator;
	
	public ProtocolBase(ICommunicator comm) {
		mCommunicator = comm;
	}
	
	public abstract void open() throws IOException;
	public abstract void close();
	public abstract HashMap<String, Object> exec(int port, CommandBase cmd);
}
