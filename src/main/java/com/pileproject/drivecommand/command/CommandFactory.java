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

import com.pileproject.drivecommand.model.CommandType;

import java.util.Map;

/**
 * A factory class to make a command. This class creates {@link Command} at present.
 */
public class CommandFactory {

    /**
     * Creates a command.
     *
     * @param type a type of a command
     * @param args arguments of a command
     * @return a created {@link Command}
     */
    public static CommandBase createCommand(CommandType type, Map<String, Object> args) {
        return new Command(type, args);
    }
}
