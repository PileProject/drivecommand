package com.pile_drive.drivecommand.model.nxt;

import static com.pile_drive.drivecommand.model.nxt.NxtConstants.*;

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
				HashMap<String, Object> args = cmd.getArgs();
				int speed = (Integer) args.get("speed");
				setOutputState(port, speed, BRAKE + MOTORON + REGULATED,
						REGULATION_MODE_MOTOR_SPEED, 0, MOTOR_RUN_STATE_RUNNING, 0);
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
	
	/**
	 * Set output device condition.
	 * 
	 * @param port
	 *            The port of the device (0 ~ 3).
	 * @param speed
	 *            The speed of the device.
	 * @param mode
	 *            The mode of the device. (ex. MOTORON, BRAKE, and/or
	 *            REGULATED).This field is a bitfield.
	 * @param regulationMode
	 *            see NxtConstants.
	 * @param turnRatio
	 *            Use this parameter to move more than two motor.
	 * @param runState
	 *            see NxtConstants.
	 * @param tachoLimit
	 *            - Number of degrees to rotate before stopping.
	 */
	private void setOutputState(int port, int speed, int mode,
			int regulationMode, int turnRatio, int runState, int tachoLimit) {
		byte[] request = {
			DIRECT_COMMAND_NOREPLY,
			SET_OUTPUT_STATE,
			(byte) port,
			(byte) speed,
			(byte) mode,
			(byte) regulationMode,
			(byte) turnRatio,
			(byte) runState,
			(byte) tachoLimit,
			(byte) (tachoLimit >>> 8),
			(byte) (tachoLimit >>> 16),
			(byte) (tachoLimit >>> 24)
		};
		// Send request
		sendData(request);
	}
	
	/**
	 * A small helper to send data. This method calculates the size of the data
	 * and append it to the data.
	 * 
	 * @param request
	 */
	private void sendData(byte[] request) {
		// Calculate the size of request and append them.
		byte[] data = new byte[request.length + 2];
		data[0] = (byte) request.length;
		data[1] = (byte) (request.length >> 8);
		System.arraycopy(request, 0, data, 2, request.length);
		
		// Send request
		mCommunicator.write(data, TIMEOUT);
	}
}
