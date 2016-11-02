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

package com.pileproject.drivecommand.machine.device.output;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.device.DeviceBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

import java.util.HashMap;
import java.util.Map;

/**
 * A servomotor class.
 */
public class Servomotor extends DeviceBase {

    public Servomotor(OutputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    /**
     * Get the angle of this servomotor.
     *
     * @return the current angle
     */
    public int getAngle() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.GET_SERVO_ANGLE, null);
        Map<String, Object> res = exec(cmd);
        return (Integer) res.get("value");
    }

    /**
     * Set the angle to this servomotor.
     *
     * @param angle an angle to be set
     */
    public void setAngle(int angle) {
        Map<String, Object> args = new HashMap<>();
        args.put("angle", angle);
        CommandBase cmd = CommandFactory.createCommand(CommandType.SET_SERVO_ANGLE, args);
        exec(cmd);
    }

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.SERVOMOTOR;
    }

}
