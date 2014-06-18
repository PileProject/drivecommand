package com.pile_drive.drivecommand.machine.input;

import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class GyroSensor extends DeviceBase {

	public GyroSensor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}

	public int getRate() {
		return 0;
	}

	@Override
	public DeviceType getDeviceType() {
		return null;
	}

	public int getAngle() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
	
}
