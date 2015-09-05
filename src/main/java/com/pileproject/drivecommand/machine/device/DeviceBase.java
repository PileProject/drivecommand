package com.pileproject.drivecommand.machine.device;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.port.DevicePort;
import com.pileproject.drivecommand.model.ProtocolBase;

import java.util.HashMap;

public abstract class DeviceBase {
	private final DevicePort mPort;
	private final ProtocolBase mProtocol;
	
	/**
	 * Constructor
	 * 
	 * @param port
	 */
	public DeviceBase(DevicePort port, ProtocolBase protocol) {
		mPort = port;
		mProtocol = protocol;
	}
	
	/**
	 * Execute command
	 * 
	 * @param command
	 * @return result
	 */
	protected HashMap<String, Object> exec(CommandBase command) {
		return mProtocol.exec(mPort.getRaw(), command);
	}
	
	public abstract DeviceType getDeviceType();
}
