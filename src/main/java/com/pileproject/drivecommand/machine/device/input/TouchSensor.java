package com.pileproject.drivecommand.machine.device.input;

import java.util.HashMap;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.device.DeviceBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

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
		return (Boolean) res.get("value");
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
