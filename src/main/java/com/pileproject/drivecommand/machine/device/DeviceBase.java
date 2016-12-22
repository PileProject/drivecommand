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
package com.pileproject.drivecommand.machine.device;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.port.DevicePort;
import com.pileproject.drivecommand.model.ProtocolBase;

import java.util.Map;

/**
 * A base class of a (input / output) device.
 */
public abstract class DeviceBase {
    private final DevicePort mPort;
    private final ProtocolBase mProtocol;

    /**
     * @param port a port where this device is to be inserted
     * @param protocol a protocol of a machine
     */
    public DeviceBase(DevicePort port, ProtocolBase protocol) {
        mPort = port;
        mProtocol = protocol;
    }

    /**
     * Execute a command.
     *
     * @param command a command to be executed
     * @return returned result
     */
    protected Map<String, Object> exec(CommandBase command) {
        return mProtocol.exec(mPort.getRaw(), command);
    }

    /**
     * Get the type of this device.
     * @return {@link DeviceType}
     */
    public abstract DeviceType getDeviceType();
}
