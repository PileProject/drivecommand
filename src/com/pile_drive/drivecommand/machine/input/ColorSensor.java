package com.pile_drive.drivecommand.machine.input;

import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class ColorSensor extends DeviceBase {
	
	public ColorSensor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Get the color in RGB (0 - 255)
	 * 
	 * @return byte[] (byte[0]: r, byte[1]: g, byte[2]: b)
	 */
	public byte[] getRgb() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_COLOR_RGB, null);
		HashMap<String, Object> res = exec(cmd);
		return (byte[]) res.get("value");
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
