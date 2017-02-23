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
package com.pileproject.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.device.DeviceBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

import java.util.Map;

/**
 * A remote control receiver class.
 */
public class RemoteControlReceiver extends DeviceBase {

    public RemoteControlReceiver(InputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    /**
     * Gets the pushed button on the controller.
     *
     * @return the button number
     */
    public int getRemoteButton() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.GET_REMOTECONTROLLER_BUTTON, null);
        Map<String, Object> res = exec(cmd);
        return (Integer) res.get("value");
    }

    /**
     * Gets the distance between this device and the controller.
     *
     * @return the distance in centimeter
     * TODO: not tested
     */
    public int getRemoteDistance() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.GET_REMOTECONTROLLER_DIST, null);
        Map<String, Object> res = exec(cmd);
        return (Integer) res.get("value");
    }

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.REMOTECONTROL_RECEIVER;
    }
}
