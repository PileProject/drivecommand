package unit.drivecommand.machine;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import mockit.Expectations;
import mockit.Mocked;

import com.pileproject.drivecommand.machine.Machine;
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

public class MachineTest {
	@Mocked ProtocolBase protocol;
	private final int PORT = 0;
	
	@Test
	public void connect() throws IOException {
		new Expectations() {{
			protocol.open();
		}};
		Machine machine = new Machine(protocol);
		machine.connect();
	}
	
	@Test
	public void disconnect() {
		new Expectations() {{
			protocol.close();
		}};
		Machine machine = new Machine(protocol);
		machine.disconnect();
	}
	
	@Test
	public void getMotorFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createMotor(PORT) instanceof Motor);
	}

	@Test
	public void getServomotorFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createServomotor(PORT) instanceof Servomotor);
	}

	@Test
	public void getBuzzerFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createBuzzer(PORT) instanceof Buzzer);
	}

	@Test
	public void getLedFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createLed(PORT) instanceof Led);
	}

	@Test
	public void getLineSensorFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createLineSensor(PORT) instanceof LineSensor);
	}

	@Test
	public void getGyroFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createGyroSensor(PORT) instanceof GyroSensor);
	}

	@Test
	public void getTouchSensorFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createTouchSensor(PORT) instanceof TouchSensor);
	}

	@Test
	public void getColorSensorFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createColorSensor(PORT) instanceof ColorSensor);
	}

	@Test
	public void getRangefinderFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createRangefinder(PORT) instanceof Rangefinder);
	}

	@Test
	public void getSoundSensorFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createSoundSensor(PORT) instanceof SoundSensor);
	}

	@Test
	public void getRemoteControlRecieverFromMachine() {
		Machine machine = new Machine(protocol);
		AssertJUnit.assertTrue(machine.createRemoteControlReceiver(PORT) instanceof RemoteControlReceiver);
	}
}
