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
package unit.drivecommand.model.pile;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.device.input.LightSensor;
import com.pileproject.drivecommand.machine.device.input.Rangefinder;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.model.com.ICommunicator;
import com.pileproject.drivecommand.model.pile.PileMachine;
import com.pileproject.drivecommand.model.pile.port.PileInputPort;
import com.pileproject.drivecommand.model.pile.port.PileOutputPort;

import org.testng.annotations.Test;

import mockit.Mocked;

import static org.testng.AssertJUnit.assertTrue;

public class PileMachineTest {
    @Mocked
    protected ICommunicator communicator;

    // TODO: add negative version of tests

    @Test
    public void applySuccessfully() throws Exception {
        // TODO: check a protocol use 'apply' method in the communicator
        // and check what happens in the method
    }

    @Test
    public void loadSuccessfully() throws Exception {
        // TODO: check a protocol use 'load' method in the communicator
        // and check what happens in the method
    }

    @Test
    public void storeSuccessfully() throws Exception {
        // TODO: check a protocol use 'store' method in the communicator
        // and check what happens in the method
    }

    @Test
    public void fetchStatusSuccessfully() throws Exception {
        // TODO: check a protocol use 'fetchStatus' method in the communicator
        // and check what happens in the method
    }

    @Test
    public void createMotorSuccessfully() throws Exception {
        MachineBase machine = new PileMachine(communicator);
        assertTrue(machine.createMotor(PileOutputPort.MOTOR_LEFT) instanceof Motor);
    }

    @Test
    public void createLightSensorSuccessfully() throws Exception {
        MachineBase machine = new PileMachine(communicator);
        assertTrue(machine.createLightSensor(PileInputPort.LIGHT_SENSOR_L)
                           instanceof LightSensor);
    }

    @Test
    public void createTouchSensorSuccessfully() throws Exception {
        MachineBase machine = new PileMachine(communicator);
        assertTrue(machine.createTouchSensor(PileInputPort.TOUCH_SENSOR)
                           instanceof TouchSensor);
    }

    @Test
    public void createRangefinderSuccessfully() throws Exception {
        MachineBase machine = new PileMachine(communicator);
        assertTrue(machine.createRangefinder(PileInputPort.RANGEFINDER)
                           instanceof Rangefinder);
    }
}
