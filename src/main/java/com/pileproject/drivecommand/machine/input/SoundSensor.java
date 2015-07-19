package com.pileproject.drivecommand.machine.input;

import java.util.HashMap;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.DeviceBase;
import com.pileproject.drivecommand.machine.DeviceType;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

public class SoundSensor extends DeviceBase {
	
	public SoundSensor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Get the sound in dB
	 * 
	 * @return dB
	 */
	public int getDb() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_SOUND_DB, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer) res.get("value");
	}
	
	@Override
	public DeviceType getDeviceType() {
		return DeviceType.SOUND_SENSOR;
	}
}
