package com.pile_drive.drivecommand.model;

import java.io.IOException;
import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.model.com.ICommunicator;

public class Ev3Protocol extends ProtocolBase {
	
	public Ev3Protocol(ICommunicator comm) {
		super(comm);
	}

	@Override
	public void open() throws IOException {
		mCommunicator.open();
	}

	@Override
	public void close() {
		mCommunicator.close();
	}

	@Override
	public HashMap<String, Object> exec(int port, CommandBase cmd) {
		return null;
	}
}
