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

package unit.drivecommand.machine;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.MachineStatus;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.annotations.Test;

import java.io.IOException;

import mockit.Expectations;
import mockit.Mocked;

public class MachineBaseTest {
    @Mocked
    ProtocolBase protocol;
    private final OutputPort OUT_PORT = new OutputPort() {
        @Override
        public int getRaw() {
            return 1;
        }
    };
    private final InputPort IN_PORT = new InputPort() {
        @Override
        public int getRaw() {
            return 1;
        }
    };

    private MachineBase newMachineBase(ProtocolBase protocol) {
        return new MachineBase(protocol) {
            @Override
            public MachineStatus fetchStatus() {
                return null;
            }
        };
    }

    @Test
    public void connect() throws IOException {
        new Expectations() {{
            protocol.open();
        }};
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.connect();
    }

    @Test
    public void disconnect() {
        new Expectations() {{
            protocol.close();
        }};
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.disconnect();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getMotorFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createMotor(OUT_PORT);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getServomotorFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createServomotor(OUT_PORT);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getBuzzerFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createBuzzer(OUT_PORT);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getLedFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createLed(OUT_PORT);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getLineSensorFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createLineSensor(IN_PORT);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getGyroFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createGyroSensor(IN_PORT);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getTouchSensorFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createTouchSensor(IN_PORT);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getColorSensorFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createColorSensor(IN_PORT);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getRangefinderFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createRangefinder(IN_PORT);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getSoundSensorFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createSoundSensor(IN_PORT);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void getRemoteControlReceiverFromMachine() {
        MachineBase machineBase = newMachineBase(protocol);
        machineBase.createRemoteControlReceiver(IN_PORT);
    }
}
