package com.pileproject.drivecommand.model.pile;

import com.pileproject.drivecommand.machine.Machine;
import com.pileproject.drivecommand.machine.input.Rangefinder;
import com.pileproject.drivecommand.machine.input.TouchSensor;
import com.pileproject.drivecommand.machine.output.Led;
import com.pileproject.drivecommand.machine.output.Motor;
import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.machine.input.LineSensor;

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
    public LineSensor createLineSensor(int port) {
        return new LineSensor(port, mProtocol);
    }

    @Override
    public Motor createMotor(int port) {
        return new Motor(port, mProtocol);
    }

    @Override
    public Led createLed(int port) {
        return new Led(port, mProtocol);
    }

    @Override
    public TouchSensor createTouchSensor(int port) {
        return new TouchSensor(port, mProtocol);
    }

    @Override
    public Rangefinder createRangefinder(int port) {
        return new Rangefinder(port, mProtocol);
    }
}



