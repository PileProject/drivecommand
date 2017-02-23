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
 * A line sensor class.
 * This is also known as 'light' sensor for EV3.
 */
public class LineSensor extends DeviceBase {

    public LineSensor(InputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    /**
     * Gets the value of light sensor.
     *
     * @return sensor value (0 - 100%)
     */
    public int getSensorValue() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.GET_LINE_VALUE, null);
        Map<String, Object> value = exec(cmd);
        return (Integer) value.get("value");
    }

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.LINE_SENSOR;
    }
}
