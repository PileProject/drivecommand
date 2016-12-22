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

/**
 * A buzzer class.
 */
public class Buzzer extends DeviceBase {

    public Buzzer(OutputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    /**
     * Turn on this buzzer if it is off.
     */
    public void turnOn() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.SET_BUZZER_ON, null);
        exec(cmd);
    }

    /**
     * Turn off this buzzer if it is on.
     */
    public void turnOff() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.SET_BUZZER_OFF, null);
        exec(cmd);
    }

    /**
     * Keep this buzzer beeping.
     */
    public void beep() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.SET_BUZZER_BEEP, null);
        exec(cmd);
    }

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.BUZZER;
    }

}
