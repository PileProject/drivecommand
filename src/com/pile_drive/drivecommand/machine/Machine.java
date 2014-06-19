package com.pile_drive.drivecommand.machine;

import java.io.IOException;

import com.pile_drive.drivecommand.machine.input.ColorSensor;
import com.pile_drive.drivecommand.machine.input.GyroSensor;
import com.pile_drive.drivecommand.machine.input.LineSensor;
import com.pile_drive.drivecommand.machine.input.Rangefinder;
import com.pile_drive.drivecommand.machine.input.RemoteControlReciever;
import com.pile_drive.drivecommand.machine.input.SoundSensor;
import com.pile_drive.drivecommand.machine.input.TouchSensor;
import com.pile_drive.drivecommand.machine.output.Buzzer;
import com.pile_drive.drivecommand.machine.output.Led;
import com.pile_drive.drivecommand.machine.output.Motor;
import com.pile_drive.drivecommand.machine.output.Servomotor;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class Machine {
	private ProtocolBase mProtocol;
	
	public Machine(ProtocolBase protocol) {
		mProtocol = protocol;
	}
	
	public void connect() throws IOException{
		mProtocol.open();
	}
	
	public void disconnect() {
		mProtocol.close();
	}
	
	public LineSensor createLineSensor(int port) {
		return new LineSensor(port, mProtocol);
	}
	
	public Motor createMotor(int port) {
		return new Motor(port, mProtocol);
	}

	public Servomotor createServomotor(int port) {
		return new Servomotor(port, mProtocol);
	}

	public Buzzer createBuzzer(int port) {
		return new Buzzer(port, mProtocol);
	}

	public Led createLed(int port) {
		return new Led(port, mProtocol);
	}

	public GyroSensor createGyroSensor(int port) {
		return new GyroSensor(port, mProtocol);
	}

	public TouchSensor createTouchSensor(int port) {
		return new TouchSensor(port, mProtocol);
	}

	public ColorSensor createColorSensor(int port) {
		return new ColorSensor(port, mProtocol);
	}

	public Rangefinder createRangefinder(int port) {
		return new Rangefinder(port, mProtocol);
	}

	public SoundSensor createSoundSensor(int port) {
		return new SoundSensor(port, mProtocol);
	}

	public RemoteControlReciever createRemoteControlReciever(int port) {
		return new RemoteControlReciever(port, mProtocol);
	}

}
