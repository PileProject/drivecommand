package com.pileproject.drivecommand.model.pile;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.MachineStatus;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.Rangefinder;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Led;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

/**
 * PILE Robot
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

    private boolean isValidOutputPort(OutputPort port) {
        // TODO: implement
        return false;
    }

    private boolean isValidInputPort(InputPort port) {
        // TODO: implement
        return false;
    }

    @Override
    public Motor createMotor(OutputPort port) {
        return new Motor(port.getRaw(), mProtocol);
    }

    @Override
    public Led createLed(OutputPort port) {
        return new Led(port.getRaw(), mProtocol);
    }

    @Override
    public LineSensor createLineSensor(InputPort port) {
        return new LineSensor(port.getRaw(), mProtocol);
    }

    @Override
    public TouchSensor createTouchSensor(InputPort port) {
        return new TouchSensor(port.getRaw(), mProtocol);
    }

    @Override
    public Rangefinder createRangefinder(InputPort port) {
        return new Rangefinder(port.getRaw(), mProtocol);
    }
}



