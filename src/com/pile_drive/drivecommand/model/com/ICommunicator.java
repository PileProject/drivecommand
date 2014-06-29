package com.pile_drive.drivecommand.model.com;

import java.io.IOException;

public interface ICommunicator {
	/**
	 * Open the connection between devices.
	 * @throws IOException
	 */
	public void open() throws IOException;
	/**
	 * Close the connection between devices.
	 */
	public void close();
	/**
	 * Write the byte array data to the device.
	 * @param data
	 * @param timeout
	 * @throws RuntimeException
	 */
	public void write(byte[] data, int timeout) throws RuntimeException;
	/**
	 * Read the respose from the device.
	 * @param length The max length of response wanted to be read
	 * @param timeout
	 * @return
	 * @throws RuntimeException
	 */
	public byte[] read(int length, int timeout) throws RuntimeException;
}
