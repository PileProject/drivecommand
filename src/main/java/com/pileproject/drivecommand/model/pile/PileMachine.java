package com.pileproject.drivecommand.model.pile;

import com.pileproject.drivecommand.machine.Machine;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.Rangefinder;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Led;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.port.DevicePort;
import com.pileproject.drivecommand.model.ProtocolBase;

/**
 * PILE Robot
 * @author Tatsuya Iwanari
 */
public class PileMachine extends Machine {
    public PileMachine(ProtocolBase protocol) {
        super(protocol);
    }

    @Override
    public void apply() {
        mProtocol.apply();
    }

    @Override
    public Motor createMotor(DevicePort port) {
        return new Motor(port.getRaw(), mProtocol);
    }

    @Override
    public LineSensor createLineSensor(DevicePort port) {
        return new LineSensor(port.getRaw(), mProtocol);
    }

    @Override
    public Led createLed(DevicePort port) {
        return new Led(port.getRaw(), mProtocol);
    }

    @Override
    public TouchSensor createTouchSensor(DevicePort port) {
        return new TouchSensor(port.getRaw(), mProtocol);
    }

    @Override
    public Rangefinder createRangefinder(DevicePort port) {
        return new Rangefinder(port.getRaw(), mProtocol);
    }
}



