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
 * A gyro sensor class.
 */
public class GyroSensor extends DeviceBase {

    public GyroSensor(InputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    /**
     * Get the rate of rotations.
     *
     * @return the current rate
     */
    public int getRate() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.GET_GYRO_RATE, null);
        Map<String, Object> res = exec(cmd);
        return (Integer) res.get("value");
    }

    /**
     * GEt the angle of this Gyro sensor.
     * @return the current angle
     */
    public int getAngle() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.GET_GYRO_ANGLE, null);
        Map<String, Object> res = exec(cmd);
        return (Integer) res.get("value");
    }

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.GYRO_SENSOR;
    }
}
