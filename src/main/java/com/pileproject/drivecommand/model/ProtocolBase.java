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

package com.pileproject.drivecommand.model;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.model.com.ICommunicator;

import java.io.IOException;
import java.util.Map;

/**
 * A base class for protocols which is used for
 * {@link com.pileproject.drivecommand.machine.MachineBase}
 * to interpret machine-specific byte codes.
 */
public abstract class ProtocolBase {
    protected final ICommunicator mCommunicator;

    public ProtocolBase(ICommunicator comm) {
        mCommunicator = comm;
    }

    /**
     * Open a connection between devices.
     *
     * @throws IOException open fails
     */
    public abstract void open() throws IOException;

    /**
     * Close the connection between devices.
     */
    public abstract void close();

    /**
     * Execute a command.
     *
     * @param port a port to be controled
     * @param cmd {@link CommandBase} which is to be executed
     * @return the result of the command
     */
    public abstract Map<String, Object> exec(int port, CommandBase cmd);

    /**
     * Apply commands.
     * This will be used with devices supporting 'transactions'.
     *
     * @return success (true) or not (false)
     */
    public abstract boolean apply();

    /**
     * Load value from a machine.
     *
     * @param key a key of a key-value store
     * @return byte[] raw values
     */
    public abstract byte[] load(int key);

    /**
     * Store value to a machine.
     *
     * @param key a key of a key-value store
     * @param data a value fo a key-value store
     * @return boolean success (true) or not (false)
     */
    public abstract boolean store(int key, byte[] data);
}
