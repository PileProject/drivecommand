package com.pile_drive.drivecommand.model.ev3;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import android.util.Log;

/**
 * EV3 Command Maker
 * 
 * @author <a href="mailto:tatsuyaw0c@gmail.com">Tatsuya Iwanari</a>
 * @version 1.0 21-Dec-2013
 */
public class ByteCodeFormatter {
	private ByteArrayOutputStream mStream;
	// use DataOutputStream as a writer of ByteArrayOutputStream
	private DataOutputStream mWriter;
	
	// Parameter Size
	private static byte BYTE_SIZE = (byte)0x81;
	private static byte SHORT_SIZE = (byte)0x82;
	private static byte INT_SIZE = (byte)0x83;
	private static byte STRING_SIZE = (byte)0x84;
	
	private static byte GLOBAL_INDEX_SIZE = (byte)0xe1;
	
	private static String TAG = "ByteCodeFormatter";
	
	public ByteCodeFormatter() {
		mStream = new ByteArrayOutputStream();
		mWriter = new DataOutputStream(mStream);
	}

	/**
	 * Add opcode
	 * @param opcode
	 */
	public void addOpCode(byte opcode) {
		try {
			mWriter.writeByte(opcode);
		}
		catch (IOException e) {
			Log.e(TAG, "Couldn't write opcode", e);
		}
	}
	
	/**
	 * Add global and local buffer size
	 * @param global size of global buffer in bytes
	 * @param local size of local buffer in bytes
	 */
	public void addGlobalAndLocalBufferSize(int global, int local) {		
		if (global > 1024)
			throw new IllegalArgumentException("Global buffer must be less than 1024 bytes");
		if (local > 64)
			throw new IllegalArgumentException("Local buffer must be less than 64 bytes");
		
		// write 2 bytes in form of (llllllgg gggggggg)
		try {
			mWriter.writeByte(global);	// LSB
			mWriter.writeByte((local << 2) | (global >> 8) & 0x03);	// MSB
		}
		catch (IOException e) {
			Log.e(TAG, "Couldn't write global and local buffer size", e);
		}
	}
	
	/**
	 * Add byte parameter
	 * @param param
	 */
	public void addParameter(byte param) {
		try {
			mWriter.writeByte(BYTE_SIZE);
			mWriter.writeByte(param);
		}
		catch (IOException e) {
			Log.e(TAG, "Couldn't write paramameter (byte)", e);
		}
	}
	
	/**
	 * Add short parameter
	 * @param param
	 */
	public void addParameter(short param) {
		try {
			mWriter.writeByte(SHORT_SIZE);
			mWriter.writeShort(param);
		}
		catch (IOException e) {
			Log.e(TAG, "Couldn't write paramameter (short)", e);
		}
	}
	
	/**
	 * Add int parameter
	 * @param param
	 */
	public void addParameter(int param) {
		try {
			mWriter.writeByte(INT_SIZE);
			mWriter.writeInt(param);
		}
		catch (IOException e) {
			Log.e(TAG, "Couldn't write paramameter (int)", e);
		}
	}
	
	/**
	 * Add String parameter
	 * @param param
	 * TODO: NOT TESTED
	 */
	public void addParameter(String param) {
		try {
			mWriter.writeByte(STRING_SIZE);
			mWriter.writeChars(param);
			mWriter.write((byte)0x00);	// terminal
		}
		catch (IOException e) {
			Log.e(TAG, "Couldn't write paramameter (String)", e);
		}
	}
	
	/**
	 * Add global index
	 * @param index
	 */
	public void addGlobalIndex(byte index) {
		try {
			mWriter.writeByte(GLOBAL_INDEX_SIZE);
			mWriter.writeByte(index);
		}
		catch (IOException e) {
			Log.e(TAG, "Couldn't add global index", e);
		}
	}

	/**
	 * Append command
	 * @param command
	 */
	public void appendCommand(ByteCodeFormatter command) {
		try {
			mWriter.write(command.byteArray());
		}
		catch (IOException e) {
			Log.e(TAG, "Couldn't append command", e);
		}
	}
	
	/**
	 * Get command in array of byte
	 * @return byte[]
	 */
	public byte[] byteArray() {
		return mStream.toByteArray();
	}
}
