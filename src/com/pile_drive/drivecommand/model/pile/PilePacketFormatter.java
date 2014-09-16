package com.pile_drive.drivecommand.model.pile;

import java.io.ByteArrayOutputStream;


public class PilePacketFormatter {
	private ByteArrayOutputStream mByteStream;
	
	public PilePacketFormatter(PileConstants.CommandTypes type) {
		mByteStream = new ByteArrayOutputStream();
		mByteStream.write(type.value());
	}
	
	public void setDataByte(byte dataByte) {
		mByteStream.write((int)dataByte);
	}
	
	public void calculateChecksum() {
		byte[] dataArray = mByteStream.toByteArray();
		int size = mByteStream.size() + 2; // (+2 means checksum)
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream(size);
		byte checksum = (byte)(size & 0xFF);
		// Length
		byteStream.write(size);
		// Type, Data
		for (byte b : dataArray) {
			checksum ^= b;
			byteStream.write(b);
		}
		// Checksum
		byteStream.write(checksum);
		// Swap
		mByteStream = byteStream;
	}
	public byte[] byteArray() {
		return mByteStream.toByteArray();
	}
}
