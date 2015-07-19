package com.pile_drive.drivecommand.model.ev3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.util.Log;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;
import com.pile_drive.drivecommand.model.com.ICommunicator;

import static com.pile_drive.drivecommand.model.ev3.Ev3Constants.*;

public class Ev3Protocol extends ProtocolBase {
	private static final String KEY_VALUE = "value";
	private static final int TIMEOUT = 1000;
	private static final String TAG = "Ev3Protocol";
	private static final byte OUTPUTPORT_OFFSET = 0x10;
	
	public Ev3Protocol(ICommunicator comm) {
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
				// TOOD: EV3 also can use NXT's color sensor (NXT_COLOR). 
				// I should switch the types (EV3_COLOR/NXT_COLOR) based on the device info.
				short[] values = getPercentValue(port, EV3_COLOR, COL_REFLECT, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_COLOR_RGB: {
				// TOOD: EV3 also can use NXT's color sensor (NXT_COLOR). 
				// I should switch the types (EV3_COLOR/NXT_COLOR) based on the device info.
				// TODO: Reading value is failed because ev3 returns
				// DIRECT_COMMAND_FAILED.
				// So the byte code is something wrong.
				float[] values = getSiValue(port, EV3_COLOR, COL_RGB, 3);
				res.put(KEY_VALUE, values);
				break;
			}
			case GET_GYRO_ANGLE: {
				float[] value = getSiValue(port, EV3_GYRO, GYRO_ANGLE, 1);
				res.put(KEY_VALUE, (int) value[0]);
				break;
			}
			case GET_GYRO_RATE: {
				float[] value = getSiValue(port, EV3_GYRO, GYRO_RATE, 1);
				res.put(KEY_VALUE, (int) value[0]);
				break;
			}
			case GET_LINE_VALUE: {
				// TODO: NOT TESTED
				short[] values = getPercentValue(port, NXT_LIGHT, LIGHT_REFLECT, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_RANGEFINDER_DIST: {
				float[] values = getSiValue(port, EV3_ULTRASONIC, US_CM, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_REMOTECONTROLLER_BUTTON: {
				// TODO: NOT TESTED
				float[] values = getSiValue(port, EV3_IR, IR_REMOTE, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_REMOTECONTROLLER_DIST: {
				// TODO: NOT TESTED
				float[] values = getSiValue(port, EV3_IR, IR_SEEK, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_SERVO_ANGLE: {
				float[] values = getSiValue((OUTPUTPORT_OFFSET | port), L_MOTOR, L_MOTOR_DEGREE, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_SOUND_DB: {
				float[] values = getSiValue(port, NXT_SOUND, SOUND_DB, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_TOUCH_COUNT: {
				float[] values = getSiValue(port, EV3_TOUCH, TOUCH_BUMPS, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_TOUCH_TOUCHED: {
				float[] values = getSiValue(port, EV3_TOUCH, TOUCH_TOUCH, 1);
				res.put(KEY_VALUE, ((int) values[0]) == 1);
				break;
			}
			case SET_BUZZER_BEEP: {
				// TODO: maybe OK.
				// Indeed, it beeps but I'm not sure that the arguments (frep =
				// 600, duration = 200) are okay.
				soundTone(50, 600, 200);
				break;
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
				setOutputState(port, speed);
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
	 * Get SI unit value
	 * 
	 * @param port
	 *            The port of the device
	 * @param type
	 *            The device type
	 * @param mode
	 *            The mode of the device
	 * @param nvalue
	 *            The number of the response value
	 * @return
	 */
	@SuppressLint("NewApi")
	private float[] getSiValue(int port, int type, int mode, int nvalue) {
		ByteCodeFormatter byteCode = new ByteCodeFormatter();
		byteCode.addOpCode(DIRECT_COMMAND_REPLY);
		
		// TODO: NOT TESTED when nvalue is more than 2
		byteCode.addGlobalAndLocalBufferSize(4 * nvalue, 0);
		byteCode.addOpCode(INPUT_DEVICE);
		byteCode.addOpCode(READY_SI);
		byteCode.addParameter(LAYER_MASTER);
		byteCode.addParameter((byte) port);
		byteCode.addParameter((byte) type);
		byteCode.addParameter((byte) mode);
		byteCode.addParameter((byte) nvalue); // number of values
		byteCode.addGlobalIndex((byte) 0x00);
		
		// Send message
		mCommunicator.write(byteCode.byteArray(), TIMEOUT);
		
		byte[] reply = readData();
		
		// Check the validity of the response
		// boolean valid = (reply[2] == DIRECT_COMMAND_SUCCESS);
		
		// Read the SI unit value in float type
		float[] result = new float[nvalue];
		for (int i = 0; i < nvalue; i++) {
			byte[] data = Arrays.copyOfRange(reply, 3 + 4 * i, 7 + 4 * i);
			result[i] = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getFloat();
		}
		return result;
	}
	
	/**
	 * Get percent value
	 * 
	 * @param port
	 *            The port of the device
	 * @param type
	 *            The device type
	 * @param mode
	 *            The mode of the device
	 * @param nvalue
	 *            The number of the response value
	 * @return
	 */
	private short[] getPercentValue(int port, int type, int mode, int nvalue) {
		ByteCodeFormatter byteCode = new ByteCodeFormatter();
		byteCode.addOpCode(DIRECT_COMMAND_REPLY);
		
		// TODO: NOT TESTED when nvalue is more than 2
		byteCode.addGlobalAndLocalBufferSize(1 * nvalue, 0);
		byteCode.addOpCode(INPUT_DEVICE);
		byteCode.addOpCode(READY_PCT);
		byteCode.addParameter(LAYER_MASTER);
		byteCode.addParameter((byte) port);
		byteCode.addParameter((byte) type);
		byteCode.addParameter((byte) mode);
		byteCode.addParameter((byte) nvalue); // number of values
		byteCode.addGlobalIndex((byte) 0x00);
		
		// Send message
		mCommunicator.write(byteCode.byteArray(), TIMEOUT);
		
		byte[] reply = readData();
		
		// Check the validity of the response
		// boolean valid = (reply[2] == DIRECT_COMMAND_SUCCESS);
		
		// Read the percent value in short type
		short[] result = new short[nvalue];
		for (int i = 0; i < nvalue; i++) {
			result[i] = (short) reply[3 + i];
		}
		return result;
	}
	
	/**
	 * Convert output port to byte code port
	 * @param port
	 * @return
	 */
	private byte toByteCodePort(int port) {
		if (port >= 0x00 && port <= 0x03) return (byte)(0x01 << port);
		else return 0x00; // this will not happen
	}
	
	/**
	 * Set output device condition.
	 * 
	 * @param port
	 *            The port of the device
	 * @param speed
	 *            The speed of the device
	 */
	private void setOutputState(int port, int speed) {
		ByteCodeFormatter byteCode = new ByteCodeFormatter();
		
		// Convert port number
		byte byteCodePort = toByteCodePort(port);
		
		byteCode.addOpCode(DIRECT_COMMAND_NOREPLY);
		byteCode.addGlobalAndLocalBufferSize(0, 0);
		
		byteCode.addOpCode(OUTPUT_POWER);
		byteCode.addParameter(LAYER_MASTER);
		byteCode.addParameter(byteCodePort);
		byteCode.addParameter((byte) speed);
		
		byteCode.addOpCode(OUTPUT_START);
		byteCode.addParameter(LAYER_MASTER);
		byteCode.addParameter(byteCodePort);
		
		// Send message
		mCommunicator.write(byteCode.byteArray(), TIMEOUT);
	}
	
	/**
	 * Make a sound
	 * 
	 * @param volume
	 *            The volume of the sound (0 ~ 100 [%])
	 * @param freq
	 *            The frequency [Hz]
	 * @param duration
	 *            The duration of the tone [msec]
	 */
	private void soundTone(int volume, int freq, int duration) {
		ByteCodeFormatter byteCode = new ByteCodeFormatter();
		
		byteCode.addOpCode(DIRECT_COMMAND_NOREPLY);
		byteCode.addGlobalAndLocalBufferSize(0, 0);
		
		byteCode.addOpCode(SOUND_CONTROL);
		byteCode.addOpCode(SOUND_TONE);
		byteCode.addParameter((byte) volume);
		byteCode.addParameter((short) freq);
		byteCode.addParameter((short) duration);
		
		// Send message
		mCommunicator.write(byteCode.byteArray(), TIMEOUT);
	}
	
	/**
	 * Read data from the device
	 * 
	 * @return
	 */
	private byte[] readData() {
		// Calculate the size of response by reading 2 bytes.
		byte[] header = mCommunicator.read(2, TIMEOUT);
		int numBytes = (int) (((header[1] & 0x00ff) << 8) | (header[0] & 0x00ff) );
		
		// Get result
		byte[] result = mCommunicator.read(numBytes, TIMEOUT);
		Log.d(TAG, "read: " + result.length + " bytes");
		
		return result;
	}

	@Override
	public boolean apply() {
		// this protocol does not support transactions.
		throw new UnsupportedOperationException("Nxt Protocol does not support transactions");
		// return false;
	}
}
