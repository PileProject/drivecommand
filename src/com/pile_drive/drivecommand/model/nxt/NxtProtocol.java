package com.pile_drive.drivecommand.model.nxt;

import java.io.IOException;
import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;
import com.pile_drive.drivecommand.model.com.ICommunicator;

public class NxtProtocol extends ProtocolBase {
	private static final String KEY_VALUE = "value";
	private static final int TIMEOUT = 1000;
	private static final String TAG = "NxtProtocol";
	
	public NxtProtocol(ICommunicator comm) {
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
			case GET_COLOR_ILLUMINANCE: {
				break;
			}
			case GET_COLOR_RGB: {
				break;
			}
			case GET_GYRO_ANGLE: {
				break;
			}
			case GET_GYRO_RATE: {
				break;
			}
			case GET_LINE_VALUE: {
				break;
			}
			case GET_RANGEFINDER_DIST: {
				break;
			}
			case GET_REMOTECONTROLLER_BUTTON: {
				break;
			}
			case GET_REMOTECONTROLLER_DIST: {
				break;
			}
			case GET_SERVO_ANGLE: {
				break;
			}
			case GET_SOUND_DB: {
				break;
			}
			case GET_TOUCH_COUNT: {
				break;
			}
			case GET_TOUCH_TOUCHED: {
				break;
			}
			case SET_BUZZER_BEEP: {
				break;
			}
			case SET_BUZZER_OFF: {
				break;
				}
			case SET_BUZZER_ON: {
				break;
			}
			case SET_LED_OFF: {
				break;
			}
			case SET_LED_ON: {
				break;
			}
			case SET_MOTOR_SPEED: {
				break;
			}
			case SET_SERVO_ANGLE: {
				break;
			}
			default: {
				throw new UnsupportedOperationException("This Operation hasn't been implemented yet");
			}
		}
		return res;
	}
}
