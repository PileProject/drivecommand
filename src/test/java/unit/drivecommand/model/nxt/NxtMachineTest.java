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
package unit.drivecommand.model.nxt;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.SoundSensor;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.com.ICommunicator;
import com.pileproject.drivecommand.model.nxt.NxtMachine;
import com.pileproject.drivecommand.model.nxt.port.NxtInputPort;
import com.pileproject.drivecommand.model.nxt.port.NxtOutputPort;

import org.testng.annotations.Test;

import mockit.Mocked;

import static org.testng.Assert.assertTrue;

public class NxtMachineTest {
    @Mocked
    protected ICommunicator communicator;
    private final OutputPort OUT_PORT = NxtOutputPort.PORT_A;
    private final InputPort IN_PORT = NxtInputPort.PORT_1;

    // TODO: add negative version of tests

    @Test
    public void applySuccessfully() throws Exception {
        // TODO: check a protocol use 'apply' method in the communicator
    }

    @Test
    public void fetchStatusSuccessfully() throws Exception {
        // TODO: check a protocol use 'fetch' method in the communicator
    }

    @Test
    public void createMotorSuccessfully() throws Exception {
        MachineBase machine = new NxtMachine(communicator);
        assertTrue(machine.createMotor(OUT_PORT) instanceof Motor);
    }

    @Test
    public void createLineSensorSuccessfully() throws Exception {
        MachineBase machine = new NxtMachine(communicator);
        assertTrue(machine.createLineSensor(IN_PORT) instanceof LineSensor);
    }

    @Test
    public void createTouchSensorSuccessfully() throws Exception {
        MachineBase machine = new NxtMachine(communicator);
        assertTrue(machine.createTouchSensor(IN_PORT) instanceof TouchSensor);
    }

    @Test
    public void createSoundSensorSuccessfully() throws Exception {
        MachineBase machine = new NxtMachine(communicator);
        assertTrue(machine.createSoundSensor(IN_PORT) instanceof SoundSensor);
    }
}
