package com.pile_drive.drivecommand.machine.output;

import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class Motor extends DeviceBase {
	private int mSpeed = 50;
	
	public Motor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}

	@Override
	public DeviceType getDeviceType() {
		return DeviceType.MOTOR;
	}
	
	/**
	 * Set speed (0-100%)
	 * if the speed is out of the range, 
	 * this method do nothing.
	 * @param speed
	 */
	public void setSpeed(int speed) {
		if (speed < 0 || speed > 100) return;
		mSpeed = speed;
	}

	public void forward() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void backward() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void stop() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public int getSpeed() {
		return mSpeed;
	}
}
