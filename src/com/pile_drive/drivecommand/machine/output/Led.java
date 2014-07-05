package com.pile_drive.drivecommand.machine.output;


import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class Led extends DeviceBase {
	
	public Led(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Turn on the LED if it is off
	 * 
	 * @return
	 */
	public void turnOn() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_LED_ON, null);
		exec(cmd);
	}
	
	/**
	 * Turn off the LED if it is on
	 * 
	 * @return
	 */
	public void turnOff() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_LED_OFF, null);
		exec(cmd);
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.LED;
	}
	
}
