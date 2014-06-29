package test.drivecommand.machine;

import static org.testng.AssertJUnit.assertTrue;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pile_drive.drivecommand.machine.Machine;
import com.pile_drive.drivecommand.machine.input.TouchSensor;

public class MachineEndToEndTest {
	StubCommunicator comm = new StubCommunicator();
	StubProtocol protocol = new StubProtocol(comm);
	Machine machine = new Machine(protocol);
	private final int PORT = 0;
	
	@BeforeMethod
	public void setUp() {
		try {
			machine.connect();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(comm.isOpen());
	}
	
	@Test
	public void getTouchSensorFromMachineAndCheckItIsTouched() {
		TouchSensor ts = machine.createTouchSensor(PORT);
		
	}
	
}
