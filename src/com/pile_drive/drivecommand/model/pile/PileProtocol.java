package com.pile_drive.drivecommand.model.pile;

import java.io.IOException;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.util.Log;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;
import com.pile_drive.drivecommand.model.com.ICommunicator;

import static com.pile_drive.drivecommand.model.pile.PileConstants.*;

public class PileProtocol extends ProtocolBase {
	private static final String KEY_VALUE = "value";
	private static final int TIMEOUT = 1000;
	private static final String TAG = "PileProtocol";
	
	public PileProtocol(ICommunicator comm) {
		super(comm);
	}
	
	@Override
	public void open() throws IOException {
		mCommunicator.open();
	}
	
	@Override
	public void close() {
		mCommunicator.close();
	}
	
	@Override
	public HashMap<String, Object> exec(int port, CommandBase cmd) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		CommandType type = cmd.getCommandType();
		switch (type) {
			case GET_LINE_VALUE: {
				byte[] request = {0x00};
				mCommunicator.write(request, TIMEOUT);
				res.put(KEY_VALUE, mCommunicator.read(1, TIMEOUT));
//				short[] values = getPercentValue(port, /*type*/0, /*mode*/0, /*nvalue*/1);
//				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_RANGEFINDER_DIST: {
				byte[] request = {0x01};
				mCommunicator.write(request, TIMEOUT);
				res.put(KEY_VALUE, mCommunicator.read(1, TIMEOUT));
//				float[] values = getSiValue(port, /*type*/0, /*mode*/0, /*nvalue*/1);
//				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_TOUCH_COUNT: {
				byte[] request = {0x02};
				mCommunicator.write(request, TIMEOUT);
				res.put(KEY_VALUE, mCommunicator.read(1, TIMEOUT));
//				float[] values = getSiValue(port, /*type*/0, /*mode*/0, /*nvalue*/1);
//				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_TOUCH_TOUCHED: {
				byte[] request = {0x03};
				mCommunicator.write(request, TIMEOUT);
				res.put(KEY_VALUE, mCommunicator.read(1, TIMEOUT));
//				float[] values = getSiValue(port, /*type*/0, /*mode*/0, /*nvalue*/1);
//				res.put(KEY_VALUE, ((int) values[0]) == 1);
				break;
			}
			case SET_MOTOR_SPEED: {
				HashMap<String, Object> args = cmd.getArgs();
				int speed = (Integer) args.get("speed");
				if (speed > 100 || speed < -100) {
					throw new UnsupportedOperationException(type.name() + "Speed is out of range: " + speed);
				}
				boolean ack = setMotor(port, speed);
				res.put(KEY_VALUE, (ack) ? 1 : 0);
				break;
			}
			
			case GET_COLOR_ILLUMINANCE:
			case GET_COLOR_RGB:
			case GET_GYRO_ANGLE:
			case GET_GYRO_RATE: 
			case GET_REMOTECONTROLLER_BUTTON:
			case GET_REMOTECONTROLLER_DIST: 
			case GET_SERVO_ANGLE: 
			case GET_SOUND_DB: 
			case SET_BUZZER_BEEP: 
			case SET_BUZZER_OFF: 
			case SET_BUZZER_ON: 
			case SET_LED_OFF: 
			case SET_LED_ON: 
			case SET_SERVO_ANGLE: 
				throw new UnsupportedOperationException(type.name() + "Operation hasn't been implemented yet");
				
			default: {
				throw new UnsupportedOperationException("This Operation hasn't been implemented yet");
			}
		}
		return res;
	}
	
	private boolean setMotor(int port, int speed) {
		PileConstants.MotorDir dir = PileConstants.MotorDir.FORWARD;
		if (speed < 0) {
			dir = PileConstants.MotorDir.BACKWARD;
			speed = -speed;
		}
		PilePacketFormatter packet = new PilePacketFormatter(PileConstants.CommandTypes.MOVE);
		packet.setDataByte((byte)(((port&0x0F) << 2) | 0x01)); // Byte 0
		packet.setDataByte((byte)(speed&0xFF)); // Byte 1
		packet.calculateChecksum();
		mCommunicator.write(packet.byteArray(), TIMEOUT);
		byte[] ack = mCommunicator.read(4, TIMEOUT);
		System.out.println(ack.length);
		for (byte b : ack) {
			System.out.print(b);
			System.out.print(' ');
		}
		System.out.println();
		return ((ack[2] & 0x01) == 0x01) ? true : false;
	}
}
