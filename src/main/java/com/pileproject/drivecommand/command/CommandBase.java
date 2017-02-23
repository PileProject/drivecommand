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
package com.pileproject.drivecommand.command;

import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.model.CommandType;

import java.util.Map;

/**
 * A base class for a command.
 */
public abstract class CommandBase {
    private CommandType mType;
    private Map<String, Object> mArgs;

    public CommandBase(CommandType type, Map<String, Object> args) {
        mType = type;
        mArgs = args;
    }

    /**
     * Gets the type of this command.
     *
     * @return the {@link CommandType}
     */
    public CommandType getCommandType() {
        return mType;
    }

    /**
     * Gets the type of the device which is used with this command.
     *
     * @return the {@link DeviceType}
     */
    public DeviceType getDeviceType() {
        return mType.getDeviceType();
    }

    /**
     * Gets the arguments of this command.
     *
     * @return a map of {@link String} and {@link Object} which expresses arguments
     */
    public Map<String, Object> getArgs() {
        return mArgs;
    }
}
