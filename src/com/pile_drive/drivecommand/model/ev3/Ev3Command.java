package com.pile_drive.drivecommand.model.ev3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import android.util.Log;

/**
 * EV3Command contains easily accessible commands for the Lego EV3.
 * 
 * @author <a href="mailto:bbagnall@mts.net">Brian Bagnall</a>
 * @version 0.3 23-August-2006
 * 
 * @author <a href="mailto:tatsuyaw0c@gmail.com">Tatsuya Iwanari</a>
 * @version 1.1 23-Dec-2013
 */
public class Ev3Command implements Ev3Constants {
	
	private static Ev3Command singleton = new Ev3Command();
	
	private EV3Comm ev3Comm;
	
	// Ensure no one tries to instantiate this.
	private Ev3Command() {
	}
	
	/**
	 * Control output
	 * @param request
	 * @return success
	 */
	public boolean setOutputState(ByteCodeFormatter request) {
		ByteCodeFormatter command = new ByteCodeFormatter();
		
		command.addOpCode(DIRECT_COMMAND_NOREPLY);
		command.addGlobalAndLocalBufferSize(0, 0);
		
		command.appendCommand(request);
		
		return sendRequest(command.byteArray());
	}
	
	private String getString(byte[] request) {
		String result = null;
		
		ev3Comm.sendData(request);
		byte[] reply = ev3Comm.readData();
		
		// 0x04 is false, 0x02 is true.
		if (reply[2] == DIRECT_COMMAND_SUCCESS) {
			// Read the value and convert to String
			byte[] data = Arrays.copyOfRange(reply, 3, reply.length);
			result = new String(data);
		}
		else {
			return null;
		}
		
		Log.d("EV3Command", "Got String: " + result);
		return result.trim();
	}
	
	/**
	 * Get port name
	 * @param port
	 * @return
	 */
	public String getInputName(int port) {
		ByteCodeFormatter command = new ByteCodeFormatter();
		command.addOpCode(DIRECT_COMMAND_REPLY);	// Command Types
		
		// Set maximum reply size
		byte maxLength = 0x7f;
		
		// reply size
		command.addGlobalAndLocalBufferSize(maxLength, 0);
		
		command.addOpCode(INPUT_DEVICE);
		command.addOpCode(GET_NAME);
		command.addParameter(LAYER_MASTER);
		command.addParameter((byte)port);
		command.addParameter(maxLength);
		command.addGlobalIndex((byte)0x00);
		
		return getString(command.byteArray());
	}
	
	/**
	 * Get type and mode
	 * @param port
	 * @return
	 */
	public InputValues getTypeAndMode(int port) {
		ByteCodeFormatter command = new ByteCodeFormatter();
		command.addOpCode(DIRECT_COMMAND_REPLY);	// Command Types
		command.addGlobalAndLocalBufferSize(2, 0);
		
		command.addOpCode(INPUT_DEVICE);
		command.addOpCode(GET_TYPEMODE);
		command.addParameter(LAYER_MASTER);
		command.addParameter((byte)port);
		command.addGlobalIndex((byte)0x00);	// index for type
		command.addGlobalIndex((byte)0x01);	// index for mode
		
		ev3Comm.sendData(command.byteArray());
		
		byte[] reply = ev3Comm.readData();

		InputValues inputValues = new InputValues();
		
		// 0x04 is false, 0x02 is true.
		if (reply[2] == DIRECT_COMMAND_SUCCESS) {
			inputValues.type = reply[3];
			inputValues.mode = reply[4];
			inputValues.valid = true;
		}
		else
			inputValues.valid = false;
		
		return inputValues;
	}
	
	/**
	 * Get symbol of SI value
	 * e.g. cm = centimeter
	 * @param port
	 * @return
	 */
	public String getSymbol(int port) {
		ByteCodeFormatter command = new ByteCodeFormatter();
		command.addOpCode(DIRECT_COMMAND_REPLY);

		// Set maximum reply size
		byte maxLength = 0x10;
		command.addGlobalAndLocalBufferSize(maxLength, 0);
		
		command.addOpCode(INPUT_DEVICE);
		command.addOpCode(GET_SYMBOL);
		command.addParameter(LAYER_MASTER);
		command.addParameter((byte)port);
		command.addParameter(maxLength);
		command.addGlobalIndex((byte)0x00);
		
		return getString(command.byteArray());
	}
	
	/**
	 * Get mode name of sensor
	 * @param port
	 * @param mode
	 * @return String name of mode
	 */
	public String getModeName(int port, int mode) {
		ByteCodeFormatter command = new ByteCodeFormatter();
		command.addOpCode(DIRECT_COMMAND_REPLY);

		// Set maximum reply size
		byte maxLength = 0x7f;
		command.addGlobalAndLocalBufferSize(maxLength, 0);
		
		command.addOpCode(INPUT_DEVICE);
		command.addOpCode(GET_MODENAME);
		command.addParameter(LAYER_MASTER);
		command.addParameter((byte)port);
		command.addParameter((byte)mode);
		command.addParameter(maxLength);
		command.addGlobalIndex((byte)0x00);
		
		return getString(command.byteArray());
	}
	
	/**
	 * Get SI value
	 * @param port
	 * @param type
	 * @param mode
	 * @return
	 */
	public InputValues getInputSiValues(int port, int type, int mode) {
		ByteCodeFormatter command = new ByteCodeFormatter();
		command.addOpCode(DIRECT_COMMAND_REPLY);	// Command Types
		
		command.addGlobalAndLocalBufferSize(4, 0);
		command.addOpCode(INPUT_DEVICE);
		command.addOpCode(READY_SI);
		command.addParameter(LAYER_MASTER);
		command.addParameter((byte)port);
		command.addParameter((byte)type);
		command.addParameter((byte)mode);
		command.addParameter((byte)0x01);	// number of values
		command.addGlobalIndex((byte)0x00);
		
		ev3Comm.sendData(command.byteArray());
		
		byte[] reply = ev3Comm.readData();
		
		InputValues inputValues = new InputValues();
		// 0x04 is false, 0x02 is true.
		inputValues.valid = (reply[2] == DIRECT_COMMAND_SUCCESS);
		
		// Read the SI unit value in float type
		byte[] data = Arrays.copyOfRange(reply, 3, reply.length);
		inputValues.siUnitValue = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getFloat();
		return inputValues;
	}
	
	/**
	 * Get Percent value
	 * @param port
	 * @param type
	 * @param mode
	 * @return
	 */
	public InputValues getInputPercentValues(int port, int type, int mode) {
		ByteCodeFormatter command = new ByteCodeFormatter();
		command.addOpCode(DIRECT_COMMAND_REPLY);	// Command Types
		
		command.addGlobalAndLocalBufferSize(1, 0);
		command.addOpCode(INPUT_DEVICE);
		command.addOpCode(READY_PCT);
		command.addParameter(LAYER_MASTER);
		command.addParameter((byte)port);
		command.addParameter((byte)type);
		command.addParameter((byte)mode);
		command.addParameter((byte)0x01);	// number of values
		command.addGlobalIndex((byte)0x00);
		
		ev3Comm.sendData(command.byteArray());
		
		byte[] reply = ev3Comm.readData();
		
		InputValues inputValues = new InputValues();
		// 0x04 is false, 0x02 is true.
		inputValues.valid = (reply[2] == DIRECT_COMMAND_SUCCESS);
		
		// Read the percent value in short type
		inputValues.percentValue = (short) reply[3];
		return inputValues;
	}
	
	/**
	 * Small helper method to send request to EV3 and return verification
	 * result.
	 * 
	 * @param request
	 * @return
	 */
	private boolean sendRequest(byte[] request) throws RuntimeException {
		boolean verify = true;
		try {
			ev3Comm.sendData(request);
		}
		catch (RuntimeException e) {
			verify = false;
		}
		
		return verify;
	}
	
	public static void open() throws Exception {
		singleton.ev3Comm = AndroidComm.getInstance();
		try {
			singleton.ev3Comm.open();
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public static void close() {
		// Set all motors to be stopped.
		ByteCodeFormatter command = new ByteCodeFormatter();
		command.addOpCode(OUTPUT_STOP);
		command.addParameter(LAYER_MASTER);
		command.addParameter(ALL_MOTORS);
		command.addParameter(BRAKE);
		singleton.setOutputState(command);
		
		// Close the connection.
		singleton.ev3Comm.close();
	}
	
	public static Ev3Command getSingleton() {
		return singleton;
	}
	
}
