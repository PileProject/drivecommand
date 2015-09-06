package com.pileproject.drivecommand.model.nxt;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.MachineStatus;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.SoundSensor;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

/**
 * LEGO MINDSTORMS NXT
 *
 * @author Tatsuya Iwanari
 */
public class NxtMachine extends MachineBase {
	public static final int MAX_MOTOR_POWER = 900;
	public static final int INIT_MOTOR_POWER = 500;

	public static final class SensorProperty {
		public static final int NUMBER_OF_SENSORS = 3;
		public static final int NUMBER_OF_SENSOR_PORTS = 4;
		public static final int SENSOR_UNUSED = 0;
		public static final int SENSOR_TOUCH = 1;
		public static final int SENSOR_LINE = 2;
		public static final int SENSOR_SOUND = 3;

		public static final class LineSensor {
			public static final int PctMin = 0;
			public static final int PctMax = 100;
			public static final int DEFAULT = 50;
		}

		public static final class SoundSensor {
			public static final int SI_dB_SiMin = 40;
			public static final int SI_dB_SiMax = 120;
			public static final int SI_dB_DEFAULT = 70;
		}
	}

	public static final class MotorProperty {
		public static final int NUMBER_OF_MOTORS = 2;
		public static final int NUMBER_OF_MOTOR_PORTS = 3;
		public static final int MOTOR_UNUSED = 0;
		public static final int MOTOR_LEFT = 1;
		public static final int MOTOR_RIGHT = 2;
	}

	public NxtMachine(ProtocolBase protocol) {
		super(protocol);
		if (!(protocol instanceof NxtProtocol)) {
			// TODO: what kind of exception should be thrown
		}
	}

	@Override
	public void apply() {
		mProtocol.apply();
	}

	@Override
	public MachineStatus fetchStatus() {
		return mStatus;
	}

	@Override
	public boolean applyStatus(MachineStatus status) {
		mStatus = status;
		// TODO: give some information to this machine with the argument "status"
		// Is this necessary? We can update the status with each creation method
		return true;
	}

	@Override
	public Motor createMotor(OutputPort port) {
		if (isValidOutputPort(port)) {
			// TODO: what kind of exception should be thrown
			return null;
		}
		mStatus.bind(port, DeviceType.MOTOR);
		return new Motor(port, mProtocol);
	}

	@Override
	public LineSensor createLineSensor(InputPort port) {
		if (isValidInputPort(port)) {
			// TODO: what kind of exception should be thrown
			return null;
		}
		mStatus.bind(port, DeviceType.LINE_SENSOR);
		return new LineSensor(port, mProtocol);
	}

	@Override
	public TouchSensor createTouchSensor(InputPort port) {
		if (isValidInputPort(port)) {
			// TODO: what kind of exception should be thrown
			return null;
		}
		mStatus.bind(port, DeviceType.TOUCH_SENSOR);
		return new TouchSensor(port, mProtocol);
	}

	@Override
	public SoundSensor createSoundSensor(InputPort port) {
		if (isValidInputPort(port)) {
			// TODO: what kind of exception should be thrown
			return null;
		}
		mStatus.bind(port, DeviceType.SOUND_SENSOR);
		return new SoundSensor(port, mProtocol);
	}

	private boolean isValidInputPort(InputPort port) {
		int portId = port.getRaw();
		return port.isValid(mProtocol)
				&& portId >= 0 && portId < SensorProperty.NUMBER_OF_SENSOR_PORTS;
	}

	private boolean isValidOutputPort(OutputPort port) {
		int portId = port.getRaw();
		return port.isValid(mProtocol)
				&& portId >= 0 && portId < MotorProperty.NUMBER_OF_MOTOR_PORTS;
	}
}
