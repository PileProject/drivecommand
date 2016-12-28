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
package com.pileproject.drivecommand.model;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.model.com.ICommunicator;

import java.io.IOException;
import java.util.Map;

/**
 * A base class of protocols which are used for
 * {@link com.pileproject.drivecommand.machine.MachineBase}
 * to interpret machine-specific byte codes.
 */
public abstract class ProtocolBase {
    protected final ICommunicator mCommunicator;

    public ProtocolBase(ICommunicator comm) {
        mCommunicator = comm;
    }

    /**
     * Opens a connection between devices.
     *
     * @throws IOException if failed to open the connection
     */
    public abstract void open() throws IOException;

    /**
     * Closes the connection between devices.
     */
    public abstract void close();

    /**
     * Executes a {@link CommandBase} with a port and returns the result as a map.
     *
     * @param port a port to be used with the command
     * @param cmd a {@link CommandBase} which is to be executed
     * @return the result of the command
     */
    public abstract Map<String, Object> exec(int port, CommandBase cmd);

    /**
     * Applies commands.
     * This method will be used with devices supporting 'transactions'.
     *
     * @return succeed (<code>true</code>) or not (<code>false</code>)
     */
    public abstract boolean apply();

    /**
     * Loads a value which has the specified key from a machine.
     *
     * @param key a key of a key-value store
     * @return raw values in an array of <code>byte</code>
     */
    public abstract byte[] load(int key);

    /**
     * Stores a value with a key to a machine.
     *
     * @param key a key of a key-value store
     * @param data a value fo a key-value store
     * @return succeed (<code>true</code>) or not (<code>false</code>)
     */
    public abstract boolean store(int key, byte[] data);
}
