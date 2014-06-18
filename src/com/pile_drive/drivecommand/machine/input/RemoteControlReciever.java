package com.pile_drive.drivecommand.machine.input;

import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class RemoteControlReciever extends DeviceBase {

	public RemoteControlReciever(int port, ProtocolBase protocol) {
		super(port, protocol);
	}

	@Override
	public DeviceType getDeviceType() {
		return null;
	}

	public int getRemoteButton() {
		return 0;
	}

	public int getRate() {
		return 0;
	}
	
}
