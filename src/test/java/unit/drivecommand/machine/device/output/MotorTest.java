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
package unit.drivecommand.machine.device.output;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class MotorTest {
    @Mocked
    private ProtocolBase protocol;
    @Mocked
    private HashMap<String, Object> args;
    private final OutputPort PORT = new OutputPort() {
        @Override
        public int getRaw() {
            return 1;
        }
    };
    private final String KEY_VALID = "valid";
    private final int VALUE_SPEED = 30;
    private final int VALUE_SPEED_OUT_OF_RANGE = -1;
    private final boolean VALUE_VALID = true;
    private final int INITIAL_SPEED = 50;
    
    private Motor motor;
    
    @BeforeMethod
    public void setUp() {
        motor = new Motor(PORT, protocol);
        motor.setSpeed(VALUE_SPEED);
    }
    
    @Test
    public void setMotorSpeed() {
        Motor motor = new Motor(PORT, protocol);
        AssertJUnit.assertEquals(motor.getSpeed(), INITIAL_SPEED);    // initial power
        motor.setSpeed(VALUE_SPEED);
        AssertJUnit.assertEquals(motor.getSpeed(), VALUE_SPEED);
    }
    
    @Test
    public void setMotorSpeedButItIsOutOfRange() {
        Motor motor = new Motor(PORT, protocol);
        AssertJUnit.assertEquals(motor.getSpeed(), INITIAL_SPEED);    // initial power
        motor.setSpeed(VALUE_SPEED_OUT_OF_RANGE);
        AssertJUnit.assertEquals(motor.getSpeed(), INITIAL_SPEED);
    }

    @Test
    public void forwardMotor() {
        new Expectations() {{
            protocol.exec(PORT.getRaw(), (CommandBase) any);
            result = new HashMap<String, Object>() {{
                put(KEY_VALID, VALUE_VALID);
            }};
        }};
        motor.forward();
    }

    @Test
    public void backwardMotor() {
        new Expectations() {{
            protocol.exec(PORT.getRaw(), (CommandBase) any);
            result = new HashMap<String, Object>() {{
                put(KEY_VALID, VALUE_VALID);
            }};
        }};
        motor.backward();
    }
    
    @Test
    public void stopMotor() {
        new Expectations() {{
            protocol.exec(PORT.getRaw(), (CommandBase) any);
            result = new HashMap<String, Object>() {{
                put(KEY_VALID, VALUE_VALID);
            }};
        }};
        motor.stop();
    }
    
    @Test
    public void deviceTypeIsMotor() {
        AssertJUnit.assertEquals(motor.getDeviceType(), DeviceType.MOTOR);
    }
}
