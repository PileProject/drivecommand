package com.pile_drive.drivecommand.machine.input;

import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class TouchSensor extends DeviceBase {
	
	public TouchSensor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Check this sensor is touched now
	 * 
	 * @return boolean
	 */
	public boolean isTouched() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_TOUCH_TOUCHED, null);
		HashMap<String, Object> res = exec(cmd);
		return ((Integer) res.get("value") == 1);
	}
	
	/**
	 * Get the touched count
	 * 
	 * @return number of count
	 */
	public int getTouchedCount() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_TOUCH_COUNT, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer) res.get("value");
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.TOUCH_SENSOR;
	}
}
