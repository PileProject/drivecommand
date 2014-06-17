package com.pile_drive.drivecommand.model;

import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;

public abstract class ProtocolBase {
	protected final ICommunicator mCommunicator;
	
	public ProtocolBase(ICommunicator comm) {
		mCommunicator = comm;
	}
	
	/**
	 * Get communicator
	 * @return
	 */
	protected ICommunicator getCommunicator() {
		return mCommunicator;
	}
	
	public abstract void open();
	public abstract void close();
	public abstract HashMap<String, Object> exec(int port, CommandBase cmd);
}
