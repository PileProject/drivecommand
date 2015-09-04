package unit.drivecommand.machine;

import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.machine.device.input.ColorSensor;
import com.pileproject.drivecommand.machine.device.input.GyroSensor;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.Rangefinder;
import com.pileproject.drivecommand.machine.device.input.RemoteControlReceiver;
import com.pileproject.drivecommand.machine.device.input.SoundSensor;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.output.Buzzer;
import com.pileproject.drivecommand.machine.device.output.Led;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.output.Servomotor;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;

import mockit.Expectations;
import mockit.Mocked;

public class MachineBaseTest {
	@Mocked ProtocolBase protocol;
	private final int PORT = 0;
	
	@Test
	public void connect() throws IOException {
		new Expectations() {{
			protocol.open();
		}};
		MachineBase machineBase = new MachineBase(protocol);
		machineBase.connect();
	}
	
	@Test
	public void disconnect() {
		new Expectations() {{
			protocol.close();
		}};
		MachineBase machineBase = new MachineBase(protocol);
		machineBase.disconnect();
	}
	
	@Test
	public void getMotorFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createMotor(PORT) instanceof Motor);
	}

	@Test
	public void getServomotorFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createServomotor(PORT) instanceof Servomotor);
	}

	@Test
	public void getBuzzerFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createBuzzer(PORT) instanceof Buzzer);
	}

	@Test
	public void getLedFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createLed(PORT) instanceof Led);
	}

	@Test
	public void getLineSensorFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createLineSensor(PORT) instanceof LineSensor);
	}

	@Test
	public void getGyroFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createGyroSensor(PORT) instanceof GyroSensor);
	}

	@Test
	public void getTouchSensorFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createTouchSensor(PORT) instanceof TouchSensor);
	}

	@Test
	public void getColorSensorFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createColorSensor(PORT) instanceof ColorSensor);
	}

	@Test
	public void getRangefinderFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createRangefinder(PORT) instanceof Rangefinder);
	}

	@Test
	public void getSoundSensorFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createSoundSensor(PORT) instanceof SoundSensor);
	}

	@Test
	public void getRemoteControlRecieverFromMachine() {
		MachineBase machineBase = new MachineBase(protocol);
		AssertJUnit.assertTrue(machineBase.createRemoteControlReceiver(PORT) instanceof RemoteControlReceiver);
	}
}
