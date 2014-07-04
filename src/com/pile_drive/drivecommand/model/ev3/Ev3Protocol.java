package com.pile_drive.drivecommand.model.ev3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;
import com.pile_drive.drivecommand.model.com.ICommunicator;

public class Ev3Protocol extends ProtocolBase implements Ev3Constants {
	private static final String KEY_VALUE = "value";
	private static int TIMEOUT = 1000;
	
	public Ev3Protocol(ICommunicator comm) {
		super(comm);
	}
	
	@Override
	public void open() throws IOException {
		getCommunicator().open();
	}
	
	@Override
	public void close() {
		getCommunicator().close();
	}
	
	@Override
	public HashMap<String, Object> exec(int port, CommandBase cmd) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		CommandType type = cmd.getCommandType();
		switch (type) {
			case GET_COLOR_ILLUMINANCE: {
				// TOOD: NXT has own color sensor (NXT_COLOR).
				short[] values = getPercentValue(port, COLOR, COL_REFLECT, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_COLOR_RGB: {
				// TOOD: NXT has own color sensor (NXT_COLOR).
				short[] values = getPercentValue(port, COLOR, COL_RGB, 3);
				res.put(KEY_VALUE, values);
				break;
			}
			case GET_GYRO_ANGLE: {
				throw new UnsupportedOperationException("GET GYRO ANGLE Operation hasn't been implemented yet");
			}
			case GET_GYRO_RATE: {
				throw new UnsupportedOperationException("GET GYRO RATE Operation hasn't been implemented yet");
			}
			case GET_LINE_VALUE: {
				short[] values = getPercentValue(port, NXT_LIGHT, LIGHT_REFLECT, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_RANGEFINDER_DIST: {
				throw new UnsupportedOperationException("GET RANGEFINDER DIST Operation hasn't been implemented yet");
			}
			case GET_REMOTECONTROLLER_BUTTON: {
				throw new UnsupportedOperationException("GET REMOTECONTROLLER BUTTON Operation hasn't been implemented yet");
			}
			case GET_REMOTECONTROLLER_DIST: {
				throw new UnsupportedOperationException("GET REMOTECONTROLLER DIST Operation hasn't been implemented yet");
			}
			case GET_SERVO_ANGLE: {
				throw new UnsupportedOperationException("GET SERVO ANGLE Operation hasn't been implemented yet");
			}
			case GET_SOUND_DB: {
				float[] values = getSiValue(port, NXT_SOUND, SOUND_DB, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_TOUCH_COUNT: {
				float[] values = getSiValue(port, TOUCH, TOUCH_BUMPS, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case GET_TOUCH_TOUCHED: {
				float[] values = getSiValue(port, TOUCH, TOUCH_TOUCH, 1);
				res.put(KEY_VALUE, (int) values[0]);
				break;
			}
			case SET_BUZZER_BEEP: {
				soundTone(50, (short)10000, (short)1000);
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
				int speed = (Integer)args.get("speed");
				setOutputState(port, speed);
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
	private float[] getSiValue(int port, int type, int mode, int nvalue) {
		ByteCodeFormatter byteCode = new ByteCodeFormatter();
		byteCode.addOpCode(DIRECT_COMMAND_REPLY); // Command Types
		
		// TODO: NOT TESTED
		byteCode.addGlobalAndLocalBufferSize(4, 0);
		byteCode.addOpCode(INPUT_DEVICE);
		byteCode.addOpCode(READY_SI);
		byteCode.addParameter(LAYER_MASTER);
		byteCode.addParameter((byte) port);
		byteCode.addParameter((byte) type);
		byteCode.addParameter((byte) mode);
		byteCode.addParameter((byte) nvalue); // number of values
		byteCode.addGlobalIndex((byte) 0x00);
		
		// Send message
		getCommunicator().write(byteCode.byteArray(), TIMEOUT);
		
		byte[] reply = readData();
		
		// Check the validity of the response
//		boolean valid = (reply[2] == DIRECT_COMMAND_SUCCESS);
		
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
		byteCode.addOpCode(DIRECT_COMMAND_REPLY); // Command Types
		
		// TODO: NOT TESTED
		byteCode.addGlobalAndLocalBufferSize(1, 0);
		byteCode.addOpCode(INPUT_DEVICE);
		byteCode.addOpCode(READY_PCT);
		byteCode.addParameter(LAYER_MASTER);
		byteCode.addParameter((byte) port);
		byteCode.addParameter((byte) type);
		byteCode.addParameter((byte) mode);
		byteCode.addParameter((byte) nvalue);
		byteCode.addGlobalIndex((byte) 0x00);
		
		// Send message
		getCommunicator().write(byteCode.byteArray(), TIMEOUT);
		
		byte[] reply = readData();
		
		// Check the validity of the response
//		boolean valid = (reply[2] == DIRECT_COMMAND_SUCCESS);
		
		// Read the percent value in short type
		short[] result = new short[nvalue];
		for (int i = 0; i < nvalue; i++) {
			result[i] = (short) reply[3 + i];
		}
		return result;
	}
	
	/**
	 * Set output device condition.
	 * 
	 * @param port The port of the device
	 * @param speed The speed of the device
	 */
	private void setOutputState(int port, int speed) {
		ByteCodeFormatter byteCode = new ByteCodeFormatter();
		
		byteCode.addOpCode(DIRECT_COMMAND_NOREPLY);
		byteCode.addGlobalAndLocalBufferSize(0, 0);
		
		byteCode.addOpCode(OUTPUT_POWER);
		byteCode.addParameter(LAYER_MASTER);
		byteCode.addParameter(port);
		byteCode.addParameter((byte)speed);
		
		byteCode.addOpCode(OUTPUT_START);
		byteCode.addParameter(LAYER_MASTER);
		byteCode.addParameter(port);
		
		// Send message
		getCommunicator().write(byteCode.byteArray(), TIMEOUT);
	}
	
	/**
	 * Make a sound 
	 *  
	 * @param volume The volume of the sound (0 ~ 100 [%])
	 * @param freq The frequency 
	 * @param duration The duration of the tone
	 */
	private void soundTone(int volume, short freq, short duration) {
		ByteCodeFormatter byteCode = new ByteCodeFormatter();
		
		byteCode.addOpCode(DIRECT_COMMAND_REPLY);
		byteCode.addGlobalAndLocalBufferSize(0, 0);
		
		byteCode.addOpCode(SOUND_CONTROL);
		byteCode.addOpCode(SOUND_TONE);
		byteCode.addParameter(volume);
		byteCode.addParameter(freq);
		byteCode.addParameter(duration);
		
		// Send message
		getCommunicator().write(byteCode.byteArray(), TIMEOUT);
	}
	
	/**
	 * Read data from the device
	 * 
	 * @return
	 */
	private byte[] readData() {
		ICommunicator com = getCommunicator();
		
		// Calculate the size of response by reading 2 bytes.
		byte[] header = com.read(2, TIMEOUT);
		int numBytes = (int) ((0x00ff & header[0]) | (header[1] << 8));
		
		// Get result
		byte[] result = com.read(numBytes, TIMEOUT);
		
		return result;
	}
}
