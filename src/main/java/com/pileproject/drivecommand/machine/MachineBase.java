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

package com.pileproject.drivecommand.machine;

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

import java.io.IOException;

public abstract class MachineBase {
    protected ProtocolBase mProtocol;
    protected MachineStatus mStatus;

    public MachineBase(ProtocolBase protocol) {
        mProtocol = protocol;
        mStatus = new MachineStatus();
    }

    /**
     * connect to device
     *
     * @throws IOException
     */
    public void connect() throws IOException {
        mProtocol.open();
    }

    /**
     * disconnect from device
     */
    public void disconnect() {
        mProtocol.close();
    }

    /**
     * transaction apply command
     * for Pile Robot
     */
    public void apply() {
        throw new UnsupportedOperationException("This machine does not support 'apply' command");
    }

    /**
     * load data from device
     *
     * @param int key
     * @return byte[] raw value
     */
    public byte[] load(int key) {
        throw new UnsupportedOperationException("This machine does not support 'load' command");
    }

    /**
     * store data to device
     *
     * @param int key
     * @param byte[] raw value
     * @return boolean success (true) or not (false)
     */
    public boolean store(int key, byte[] data) {
        throw new UnsupportedOperationException("This machine does not support 'store' command");
    }

    /**
     * fetch MachineStatus from this machine
     * by making connection
     *
     * @return
     */
    public abstract MachineStatus fetchStatus();

    /**
     * Create Motor
     *
     * @param port
     * @return
     */
    public Motor createMotor(OutputPort port) {
        throw new UnsupportedOperationException("This machine does not support Motor");
    }

    /**
     * Create Servomotor
     *
     * @param port
     * @return
     */
    public Servomotor createServomotor(OutputPort port) {
        throw new UnsupportedOperationException("This machine does not support Servomotor");
    }

    /**
     * Create Buzzer
     *
     * @param port
     * @return
     */
    public Buzzer createBuzzer(OutputPort port) {
        throw new UnsupportedOperationException("This machine does not support Buzzer");
    }

    /**
     * Create LED
     *
     * @param port
     * @return
     */
    public Led createLed(OutputPort port) {
        throw new UnsupportedOperationException("This machine does not support LED");
    }

    /**
     * Create LineDevice
     *
     * @param port
     * @return
     */
    public LineSensor createLineSensor(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support LineSensor");
    }

    /**
     * Create GyroSensor
     *
     * @param port
     * @return
     */
    public GyroSensor createGyroSensor(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support GyroSensor");
    }

    /**
     * Create TouchSensor
     *
     * @param port
     * @return
     */
    public TouchSensor createTouchSensor(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support TouchSensor");
    }

    /**
     * Create ColorSensor
     *
     * @param port
     * @return
     */
    public ColorSensor createColorSensor(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support ColorSensor");
    }

    /**
     * Create Rangefinder
     *
     * @param port
     * @return
     */
    public Rangefinder createRangefinder(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support Rangefinder");
    }

    /**
     * Create SoundSensor
     *
     * @param port
     * @return
     */
    public SoundSensor createSoundSensor(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support SoundSensor");
    }

    /**
     * Create RemoteControlReceiver
     *
     * @param port
     * @return
     */
    public RemoteControlReceiver createRemoteControlReceiver(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support RemoteControlReceiver");
    }
}
