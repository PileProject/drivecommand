package com.pile_drive.drivecommand.model.com;

import java.io.IOException;

public interface ICommunicator {
	public void open() throws IOException;
	public void close();
	public boolean send(byte[] data, int timeout);
	public byte[] recv(int length, int timeout);
}
