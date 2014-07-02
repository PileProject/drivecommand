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
		CommandType type = cmd.getCommandType();
		switch (type) {
			case GET_COLOR_ILLUMINANCE:
				break;
			case GET_COLOR_RGB:
				break;
			case GET_GYRO_ANGLE:
				break;
			case GET_GYRO_RATE:
				break;
			case GET_LINE_VALUE:
				break;
			case GET_RANGEFINDER_DIST:
				break;
			case GET_REMOTECONTROLLER_BUTTON:
				break;
			case GET_REMOTECONTROLLER_DIST:
				break;
			case GET_SERVO_ANGLE:
				break;
			case GET_SOUND_DB:
				break;
			case GET_TOUCH_COUNT:
				break;
			case GET_TOUCH_TOUCHED:
				break;
			case SET_BUZZER_BEEP:
				break;
			case SET_BUZZER_OFF:
				break;
			case SET_BUZZER_ON:
				break;
			case SET_LED_OFF:
				break;
			case SET_LED_ON:
				break;
			case SET_MOTOR_SPEED:
				break;
			case SET_SERVO_ANGLE:
				break;
			default:
				break;
		
		}
		return null;
	}
	
	/**
	 * Get SI unit value
	 * 
	 * @param port The port of the device
	 * @param type The device type
	 * @param mode The mode of the device
	 * @return
	 */
	private byte[] getSiValue(int port, int type, int mode) {
		ByteCodeFormatter byteCode = new ByteCodeFormatter();
		byteCode.addOpCode(DIRECT_COMMAND_REPLY); // Command Types
		
		byteCode.addGlobalAndLocalBufferSize(4, 0);
		byteCode.addOpCode(INPUT_DEVICE);
		byteCode.addOpCode(READY_SI);
		byteCode.addParameter(LAYER_MASTER);
		byteCode.addParameter((byte) port);
		byteCode.addParameter((byte) type);
		byteCode.addParameter((byte) mode);
		byteCode.addParameter((byte) 0x01); // number of values
		byteCode.addGlobalIndex((byte) 0x00);
		
		ICommunicator com = getCommunicator();
		com.write(byteCode.byteArray(), TIMEOUT);
		
		byte[] reply = readData();
		
		// 0x04 is false, 0x02 is true.
		boolean valid = (reply[2] == DIRECT_COMMAND_SUCCESS);
		
		// Read the SI unit value in float type
		byte[] data = Arrays.copyOfRange(reply, 3, reply.length);
		float val = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getFloat();
		return null;
	}
	
	/**
	 * Get percent value
	 * 
	 * @param port The port of the device
	 * @param type The device type 
	 * @param mode The mode of the device
	 * @return
	 */
	private byte[] getPercentValue(int port, int type, int mode) {
		ByteCodeFormatter byteCode = new ByteCodeFormatter();
		byteCode.addOpCode(DIRECT_COMMAND_REPLY);	// Command Types
		
		byteCode.addGlobalAndLocalBufferSize(1, 0);
		byteCode.addOpCode(INPUT_DEVICE);
		byteCode.addOpCode(READY_PCT);
		byteCode.addParameter(LAYER_MASTER);
		byteCode.addParameter((byte)port);
		byteCode.addParameter((byte)type);
		byteCode.addParameter((byte)mode);
		byteCode.addParameter((byte)0x01);	// number of values
		byteCode.addGlobalIndex((byte)0x00);
		
		ICommunicator com = getCommunicator();
		com.write(byteCode.byteArray(), TIMEOUT);
		
		byte[] reply = readData();
		
		// 0x04 is false, 0x02 is true.
		boolean valid = (reply[2] == DIRECT_COMMAND_SUCCESS);
		
		// Read the percent value in short type
		short percentValue = (short) reply[3];
		return null;
	}
	
	private void setOutputState(ByteCodeFormatter request) {
		ByteCodeFormatter byteCode = new ByteCodeFormatter();
		
		byteCode.addOpCode(DIRECT_COMMAND_NOREPLY);
		byteCode.addGlobalAndLocalBufferSize(0, 0);
		
		byteCode.appendCommand(request);
		
		ICommunicator com = getCommunicator();
		com.write(byteCode.byteArray(), TIMEOUT);
	}
	
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
