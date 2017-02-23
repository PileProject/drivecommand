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
package unit.drivecommand.command;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.model.CommandType;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.AssertJUnit.assertEquals;

public class CommandFactoryTest {
    
    @DataProvider(name = "command")
    public static Object[][] commandMakers() {
        return new Object[][] {
            {
                CommandType.SET_LED_OFF, null
            },
            {
                CommandType.GET_COLOR_ILLUMINANCE, null
            },
            {
                CommandType.SET_LED_OFF, null
            }
        };
    }
    
    @Test(dataProvider = "command")
    public void createCommand(CommandType type, HashMap<String, Object> args) {
        CommandBase cmd = CommandFactory.createCommand(type, args);
        assertEquals(cmd.getCommandType(), type);
        assertEquals(cmd.getArgs(), args);
        assertEquals(cmd.getDeviceType(), type.getDeviceType());
    }
}
