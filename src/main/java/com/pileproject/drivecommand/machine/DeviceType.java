package com.pileproject.drivecommand.machine;

public enum DeviceType {
	/**
	 * Motor
	 * cf. SERVOMOTOR
	 */
	MOTOR,
	
	/**
	 * Servomotor
	 * cf. MOTOR
	 */
	SERVOMOTOR,
	BUZZER,
	LED,
	
	/**
	 * Line sensor
	 * ex. Light sensor for ev3
	 */
	LINE_SENSOR,
	GYRO_SENSOR,
	TOUCH_SENSOR,
	COLOR_SENSOR,
	
	/**
	 * Range finder
	 * ex. Ultrasonic sensor for ev3
	 * */
	RANGEFINDER,
	SOUND_SENSOR,
	REMOTECONTROL_RECIEVER
}
