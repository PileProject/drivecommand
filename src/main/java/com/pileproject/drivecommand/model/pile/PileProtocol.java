package com.pileproject.drivecommand.model.pile;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.model.com.ICommunicator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
	public Map<String, Object> exec(int port, CommandBase cmd) {
		HashMap<String, Object> res = new HashMap<String, Object>();
		CommandType type = cmd.getCommandType();
		switch (type) {
			case GET_LINE_VALUE: {
				int response = requestOneByte(port, PileConstants.CommandTypes.LINESENSOR);
				res.put(KEY_VALUE, response);
				break;
			}
			case GET_RANGEFINDER_DIST: {
				int response = requestOneByte(port, PileConstants.CommandTypes.DISTANCE);
				res.put(KEY_VALUE, 0xFF - response);
				break;
			}
			case GET_TOUCH_TOUCHED: {
				int response = requestOneByte(port, PileConstants.CommandTypes.TOUCH);
				res.put(KEY_VALUE, (response == 1));
				break;
			}
			case SET_MOTOR_SPEED: {
				Map<String, Object> args = cmd.getArgs();
				int speed = (Integer) args.get("speed");
				if (speed > 100 || speed < -100) {
					throw new UnsupportedOperationException(type.name() + "Speed is out of range: " + speed);
				}
				boolean ack = setMotor(port, speed);
				res.put(KEY_VALUE, (ack) ? 1 : 0);
				break;
			}
			case SET_LED_OFF: {
				boolean ack = switchLed(false);
				res.put(KEY_VALUE, (ack) ? 1 : 0);
				break;
			}
			case SET_LED_ON: {
				boolean ack = switchLed(true);
				res.put(KEY_VALUE, (ack) ? 1 : 0);
				break;
			}
				
			case GET_TOUCH_COUNT:
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
			case SET_SERVO_ANGLE: 
				throw new UnsupportedOperationException(type.name() + "Operation hasn't been implemented yet");
				
			default: {
				throw new UnsupportedOperationException("This Operation hasn't been implemented yet");
			}
		}
		return res;
	}
	
	private int requestOneByte(int port, PileConstants.CommandTypes type) {
		PilePacketFormatter packet = new PilePacketFormatter(type);
		packet.setDataByte((byte)port);
		packet.calculateChecksum();
		mCommunicator.write(packet.byteArray(), TIMEOUT);
		byte[] receivedByteArray = mCommunicator.read(4, TIMEOUT);
		packet = new PilePacketFormatter(receivedByteArray);
		if (!packet.isValid())
			return -1;
		return packet.data()[0] & 0xFF;
	}

	private boolean switchLed(boolean turnOn) {
		PilePacketFormatter packet = new PilePacketFormatter(PileConstants.CommandTypes.LED);
		packet.setDataByte((byte)(turnOn ? 
								PileConstants.LedState.ON.value() 
								: PileConstants.LedState.OFF.value()));
		packet.calculateChecksum();
		mCommunicator.write(packet.byteArray(), TIMEOUT);
		byte[] ack = mCommunicator.read(4, TIMEOUT);
		return ((ack[2] & 0x01) == 0x01) ? true : false;
	}
	
	private boolean setMotor(int port, int speed) {
		PileConstants.MotorDir dir = PileConstants.MotorDir.FORWARD;
		if (speed < 0) {
			dir = PileConstants.MotorDir.BACKWARD;
			speed = -speed;
		}
		PilePacketFormatter packet = new PilePacketFormatter(PileConstants.CommandTypes.MOVE);
		packet.setDataByte((byte)(((port&0x0F) << 2) | dir.value())); // Byte 0
		packet.setDataByte((byte)(speed&0xFF)); // Byte 1
		packet.calculateChecksum();
		mCommunicator.write(packet.byteArray(), TIMEOUT);
		byte[] ack = mCommunicator.read(4, TIMEOUT);
		return ((ack[2] & 0x01) == 0x01) ? true : false;
	}

	@Override
	public boolean apply() {
		PilePacketFormatter packet = new PilePacketFormatter(PileConstants.CommandTypes.APPLY);
		packet.setDataByte((byte)0); // any data (1 byte) is OK
		packet.calculateChecksum();
		mCommunicator.write(packet.byteArray(), TIMEOUT);
		byte[] ack = mCommunicator.read(4, TIMEOUT);
		return ((ack[2] & 0x01) == 0x01) ? true : false;
	}

	@Override
	public MachineBase createMachine() {
		return new PileMachine(this);
	}
}
