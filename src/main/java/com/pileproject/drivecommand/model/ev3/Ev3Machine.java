/*
 * Copyright (C) 2011-2015 PILE Project, Inc. <dev@pileproject.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.pileproject.drivecommand.model.ev3;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.MachineStatus;
import com.pileproject.drivecommand.machine.device.DeviceType;
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
import com.pileproject.drivecommand.machine.device.port.DevicePortTypeMismatchException;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.com.ICommunicator;
import com.pileproject.drivecommand.model.ev3.port.Ev3InputPort;
import com.pileproject.drivecommand.model.ev3.port.Ev3OutputPort;

/**
 * LEGO MINDSTORMS EV3
 *
 * @author Tatsuya Iwanari
 */
public class Ev3Machine extends MachineBase {

    public Ev3Machine(ICommunicator comm) {
        super(new Ev3Protocol(comm));
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
    public Motor createMotor(OutputPort port) {
        checkOutputPortCompatibility(port);

        mStatus.bind(port, DeviceType.MOTOR);
        return new Motor(port, mProtocol);
    }

    @Override
    public Servomotor createServomotor(OutputPort port) {
        checkOutputPortCompatibility(port);

        mStatus.bind(port, DeviceType.SERVOMOTOR);
        return new Servomotor(port, mProtocol);
    }

    @Override
    public Buzzer createBuzzer(OutputPort port) {
        checkOutputPortCompatibility(port);

        mStatus.bind(port, DeviceType.BUZZER);
        return new Buzzer(port, mProtocol);
    }

    @Override
    public Led createLed(OutputPort port) {
        checkOutputPortCompatibility(port);

        mStatus.bind(port, DeviceType.LED);
        return new Led(port, mProtocol);
    }

    @Override
    public LineSensor createLineSensor(InputPort port) {
        checkInputPortCompatibility(port);

        mStatus.bind(port, DeviceType.LINE_SENSOR);
        return new LineSensor(port, mProtocol);
    }

    @Override
    public TouchSensor createTouchSensor(InputPort port) {
        checkInputPortCompatibility(port);

        mStatus.bind(port, DeviceType.TOUCH_SENSOR);
        return new TouchSensor(port, mProtocol);
    }

    @Override
    public SoundSensor createSoundSensor(InputPort port) {
        checkInputPortCompatibility(port);

        mStatus.bind(port, DeviceType.SOUND_SENSOR);
        return new SoundSensor(port, mProtocol);
    }

    @Override
    public GyroSensor createGyroSensor(InputPort port) {
        checkInputPortCompatibility(port);

        mStatus.bind(port, DeviceType.GYRO_SENSOR);
        return new GyroSensor(port, mProtocol);
    }

    @Override
    public ColorSensor createColorSensor(InputPort port) {
        checkInputPortCompatibility(port);

        mStatus.bind(port, DeviceType.COLOR_SENSOR);
        return new ColorSensor(port, mProtocol);
    }

    @Override
    public Rangefinder createRangefinder(InputPort port) {
        checkInputPortCompatibility(port);

        mStatus.bind(port, DeviceType.RANGEFINDER);
        return new Rangefinder(port, mProtocol);
    }

    @Override
    public RemoteControlReceiver createRemoteControlReceiver(InputPort port) {
        checkInputPortCompatibility(port);

        mStatus.bind(port, DeviceType.REMOTECONTROL_RECEIVER);
        return new RemoteControlReceiver(port, mProtocol);
    }

    private void checkInputPortCompatibility(InputPort port) {
        if (port instanceof Ev3InputPort) {
            return;
        }

        throw new DevicePortTypeMismatchException("Expected: Ev3InputPort class, Actual: " + port);
    }

    private void checkOutputPortCompatibility(OutputPort port) {
        if (port instanceof Ev3OutputPort) {
            return;
        }

        throw new DevicePortTypeMismatchException("Expected: Ev3OutputPort class, Actual: " + port);
    }
}
