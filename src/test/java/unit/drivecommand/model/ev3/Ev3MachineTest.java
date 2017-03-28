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
package unit.drivecommand.model.ev3;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.device.input.ColorSensor;
import com.pileproject.drivecommand.machine.device.input.GyroSensor;
import com.pileproject.drivecommand.machine.device.input.LightSensor;
import com.pileproject.drivecommand.machine.device.input.Rangefinder;
import com.pileproject.drivecommand.machine.device.input.RemoteControlReceiver;
import com.pileproject.drivecommand.machine.device.input.SoundSensor;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Buzzer;
import com.pileproject.drivecommand.machine.device.output.Led;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.output.Servomotor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.com.ICommunicator;
import com.pileproject.drivecommand.model.ev3.Ev3Machine;
import com.pileproject.drivecommand.model.ev3.port.Ev3InputPort;
import com.pileproject.drivecommand.model.ev3.port.Ev3OutputPort;

import org.testng.annotations.Test;

import mockit.Mocked;

import static org.testng.AssertJUnit.assertTrue;

public class Ev3MachineTest {
    @Mocked
    protected ICommunicator communicator;
    private final OutputPort OUT_PORT = Ev3OutputPort.PORT_A;
    private final InputPort IN_PORT = Ev3InputPort.PORT_1;

    // TODO: add negative version of tests

    @Test
    public void applySuccessfully() throws Exception {
        // TODO: check a protocol use 'apply' method in the communicator
    }

    @Test
    public void fetchStatusSuccessfully() throws Exception {
        // TODO: check a protocol use 'fetchStatus' method in the communicator
    }

    @Test
    public void createMotorSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createMotor(OUT_PORT) instanceof Motor);
    }

    @Test
    public void createServomotorSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createServomotor(OUT_PORT) instanceof Servomotor);
    }

    @Test
    public void createBuzzerSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createBuzzer(OUT_PORT) instanceof Buzzer);
    }

    @Test
    public void createLedSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createLed(OUT_PORT) instanceof Led);
    }

    @Test
    public void createLightSensorSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createLightSensor(IN_PORT) instanceof LightSensor);
    }

    @Test
    public void createTouchSensorSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createTouchSensor(IN_PORT) instanceof TouchSensor);
    }

    @Test
    public void createSoundSensorSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createSoundSensor(IN_PORT) instanceof SoundSensor);
    }

    @Test
    public void createGyroSensorSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createGyroSensor(IN_PORT) instanceof GyroSensor);
    }

    @Test
    public void createColorSensorSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createColorSensor(IN_PORT) instanceof ColorSensor);
    }

    @Test
    public void createRangefinderSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createRangefinder(IN_PORT) instanceof Rangefinder);
    }

    @Test
    public void createRemoteControlReceiverSuccessfully() throws Exception {
        MachineBase machine = new Ev3Machine(communicator);
        assertTrue(machine.createRemoteControlReceiver(IN_PORT) instanceof RemoteControlReceiver);
    }
}
