package com.pileproject.drivecommand.machine;

import java.io.IOException;

import com.pileproject.drivecommand.machine.input.ColorSensor;
import com.pileproject.drivecommand.machine.input.GyroSensor;
import com.pileproject.drivecommand.machine.input.LineSensor;
import com.pileproject.drivecommand.machine.input.Rangefinder;
import com.pileproject.drivecommand.machine.input.RemoteControlReceiver;
import com.pileproject.drivecommand.machine.input.SoundSensor;
import com.pileproject.drivecommand.machine.input.TouchSensor;
import com.pileproject.drivecommand.machine.output.Buzzer;
import com.pileproject.drivecommand.machine.output.Led;
import com.pileproject.drivecommand.machine.output.Motor;
import com.pileproject.drivecommand.machine.output.Servomotor;
import com.pileproject.drivecommand.model.ProtocolBase;

public abstract class Machine {
	protected ProtocolBase mProtocol;
	
	public Machine(ProtocolBase protocol) {
		mProtocol = protocol;
	}
	
	/**
	 * Connect to device
	 * 
	 * @throws IOException
	 */
	public void connect() throws IOException {
		mProtocol.open();
	}
	
	/**
	 * Disconnect from device
	 */
	public void disconnect() {
		mProtocol.close();
	}
	
	/**
	 * Transaction apply command
	 * for Pile Robot
	 */
	public void apply() {
		throw new UnsupportedOperationException("This machine does not support 'apply' command");
	}
	
	/**
	 * Create Motor
	 * 
	 * @param port
	 * @return
	 */
	public Motor createMotor(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support Motor");
	}

	/**
	 * Create Servomotor
	 * 
	 * @param port
	 * @return
	 */
	public Servomotor createServomotor(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support Servomotor");
	}

	/**
	 * Create Buzzer
	 * 
	 * @param port
	 * @return
	 */
	public Buzzer createBuzzer(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support Buzzer");
	}

	/**
	 * Create LED
	 * 
	 * @param port
	 * @return

	public Led createLed(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support LED");
	}

	/**
	 * Create LineDevice
	 *
	 * @param port
	 * @return
	 */
	public LineSensor createLineSensor(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support LineSensor");
	}

	/**
	 * Create GyroSensor
	 * 
	 * @param port
	 * @return
	 */
	public GyroSensor createGyroSensor(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support GyroSensor");
	}

	/**
	 * Create TouchSensor
	 * 
	 * @param port
	 * @return
	 */
	public TouchSensor createTouchSensor(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support TouchSensor");
	}

	/**
	 * Create ColorSensor
	 * 
	 * @param port
	 * @return
	 */
	public ColorSensor createColorSensor(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support ColorSensor");
	}

	/**
	 * Create Rangefinder
	 * 
	 * @param port
	 * @return
	 */
	public Rangefinder createRangefinder(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support Rangefinder");
	}

	/**
	 * Create SoundSensor
	 * 
	 * @param port
	 * @return
	 */
	public SoundSensor createSoundSensor(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support SoundSensor");
	}

	/**
	 * Create RemoteControlReciever
	 * 
	 * @param port
	 * @return
	 */
	public RemoteControlReceiver createRemoteControlReceiver(DevicePort port) {
		throw new UnsupportedOperationException("This machine does not support RemoteControlReceiver");
	}
}
