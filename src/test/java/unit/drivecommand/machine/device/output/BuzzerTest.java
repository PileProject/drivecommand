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
package unit.drivecommand.machine.device.output;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.output.Buzzer;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class BuzzerTest {
    @Mocked
    private ProtocolBase protocol;
    private final OutputPort PORT = new OutputPort() {
        @Override
        public int getRaw() {
            return 1;
        }
    };

    private final String KEY_VALID = "valid";
    private final boolean VALUE_VALID = true;
    
    @Test
    public void turnOnBuzzer() {
        new Expectations() {{
            protocol.exec(PORT.getRaw(), (CommandBase) any);
            result = new HashMap<String, Object>() {{
                put(KEY_VALID, VALUE_VALID);
            }};
        }};
        Buzzer bz = new Buzzer(PORT, protocol);
        bz.turnOn();
    }
    
    @Test
    public void turnOffBuzzer() {
        new Expectations() {{
            protocol.exec(PORT.getRaw(), (CommandBase) any);
            result = new HashMap<String, Object>() {{
                put(KEY_VALID, VALUE_VALID);
            }};
        }};
        Buzzer bz = new Buzzer(PORT, protocol);
        bz.turnOff();
    }
    
    @Test
    public void beepBuzzer() {
        new Expectations() {{
            protocol.exec(PORT.getRaw(), (CommandBase) any);
            result = new HashMap<String, Object>() {{
                put(KEY_VALID, VALUE_VALID);
            }};
        }};
        Buzzer bz = new Buzzer(PORT, protocol);
        bz.beep();
    }
    
    @Test
    public void deviceTypeIsBuzzer() {
        Buzzer bz = new Buzzer(PORT, protocol);
        AssertJUnit.assertEquals(bz.getDeviceType(), DeviceType.BUZZER);
    }
}
