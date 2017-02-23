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
package unit.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.RemoteControlReceiver;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class RemoteControlReceiverTest {
    @Mocked
    private ProtocolBase protocol;
    private final InputPort PORT = new InputPort() {
        @Override
        public int getRaw() {
            return 1;
        }
    };
    private final int VALUE_BUTTON = 3;
    private final int VALUE_DISTANCE = 3;
    private final String KEY_VALUE = "value";
    
    @Test
    public void getRemoteControllerButton() {
        new Expectations() {{
            protocol.exec(PORT.getRaw(), (CommandBase) any);
            result = new HashMap<String, Object>() {{
                put(KEY_VALUE, VALUE_BUTTON);
            }};
        }};
        RemoteControlReceiver rr = new RemoteControlReceiver(PORT, protocol);
        AssertJUnit.assertEquals(rr.getRemoteButton(), VALUE_BUTTON);
    }
    
    @Test
    public void getRemoteControllerDistance() {
        new Expectations() {{
            protocol.exec(PORT.getRaw(), (CommandBase) any);
            result = new HashMap<String, Object>() {{
                put(KEY_VALUE, VALUE_DISTANCE);
            }};
        }};
        RemoteControlReceiver rr = new RemoteControlReceiver(PORT, protocol);
        AssertJUnit.assertEquals(rr.getRemoteDistance(), VALUE_DISTANCE);
    }
    
    @Test
    public void deviceTypeIsRemoteControlReceiver() {
        RemoteControlReceiver rr = new RemoteControlReceiver(PORT, protocol);
        AssertJUnit.assertEquals(rr.getDeviceType(), DeviceType.REMOTECONTROL_RECEIVER);
    }
}

