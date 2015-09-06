package com.pileproject.drivecommand.model.ev3;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.MachineStatus;
import com.pileproject.drivecommand.machine.device.input.ColorSensor;
import com.pileproject.drivecommand.machine.device.input.GyroSensor;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.Rangefinder;
import com.pileproject.drivecommand.machine.device.input.RemoteControlReceiver;
import com.pileproject.drivecommand.machine.device.input.SoundSensor;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Buzzer;
import com.pileproject.drivecommand.machine.device.output.Led;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.output.Servomotor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

/**
 * LEGO MINDSTORMS EV3
 * @author Tatsuya Iwanari
 */
public class Ev3Machine extends MachineBase {
    public Ev3Machine(ProtocolBase protocol) {
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
        mStatus = status;
        return true;
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
        if (isValidOutputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new Motor(port, mProtocol);
    }

    @Override
    public Servomotor createServomotor(OutputPort port) {
        if (isValidOutputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new Servomotor(port, mProtocol);
    }

    @Override
    public Buzzer createBuzzer(OutputPort port) {
        if (isValidOutputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new Buzzer(port, mProtocol);
    }

    @Override
    public Led createLed(OutputPort port) {
        if (isValidOutputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new Led(port, mProtocol);
    }


    @Override
    public LineSensor createLineSensor(InputPort port) {
        if (isValidInputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new LineSensor(port, mProtocol);
    }

    @Override
    public TouchSensor createTouchSensor(InputPort port) {
        if (isValidInputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new TouchSensor(port, mProtocol);
    }

    @Override
    public SoundSensor createSoundSensor(InputPort port) {
        if (isValidInputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new SoundSensor(port, mProtocol);
    }
    @Override
    public GyroSensor createGyroSensor(InputPort port) {
        if (isValidInputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new GyroSensor(port, mProtocol);
    }

    @Override
    public ColorSensor createColorSensor(InputPort port) {
        if (isValidInputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new ColorSensor(port, mProtocol);
    }

    @Override
    public Rangefinder createRangefinder(InputPort port) {
        if (isValidInputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new Rangefinder(port, mProtocol);
    }

    @Override
    public RemoteControlReceiver createRemoteControlReceiver(InputPort port) {
        if (isValidInputPort(port)) {
            // TODO: what kind of exception should be thrown
            return null;
        }
        return new RemoteControlReceiver(port, mProtocol);
    }

}
