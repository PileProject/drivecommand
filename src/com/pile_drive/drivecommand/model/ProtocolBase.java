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
	
	/**
	 * Open the connection between devices.
	 * @throws IOException
	 */
	public abstract void open() throws IOException;
	
	/**
	 * Close the connection between devices.
	 */
	public abstract void close();
	
	/**
	 * Execute the command.
	 * @param port
	 * @param cmd
	 * @return
	 */
	public abstract HashMap<String, Object> exec(int port, CommandBase cmd);
}
