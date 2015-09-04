package com.pileproject.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.device.DeviceBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

import java.util.HashMap;

public class ColorSensor extends DeviceBase {
	
	public ColorSensor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Get the color in RGB (0 - 255)
	 * 
	 * TODO: this method doesn't return proper value.
	 * 
	 * @return float[] ([0]: r, [1]: g, [2]: b)
	 */
	public float[] getRgb() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_COLOR_RGB, null);
		HashMap<String, Object> res = exec(cmd);
		return (float[]) res.get("value");
	}
	
	/**
	 * Get the illuminance in percent (0 - 100)
	 * 
	 * @return int (0 - 100 %)
	 */
	public int getIlluminace() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_COLOR_ILLUMINANCE, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer) res.get("value");
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.COLOR_SENSOR;
	}
}
