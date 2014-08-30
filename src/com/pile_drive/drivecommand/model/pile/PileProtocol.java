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
				byte[] request = {0x04};
				mCommunicator.write(request, TIMEOUT);
				res.put(KEY_VALUE, mCommunicator.read(1, TIMEOUT));
//				HashMap<String, Object> args = cmd.getArgs();
//				int speed = (Integer) args.get("speed");
//				setOutputState(port, speed);
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
		// TODO this is a sample
		byte[] request = {0x00, (byte)port, (byte)type, (byte)mode, (byte)nvalue};

		// Send message
		mCommunicator.write(request, TIMEOUT);
		
		// TODO use reply values
		byte[] reply = readData();
		
		float[] result = null;
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
		// TODO this is a sample
		byte[] request = {0x01, (byte)port, (byte)type, (byte)mode, (byte)nvalue};

		// Send message
		mCommunicator.write(request, TIMEOUT);
		
		// TODO use reply values
		byte[] reply = readData();
		
		// Read the percent value in short type
		short[] result = new short[nvalue];
		return result;
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
		// TODO this is a sample
		byte[] request = {0x00, (byte)port, (byte)speed};
		
		// Send message
		mCommunicator.write(request, TIMEOUT);
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
}
