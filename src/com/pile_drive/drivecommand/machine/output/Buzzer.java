package com.pile_drive.drivecommand.machine.output;

import java.util.HashMap;

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
	 * 
	 * @return
	 */
	public boolean turnOn() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_BUZZER_ON, null);
		HashMap<String, Object> res = exec(cmd);
		return (Boolean) res.get("valid");
	}
	
	/**
	 * Turn off the buzzer if it is on
	 * 
	 * @return
	 */
	public boolean turnOff() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_BUZZER_OFF, null);
		HashMap<String, Object> res = exec(cmd);
		return (Boolean) res.get("valid");
	}
	
	/**
	 * Keep buzzer beeping
	 * 
	 * @return
	 */
	public boolean beep() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_BUZZER_BEEP, null);
		HashMap<String, Object> res = exec(cmd);
		return (Boolean) res.get("valid");
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.BUZZER;
	}
	
}
