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

package com.pileproject.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.device.DeviceBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

import java.util.Map;

public class ColorSensor extends DeviceBase {

    public ColorSensor(InputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    /**
     * Get the color in RGB (0 - 255)
     * <p>
     * TODO: this method doesn't return proper value.
     *
     * @return float[] ([0]: r, [1]: g, [2]: b)
     */
    public float[] getRgb() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.GET_COLOR_RGB, null);
        Map<String, Object> res = exec(cmd);
        return (float[]) res.get("value");
    }

    /**
     * Get the illuminance in percent (0 - 100)
     *
     * @return int (0 - 100 %)
     */
    public int getIlluminance() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.GET_COLOR_ILLUMINANCE, null);
        Map<String, Object> res = exec(cmd);
        return (Integer) res.get("value");
    }

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.COLOR_SENSOR;
    }
}
