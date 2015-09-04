package com.pileproject.drivecommand.machine;

import java.io.IOException;

import com.pileproject.drivecommand.machine.device.port.DevicePort;
import com.pileproject.drivecommand.machine.device.input.ColorSensor;
import com.pileproject.drivecommand.machine.device.input.GyroSensor;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.Rangefinder;
import com.pileproject.drivecommand.machine.device.input.RemoteControlReceiver;
import com.pileproject.drivecommand.machine.device.input.SoundSensor;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Buzzer;
import com.pileproject.drivecommand.machine.device.output.Led;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.output.Servomotor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
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
	public Motor createMotor(OutputPort port) {
		throw new UnsupportedOperationException("This machine does not support Motor");
	}

	/**
	 * Create Servomotor
	 * 
	 * @param port
	 * @return
	 */
	public Servomotor createServomotor(OutputPort port) {
		throw new UnsupportedOperationException("This machine does not support Servomotor");
	}

	/**
	 * Create Buzzer
	 * 
	 * @param port
	 * @return
	 */
	public Buzzer createBuzzer(OutputPort port) {
		throw new UnsupportedOperationException("This machine does not support Buzzer");
	}

	/**
	 * Create LED
	 * 
	 * @param port
	 * @return
	 */
	public Led createLed(OutputPort port) {
		throw new UnsupportedOperationException("This machine does not support LED");
	}

	/**
	 * Create LineDevice
	 *
	 * @param port
	 * @return
	 */
	public LineSensor createLineSensor(InputPort port) {
		throw new UnsupportedOperationException("This machine does not support LineSensor");
	}

	/**
	 * Create GyroSensor
	 * 
	 * @param port
	 * @return
	 */
	public GyroSensor createGyroSensor(InputPort port) {
		throw new UnsupportedOperationException("This machine does not support GyroSensor");
	}

	/**
	 * Create TouchSensor
	 * 
	 * @param port
	 * @return
	 */
	public TouchSensor createTouchSensor(InputPort port) {
		throw new UnsupportedOperationException("This machine does not support TouchSensor");
	}

	/**
	 * Create ColorSensor
	 * 
	 * @param port
	 * @return
	 */
	public ColorSensor createColorSensor(InputPort port) {
		throw new UnsupportedOperationException("This machine does not support ColorSensor");
	}

	/**
	 * Create Rangefinder
	 * 
	 * @param port
	 * @return
	 */
	public Rangefinder createRangefinder(InputPort port) {
		throw new UnsupportedOperationException("This machine does not support Rangefinder");
	}

	/**
	 * Create SoundSensor
	 * 
	 * @param port
	 * @return
	 */
	public SoundSensor createSoundSensor(InputPort port) {
		throw new UnsupportedOperationException("This machine does not support SoundSensor");
	}

	/**
	 * Create RemoteControlReciever
	 * 
	 * @param port
	 * @return
	 */
	public RemoteControlReceiver createRemoteControlReceiver(InputPort port) {
		throw new UnsupportedOperationException("This machine does not support RemoteControlReceiver");
	}
}
