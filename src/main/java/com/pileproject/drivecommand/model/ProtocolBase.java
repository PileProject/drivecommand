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

public abstract class ProtocolBase {
    protected final ICommunicator mCommunicator;

    public ProtocolBase(ICommunicator comm) {
        mCommunicator = comm;
    }

    /**
     * Open the connection between devices.
     *
     * @throws IOException
     */
    public abstract void open() throws IOException;

    /**
     * Close the connection between devices.
     */
    public abstract void close();

    /**
     * Execute the command.
     *
     * @param port
     * @param cmd
     * @return
     */
    public abstract Map<String, Object> exec(int port, CommandBase cmd);

    /**
     * Apply commands
     * <p>
     * This will be used with devices supporting transactions.
     *
     * @return success (true) or not (false)
     */
    public abstract boolean apply();

    /**
     * load value from device
     *
     * @param int key
     * @return byte[] raw value
     */
    public abstract byte[] load(int key);

    /**
     * store value to device
     *
     * @param int key
     * @param byte[] raw value
     * @return boolean success (true) or not (false)
     */
    public abstract boolean store(int key, byte[] data);
}
