package com.pileproject.drivecommand.model.ev3;

import com.pileproject.drivecommand.machine.DevicePort;
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
    public LineSensor createLineSensor(DevicePort port) {
        return new LineSensor(port.getRaw(), mProtocol);
    }

    @Override
    public Motor createMotor(DevicePort port) {
        return new Motor(port.getRaw(), mProtocol);
    }

    @Override
    public TouchSensor createTouchSensor(DevicePort port) {
        return new TouchSensor(port.getRaw(), mProtocol);
    }

    @Override
    public SoundSensor createSoundSensor(DevicePort port) {
        return new SoundSensor(port.getRaw(), mProtocol);
    }

    @Override
    public Servomotor createServomotor(DevicePort port) {
        return new Servomotor(port.getRaw(), mProtocol);
    }

    @Override
    public Buzzer createBuzzer(DevicePort port) {
        return new Buzzer(port.getRaw(), mProtocol);
    }

    @Override
    public Led createLed(DevicePort port) {
        return new Led(port.getRaw(), mProtocol);
    }

    @Override
    public GyroSensor createGyroSensor(DevicePort port) {
        return new GyroSensor(port.getRaw(), mProtocol);
    }

    @Override
    public ColorSensor createColorSensor(DevicePort port) {
        return new ColorSensor(port.getRaw(), mProtocol);
    }

    @Override
    public Rangefinder createRangefinder(DevicePort port) {
        return new Rangefinder(port.getRaw(), mProtocol);
    }

    @Override
    public RemoteControlReceiver createRemoteControlReceiver(DevicePort port) {
        return new RemoteControlReceiver(port.getRaw(), mProtocol);
    }

}
