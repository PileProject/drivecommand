package test.drivecommand.machine;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import mockit.Expectations;
import mockit.Mocked;

import com.pile_drive.drivecommand.machine.Machine;
import com.pile_drive.drivecommand.machine.input.ColorSensor;
import com.pile_drive.drivecommand.machine.input.GyroSensor;
import com.pile_drive.drivecommand.machine.input.LineSensor;
import com.pile_drive.drivecommand.machine.input.Rangefinder;
import com.pile_drive.drivecommand.machine.input.RemoteControlReciever;
import com.pile_drive.drivecommand.machine.input.SoundSensor;
import com.pile_drive.drivecommand.machine.input.TouchSensor;
import com.pile_drive.drivecommand.machine.output.Buzzer;
import com.pile_drive.drivecommand.machine.output.Led;
import com.pile_drive.drivecommand.machine.output.Motor;
import com.pile_drive.drivecommand.machine.output.Servomotor;
import com.pile_drive.drivecommand.model.ProtocolBase;

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
		AssertJUnit.assertTrue(machine.createRemoteControlReciever(PORT) instanceof RemoteControlReciever);
	}
}
