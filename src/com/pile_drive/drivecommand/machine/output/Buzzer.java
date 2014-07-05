package com.pile_drive.drivecommand.machine.output;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class Buzzer extends DeviceBase {
	
	public Buzzer(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Turn on the buzzer if it is off
	 */
	public void turnOn() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_BUZZER_ON, null);
		exec(cmd);
	}
	
	/**
	 * Turn off the buzzer if it is on
	 */
	public void turnOff() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_BUZZER_OFF, null);
		exec(cmd);
	}
	
	/**
	 * Keep buzzer beeping
	 */
	public void beep() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_BUZZER_BEEP, null);
		exec(cmd);
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.BUZZER;
	}
	
}
