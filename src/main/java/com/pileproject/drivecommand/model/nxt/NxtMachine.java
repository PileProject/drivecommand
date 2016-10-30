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

package com.pileproject.drivecommand.model.nxt;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.MachineStatus;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.SoundSensor;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.port.DevicePortTypeMismatchException;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.com.ICommunicator;
import com.pileproject.drivecommand.model.nxt.port.NxtInputPort;
import com.pileproject.drivecommand.model.nxt.port.NxtOutputPort;

/**
 * LEGO MINDSTORMS NXT
 *
 * @author Tatsuya Iwanari
 */
public class NxtMachine extends MachineBase {

    public NxtMachine(ICommunicator comm) {
        super(new NxtProtocol(comm));
    }

    protected NxtMachine(NxtProtocol protocol) {
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
    public Motor createMotor(OutputPort port) {
        checkOutputPortCompatibility(port);

        mStatus.bind(port, DeviceType.MOTOR);
        return new Motor(port, mProtocol);
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

    protected void checkOutputPortCompatibility(OutputPort port) {
        if (port instanceof NxtOutputPort) {
            return;
        }

        throw new DevicePortTypeMismatchException("Expected: NxtOutputPort, Actual: " + port.getClass());
    }

    protected void checkInputPortCompatibility(InputPort port) {
        if (port instanceof NxtInputPort) {
            return;
        }

        throw new DevicePortTypeMismatchException("Expected: NxtInputPort, Actual: " + port.getClass());
    }
}
