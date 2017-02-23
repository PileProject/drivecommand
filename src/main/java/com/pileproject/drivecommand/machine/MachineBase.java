/**
 * Copyright (C) 2011-2017 The PILE Developers <pile-dev@googlegroups.com>
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

/**
 * A base class for machines that specifies interfaces of a machine.
 * This class also be used as a factory class to generate sensors/motors.
 */
public abstract class MachineBase {
    protected ProtocolBase mProtocol;
    protected MachineStatus mStatus;

    public MachineBase(ProtocolBase protocol) {
        mProtocol = protocol;
        mStatus = new MachineStatus();
    }

    /**
     * Connects to this machine.
     *
     * @throws IOException if failed to open a connection
     */
    public void connect() throws IOException {
        mProtocol.open();
    }

    /**
     * Disconnects from this machine.
     */
    public void disconnect() {
        mProtocol.close();
    }

    /**
     * Applies the commands as a transaction (for PILE machines).
     */
    public void apply() {
        throw new UnsupportedOperationException("This machine does not support 'apply' command");
    }

    /**
     * Loads data from this machine.
     *
     * @param key a key of a key-value store
     * @return raw values in an array of bytes
     */
    public byte[] load(int key) {
        throw new UnsupportedOperationException("This machine does not support 'load' command");
    }

    /**
     * Stores data to this machine.
     *
     * @param key a key of a key-value store
     * @param data a value of a key-value store
     * @return succeed (<code>true</code>) or (<code>false</code>)
     */
    public boolean store(int key, byte[] data) {
        throw new UnsupportedOperationException("This machine does not support 'store' command");
    }

    /**
     * Fetches {@link MachineStatus} from this machine.
     * NOTE: before this command, makes connection
     *
     * @return the {@link MachineStatus}
     */
    public abstract MachineStatus fetchStatus();

    /**
     * Creates a {@link Motor}.
     *
     * @param port an {@link OutputPort} which is supposed to be bounded
     * @return a {@link Motor} which is connected to the specified port
     */
    public Motor createMotor(OutputPort port) {
        throw new UnsupportedOperationException("This machine does not support Motor");
    }

    /**
     * Creates a {@link Servomotor}.
     *
     * @param port an {@link OutputPort} which is supposed to be bounded
     * @return a {@link Servomotor} which is connected to the specified port
     */
    public Servomotor createServomotor(OutputPort port) {
        throw new UnsupportedOperationException("This machine does not support Servomotor");
    }

    /**
     * Creates a {@link Buzzer}.
     *
     * @param port an {@link OutputPort} which is supposed to be bounded
     * @return a {@link Buzzer} which is connected to the specified port
     */
    public Buzzer createBuzzer(OutputPort port) {
        throw new UnsupportedOperationException("This machine does not support Buzzer");
    }

    /**
     * Creates a {@link Led}.
     *
     * @param port an {@link OutputPort} which is supposed to be bounded
     * @return a {@link Led} which is connected to the specified port
     */
    public Led createLed(OutputPort port) {
        throw new UnsupportedOperationException("This machine does not support LED");
    }

    /**
     * Creates a {@link LineSensor}.
     *
     * @param port an {@link InputPort} which is supposed to be bounded
     * @return a {@link LineSensor} which is connected to the specified port
     */
    public LineSensor createLineSensor(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support LineSensor");
    }

    /**
     * Creates a {@link GyroSensor}.
     *
     * @param port an {@link InputPort} which is supposed to be bounded
     * @return a {@link GyroSensor} which is connected to the specified port
     */
    public GyroSensor createGyroSensor(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support GyroSensor");
    }

    /**
     * Creates a {@link TouchSensor}.
     *
     * @param port an {@link InputPort} which is supposed to be bounded
     * @return a {@link TouchSensor} which is connected to the specified port
     */
    public TouchSensor createTouchSensor(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support TouchSensor");
    }

    /**
     * Creates a {@link ColorSensor}.
     *
     * @param port an {@link InputPort} which is supposed to be bounded
     * @return a {@link ColorSensor} which is connected to the specified port
     */
    public ColorSensor createColorSensor(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support ColorSensor");
    }

    /**
     * Creates a {@link Rangefinder}.
     *
     * @param port an {@link InputPort} which is supposed to be bounded
     * @return a {@link Rangefinder} which is connected to the specified port
     */
    public Rangefinder createRangefinder(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support Rangefinder");
    }

    /**
     * Creates a {@link SoundSensor}.
     *
     * @param port an {@link InputPort} which is supposed to be bounded
     * @return a {@link SoundSensor} which is connected to the specified port
     */
    public SoundSensor createSoundSensor(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support SoundSensor");
    }

    /**
     * Creates a {@link RemoteControlReceiver}.
     *
     * @param port an {@link InputPort} which is supposed to be bounded
     * @return a {@link RemoteControlReceiver} which is connected to the specified port
     */
    public RemoteControlReceiver createRemoteControlReceiver(InputPort port) {
        throw new UnsupportedOperationException("This machine does not support RemoteControlReceiver");
    }
}
