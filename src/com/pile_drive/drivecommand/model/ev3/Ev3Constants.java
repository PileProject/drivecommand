package com.pile_drive.drivecommand.model.ev3;

public interface Ev3Constants {
	
	// Command Types
	public static byte DIRECT_COMMAND_REPLY = (byte) 0x00;
	public static byte DIRECT_COMMAND_NOREPLY = (byte) 0x80;
	
	public static byte DIRECT_COMMAND_SUCCESS = (byte) 0x02;
	public static byte DIRECT_COMMAND_FAIL = (byte) 0x04;
	
	// Direct Commands - SOUND
	public static byte SOUND_CONTROL = (byte) 0x94;
	
	// Sub code for SOUND_CONTROL
	public static byte SOUND_BREAK = (byte) 0x00;
	public static byte SOUND_TONE = (byte) 0x01;
	public static byte SOUND_PLAY = (byte) 0x02;
	public static byte SOUND_REPEAT = (byte) 0x03;
	public static byte SOUND_SERVICE = (byte) 0x04;
	
	// Direct Commands - INUPT
	public static byte INPUT_SAMPLE = (byte) 0x97;
	public static byte INPUT_DEVICE_LIST = (byte) 0x98;
	public static byte INPUT_DEVICE = (byte) 0x99;
	public static byte INPUT_READ = (byte) 0x9A;
	public static byte INPUT_TEST = (byte) 0x9B;
	public static byte INPUT_READY = (byte) 0x9C;
	public static byte INPUT_READSI = (byte) 0x9D;
	public static byte INPUT_READEXT = (byte) 0x9E;
	public static byte INPUT_WRITE = (byte) 0x9F;
	
	// Direct Commands - OUTPUT
	public static byte OUTPUT_GET_TYPE = (byte) 0xA0;
	public static byte OUTPUT_SET_TYPE = (byte) 0xA1;
	public static byte OUTPUT_RESET = (byte) 0xA2;
	public static byte OUTPUT_STOP = (byte) 0xA3;
	public static byte OUTPUT_POWER = (byte) 0xA4;
	public static byte OUTPUT_SPEED = (byte) 0xA5;
	public static byte OUTPUT_START = (byte) 0xA6;
	public static byte OUTPUT_POLARITY = (byte) 0xA7;
	public static byte OUTPUT_READ = (byte) 0xA8;
	public static byte OUTPUT_TEST = (byte) 0xA9;
	public static byte OUTPUT_READY = (byte) 0xAA;
	public static byte OUTPUT_POSITION = (byte) 0xAB;
	public static byte OUTPUT_STEP_POWER = (byte) 0xAC;
	public static byte OUTPUT_TIME_POWER = (byte) 0xAD;
	public static byte OUTPUT_STEP_SPEED = (byte) 0xAE;
	public static byte OUTPUT_TIME_SPEED = (byte) 0xAF;
	public static byte OUTPUT_STEP_SYNC = (byte) 0xB0;
	public static byte OUTPUT_TIME_SYNC = (byte) 0xB1;
	public static byte OUTPUT_CLR_COUNT = (byte) 0xB2;
	public static byte OUTPUT_GET_COUNT = (byte) 0xB3;
	public static byte OUTPUT_PRG_ST = (byte) 0xB4;
	
	// Sub Commands for INPUT_DEVICE
	public static byte GET_FORMAT = (byte) 0x02;
	public static byte CAL_MINMAX = (byte) 0x03;
	public static byte CAL_DEFAULT = (byte) 0x04;
	public static byte GET_TYPEMODE = (byte) 0x05;
	public static byte GET_SYMBOL = (byte) 0x06;
	public static byte CAL_MIN = (byte) 0x07;
	public static byte CAL_MAX = (byte) 0x08;
	public static byte SETUP = (byte) 0x09;
	public static byte CLR_ALL = (byte) 0x0A;
	public static byte GET_RAW = (byte) 0x0B;
	public static byte GET_CONNECTION = (byte) 0x0C;
	public static byte STOP_ALL = (byte) 0x0D;
	public static byte GET_NAME = (byte) 0x15;
	public static byte GET_MODENAME = (byte) 0x16;
	public static byte SET_RAW = (byte) 0x17;
	public static byte GET_FIGURES = (byte) 0x18;
	public static byte GET_CHANGES = (byte) 0x19;
	public static byte CLR_CHANGES = (byte) 0x1A;
	public static byte READY_PCT = (byte) 0x1B;
	public static byte READY_RAW = (byte) 0x1C;
	public static byte READY_SI = (byte) 0x1D;
	public static byte GET_MINMAX = (byte) 0x1E;
	public static byte GET_BUMPS = (byte) 0x1F;
	
	// All motors
	public static byte ALL_MOTORS = (byte) 0x0f;
	
	// Layers
	public static byte LAYER_MASTER = (byte) 0x00;
	public static byte LAYER_SLAVE = (byte) 0x01;
	
	// Motor brakes
	public static byte COAST = (byte) 0x00;
	public static byte BRAKE = (byte) 0x01;
	
	// Input Device Mode
	// Sensor Type:
	public static byte TYPE_DEFAULT = (byte) 0x00;
	public static byte NXT_TOUCH = (byte) 0x01;
	public static byte NXT_LIGHT = (byte) 0x02;
	public static byte NXT_SOUND = (byte) 0x03;
	public static byte NXT_COLOR = (byte) 0x04;
	public static byte NXT_ULTRASONIC = (byte) 0x05;
	public static byte TOUCH = (byte) 0x10;
	public static byte COLOR = (byte) 0x1D;
	public static byte ULTRASONIC = (byte) 0x1E;
	
	// Sensor Mode:
	public static byte NOT_INITIALIZED = (byte) 0xff;
	public static byte MODE_DEFAULT = (byte) 0x00;
	/** Light */
	public static byte LIGHT_REFLECT = (byte) 0x00;
	public static byte LIGHT_AMBIENT = (byte) 0x01;
	/** Sound */
	public static byte SOUND_DB = (byte) 0x00;
	public static byte SOUND_DBA = (byte) 0x01;
	/** Touch */
	public static byte TOUCH_TOUCH = (byte) 0x00;
	public static byte TOUCH_BUMPS = (byte) 0x01;
	/** Color */
	public static byte COL_REFLECT = (byte) 0x00;
	public static byte COL_AMBIENT = (byte) 0x01;
	public static byte COL_COLOR = (byte) 0x02;
	public static byte COL_RGB = (byte) 0x04;
	/** Ultrasonic */
	public static byte US_CM = (byte) 0x00;
	public static byte US_INCH = (byte) 0x01;
	public static byte US_LISTEN = (byte) 0x02;
}
