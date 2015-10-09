package com.pileproject.drivecommand.model.pile;

import com.pileproject.drivecommand.machine.device.port.DevicePortTypeMismatchException;
import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.MachineStatus;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.Rangefinder;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.model.pile.port.PileInputPort;

/**
 * PILE Robot
 *
 * @author Tatsuya Iwanari
 */
public class PileMachine extends MachineBase {
	public PileMachine(ProtocolBase protocol) {
		super(protocol);
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
		return false;
	}

	@Override
	public Motor createMotor(OutputPort port) {
		return new Motor(port, mProtocol);
	}

	@Override
	public LineSensor createLineSensor(InputPort port) {
		if (port.equals(PileInputPort.LINE_SENSOR_L)
				|| port.equals(PileInputPort.LINE_SENSOR_R)) {
			return new LineSensor(port, mProtocol);
		}

		throw new DevicePortTypeMismatchException( String.format(
                    "Expected: %s or %s, Actual %s",
                    PileInputPort.LINE_SENSOR_L,
                    PileInputPort.LINE_SENSOR_R,
                    port) );
	}

	@Override
	public TouchSensor createTouchSensor(InputPort port) {
		if (port.equals(PileInputPort.TOUCH_SENSOR)) {
			return new TouchSensor(port, mProtocol);
		}

		throw new DevicePortTypeMismatchException(
				"Expected: " + PileInputPort.TOUCH_SENSOR + ", Actual: " + port);
	}

	@Override
	public Rangefinder createRangefinder(InputPort port) {
		if (port.equals(PileInputPort.RANGEFINDER)) {
			return new Rangefinder(port, mProtocol);
		}

		throw new DevicePortTypeMismatchException(
				"Expected: " + PileInputPort.RANGEFINDER + ", Actual: " + port);
	}
}



