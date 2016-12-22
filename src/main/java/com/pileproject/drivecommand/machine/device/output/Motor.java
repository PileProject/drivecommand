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
 * A motor class.
 */
public class Motor extends DeviceBase {
    private int mSpeed = 50; // initial value

    public Motor(OutputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    /**
     * Move this motor forward.
     */
    public void forward() {
        Map<String, Object> args = new HashMap<>();
        args.put("speed", mSpeed);
        CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
        exec(cmd);
    }

    /**
     * Move this motor backward.
     */
    public void backward() {
        Map<String, Object> args = new HashMap<>();
        args.put("speed", -mSpeed);
        CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
        exec(cmd);
    }

    /**
     * Stop this motor.
     */
    public void stop() {
        Map<String, Object> args = new HashMap<>();
        args.put("speed", 0);
        CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
        exec(cmd);
    }

    /**
     * Get the speed of this motor.
     *
     * @return speed (0 - 100)
     */
    public int getSpeed() {
        return mSpeed;
    }

    /**
     * Set the speed (0 - 100) of this motor.
     * If the speed is out of the range,
     * this method do nothing.
     *
     * @param speed a speed to be set to this motor.
     */
    public void setSpeed(int speed) {
        if (speed < 0 || speed > 100) return;
        mSpeed = speed;
    }

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.MOTOR;
    }

}
