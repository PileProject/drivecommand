package com.pile_drive.drivecommand.machine;

import com.pile_drive.drivecommand.model.ProtocolBase;

public class Machine {
	private ProtocolBase mProtocol;
	
	public Machine(ProtocolBase protocol) {
		mProtocol = protocol;
	}
	
	public void connect() {
		
	}
	
	public void disconnect() {
		
	}
	
	public LineSensor createLineSensor(int port) {
		return new LineSensor(port, mProtocol);
	}
	
	public Motor createMotor(int port) {
		return new Motor(port, mProtocol);
	}
}
