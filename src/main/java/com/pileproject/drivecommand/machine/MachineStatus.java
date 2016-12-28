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
package com.pileproject.drivecommand.machine;

import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.port.DevicePort;

import java.util.HashMap;
import java.util.Map;

/**
 * A container class which keeps the port connection status of a machine.
 */
public class MachineStatus {
    private Map<DevicePort, DeviceType> mDevices;

    public MachineStatus() {
        mDevices = new HashMap<>();
    }

    public MachineStatus(Map<DevicePort, DeviceType> devices) {
        this.mDevices = devices;
    }

    /**
     * Binds a port and device type.
     *
     * @param port a port to be bounded with a device type
     * @param type a type to be bounded with a port
     * @return succeeded to update (<code>true</code>) or not (<code>false</code>)
     */
    public boolean bind(DevicePort port, DeviceType type) {
        boolean isUpdated = mDevices.containsKey(port);
        mDevices.put(port, type);
        return isUpdated;
    }

    /**
     * Gets the connection status of ports.
     *
     * @return a map of {@link DevicePort} and {@link DeviceType}
     */
    public Map<DevicePort, DeviceType> getPortConnections() {
        return mDevices;
    }
}
