package com.pile_drive.drivecommand.model.nxt;

import static com.pile_drive.drivecommand.model.nxt.NxtConstants.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.pile_drive.drivecommand.util.Log;
import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;
import com.pile_drive.drivecommand.model.com.ICommunicator;

/**
 * @see <a href="http://sourceforge.net/projects/lejos/files/lejos-NXJ/">LeJOS</a>
 */
public class NxtProtocol extends ProtocolBase {
	private static final String KEY_VALUE = "value";
	private static final int TIMEOUT = 1000;
	private static final String TAG = "NxtProtocol";
	private static final int MAX_RES_LENGTH = 66;
	private Map<Integer, Byte> mPortTypes;
	
	public NxtProtocol(ICommunicator comm) {
		super(comm);
	}
	
	@Override
	public void open() throws IOException {
		mCommunicator.open();
		mPortTypes = new HashMap<Integer, Byte>();
	}
	
	@Override
	public void close() {
		mCommunicator.close();
		mPortTypes = null;
	}
	
	@Override
	public HashMap<String, Object> exec(int port, CommandBase cmd) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		CommandType type = cmd.getCommandType();
		switch (type) {
			case GET_COLOR_ILLUMINANCE: {
				throw new UnsupportedOperationException("GET COLOR ILLUMINANCE Operation hasn't been implemented yet");
			}
			case GET_COLOR_RGB: {
				throw new UnsupportedOperationException("GET COLOR RGB Operation hasn't been implemented yet");
							}
			case GET_GYRO_ANGLE: {
				throw new UnsupportedOperationException("GET GYRO ANGLE Operation hasn't been implemented yet");
			}
			case GET_GYRO_RATE: {
				throw new UnsupportedOperationException("GET GYRO RATE Operation hasn't been implemented yet");
			}
			case GET_LINE_VALUE: {
				setInputMode(port, LIGHT_ACTIVE, PCTFULLSCALEMODE);
				InputValues values = getInputValues(port);
				res.put(KEY_VALUE, (int) (values.scaledValue / 10));
				break;
			}
			case GET_RANGEFINDER_DIST: {
				throw new UnsupportedOperationException("GET RANGEFINDER DIST Operation hasn't been implemented yet");
			}
			case GET_REMOTECONTROLLER_BUTTON: {
				throw new UnsupportedOperationException("GET REMOTECONTROLLER BUTTON Operation hasn't been implemented yet");
			}
			case GET_REMOTECONTROLLER_DIST: {
				throw new UnsupportedOperationException("GET GET REMOTECONTROLLER DIST Operation hasn't been implemented yet");
			}
			case GET_SERVO_ANGLE: {
				throw new UnsupportedOperationException("GET SERVO ANGLE Operation hasn't been implemented yet");
			}
			case GET_SOUND_DB: {
				setInputMode(port, SOUND_DB, PCTFULLSCALEMODE);
				InputValues values = getInputValues(port);
				res.put(KEY_VALUE, (int) (values.scaledValue / 10));
				break;
			}
			case GET_TOUCH_COUNT: {
				throw new UnsupportedOperationException("GET TOUCH COUNT Operation hasn't been implemented yet");
			}
			case GET_TOUCH_TOUCHED: {
				setInputMode(port, SWITCH, BOOLEANMODE);
				InputValues values = getInputValues(port);
				res.put(KEY_VALUE, values.scaledValue < 600);
				break;
			}
			case SET_BUZZER_BEEP: {
				throw new UnsupportedOperationException("SET BUZZER BEEP Operation hasn't been implemented yet");
			}
			case SET_BUZZER_OFF: {
				throw new UnsupportedOperationException("SET BUZZER OFF Operation hasn't been implemented yet");
			}
			case SET_BUZZER_ON: {
				throw new UnsupportedOperationException("SET BUZZER ON Operation hasn't been implemented yet");
			}
			case SET_LED_OFF: {
				throw new UnsupportedOperationException("SET LED OFF Operation hasn't been implemented yet");
			}
			case SET_LED_ON: {
				throw new UnsupportedOperationException("SET LED ON Operation hasn't been implemented yet");
			}
			case SET_MOTOR_SPEED: {
				HashMap<String, Object> args = cmd.getArgs();
				int speed = (Integer) args.get("speed");
				setOutputState(port, speed, BRAKE + MOTORON + REGULATED,
						REGULATION_MODE_MOTOR_SPEED, 0, MOTOR_RUN_STATE_RUNNING, 0);
				break;
			}
			case SET_SERVO_ANGLE: {
				throw new UnsupportedOperationException("SET SERVO ANGLE Operation hasn't been implemented yet");
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
	 *            REGULATED). This field is a bitfield.
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
	
	private InputValues getInputValues(int port) {
		byte[] request = {
			DIRECT_COMMAND_REPLY,
			GET_INPUT_VALUES,
			(byte) port
		};
		sendData(request);
		byte[] reply = mCommunicator.read(MAX_RES_LENGTH, TIMEOUT);
		InputValues inputValues = new InputValues();
		inputValues.inputPort = reply[3];
		// 0 is false, 1 is true.
		inputValues.valid = (reply[4] != 0);
		// 0 is false, 1 is true.
		inputValues.isCalibrated = (reply[5] == 0);
		inputValues.sensorType = reply[6];
		inputValues.sensorMode = reply[7];
		inputValues.rawADValue = (short) ((0xFF & reply[8]) | ((0xFF & reply[9]) << 8));
		inputValues.normalizedADValue = (short) ((0xFF & reply[10]) | ((0xFF & reply[11]) << 8));
		inputValues.scaledValue = (short) ((0xFF & reply[12]) | ((0xFF & reply[13]) << 8));
		inputValues.calibratedValue = (short) ((0xFF & reply[14]) | ((0xFF & reply[15]) << 8));
		
		return inputValues;
	}
	
	/**
	 * Tells the NXT what type of sensor you are using and the mode to operate
	 * in.
	 * 
	 * @param port
	 *            The port of the device (0 ~ 3).
	 * @param sensorType
	 *            see NxtConstants
	 * @param sensorMode
	 *            see NxtConstants
	 */
	public void setInputMode(int port, int sensorType, int sensorMode) {
		// If the port is not initialized, set the mode
		if (!mPortTypes.containsKey(port) || sensorType != mPortTypes.get(port)) {
			// Save the setting to a map and set the mode of sensor
			mPortTypes.put(port, (byte) sensorType);
			Log.d(TAG, "port(" + port + ") is initailized to " + sensorType);
			
			byte[] request = {
				DIRECT_COMMAND_NOREPLY,
				SET_INPUT_MODE,
				(byte) port,
				(byte) sensorType,
				(byte) sensorMode
			};
			
			sendData(request);
			getInputValues(port); // Skip the first value (it may be invalid)
			
			// Sound sensor needs more initializing time based on our
			// experiments.
			if (sensorType == SOUND_DB) waitMillSeconds(250);
		}
	}
	
	/**
	 * A helper method to wait for specified milli seconds.
	 * 
	 * @param milliseconds
	 */
	private void waitMillSeconds(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean apply() {
		// this protocol does not support transactions.
		throw new UnsupportedOperationException("Nxt Protocol does not support transactions");
		// return false;
	}
}
