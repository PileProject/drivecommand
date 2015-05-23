package com.pile_drive.drivecommand.model.pile;

public class PileConstants {
	// Command Types
	public enum CommandTypes {
		MOVE(0x00),
		MUSIC(0x01),
		TOUCH(0x10),
		DISTANCE(0x11),
		LINESENSOR(0x12),
		LED(0x13),
		APPLY(0x70),
		PRINT(0x80),
		ECHOBACK(0x81);
		
		private int mValue;
		private CommandTypes(int value) {
			mValue = value;
		}
		public int value() {
			return mValue;
		}
	}
	public enum MotorDir {
		FREE((byte)0x00),
		FORWARD((byte)0x01),
		BACKWARD((byte)0x02),
		BRAKE((byte)0x03);
		
		private byte mValue;
		private MotorDir(byte value) {
			mValue = value;
		}
		public byte value() {
			return mValue;
		}
	}
}
