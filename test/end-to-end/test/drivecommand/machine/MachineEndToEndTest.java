package test.drivecommand.machine;

import static org.testng.AssertJUnit.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pile_drive.drivecommand.machine.Machine;
import com.pile_drive.drivecommand.machine.input.TouchSensor;

public class MachineEndToEndTest {
	StubCommunicator comm = new StubCommunicator();
	EV3Protocol protocol = new EV3Protocol(comm);
	Machine machine = new Machine(protocol);
	private final int PORT = 0;
	
	@BeforeMethod
	public void setUp() {
		machine.connect();
	}
	
	@Test
	public void getTouchSensorFromMachineAndCheckItIsTouched() {
		TouchSensor ts = machine.createTouchSensor(PORT);
		comm.setBoolean(true);
		assertTrue(ts.isTouched());
		
		comm.setBoolean(false);
		assertFalse(ts.isTouched());
	}
	
}
