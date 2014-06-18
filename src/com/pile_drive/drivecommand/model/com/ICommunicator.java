package com.pile_drive.drivecommand.model.com;

import java.nio.ByteBuffer;

public interface ICommunicator {
	public void open();
	public void close();
	public boolean send(ByteBuffer data, int timeout);
	public ByteBuffer recv(int length, int timeout);
}
