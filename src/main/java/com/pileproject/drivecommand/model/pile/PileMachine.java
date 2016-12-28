/**
 * Copyright (C) 2011-2016 The DriveCommand Authors <pile-dev@googlegroups.com>
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
 */
package com.pileproject.drivecommand.model.pile;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.MachineStatus;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.Rangefinder;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.port.DevicePortTypeMismatchException;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.com.ICommunicator;
import com.pileproject.drivecommand.model.pile.port.PileInputPort;

/**
 * A machine class for PILE machines.
 */
public class PileMachine extends MachineBase {
    public PileMachine(ICommunicator comm) {
        super(new PileProtocol(comm));
    }

    @Override
    public void apply() {
        mProtocol.apply();
    }

    @Override
    public byte[] load(int key) {
        return mProtocol.load(key);
    }

    @Override
    public boolean store(int key, byte[] data) {
        return mProtocol.store(key, data);
    }

    @Override
    public MachineStatus fetchStatus() {
        return mStatus;
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

        throw new DevicePortTypeMismatchException(String.format(
                "Expected: %s or %s, Actual %s",
                PileInputPort.LINE_SENSOR_L,
                PileInputPort.LINE_SENSOR_R,
                port));
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



