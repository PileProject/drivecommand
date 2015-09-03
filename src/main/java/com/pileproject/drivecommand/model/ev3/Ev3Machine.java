package com.pileproject.drivecommand.model.ev3;

import com.pileproject.drivecommand.machine.Machine;
import com.pileproject.drivecommand.machine.input.ColorSensor;
import com.pileproject.drivecommand.machine.input.GyroSensor;
import com.pileproject.drivecommand.machine.input.Rangefinder;
import com.pileproject.drivecommand.machine.input.RemoteControlReceiver;
import com.pileproject.drivecommand.machine.input.SoundSensor;
import com.pileproject.drivecommand.machine.input.TouchSensor;
import com.pileproject.drivecommand.machine.output.Buzzer;
import com.pileproject.drivecommand.machine.output.Led;
import com.pileproject.drivecommand.machine.output.Motor;
import com.pileproject.drivecommand.machine.output.Servomotor;
import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.machine.input.LineSensor;

/**
 * LEGO MINDSTORMS EV3
 * @author Tatsuya Iwanari
 */
public class Ev3Machine extends Machine {
    public Ev3Machine(ProtocolBase protocol) {
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
    public TouchSensor createTouchSensor(int port) {
        return new TouchSensor(port, mProtocol);
    }

    @Override
    public SoundSensor createSoundSensor(int port) {
        return new SoundSensor(port, mProtocol);
    }

    @Override
    public Servomotor createServomotor(int port) {
        return new Servomotor(port, mProtocol);
    }

    @Override
    public Buzzer createBuzzer(int port) {
        return new Buzzer(port, mProtocol);
    }

    @Override
    public Led createLed(int port) {
        return new Led(port, mProtocol);
    }

    @Override
    public GyroSensor createGyroSensor(int port) {
        return new GyroSensor(port, mProtocol);
    }

    @Override
    public ColorSensor createColorSensor(int port) {
        return new ColorSensor(port, mProtocol);
    }

    @Override
    public Rangefinder createRangefinder(int port) {
        return new Rangefinder(port, mProtocol);
    }

    @Override
    public RemoteControlReceiver createRemoteControlReceiver(int port) {
        return new RemoteControlReceiver(port, mProtocol);
    }

}
