package com.pile_drive.drivecommand.model;

import java.nio.ByteBuffer;

public interface ICommunicator {
	public boolean send(ByteBuffer data, int timeout);
	public ByteBuffer recv(int length, int timeout);
}
