package test.drivecommand.machine.output;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.output.Motor;
import com.pile_drive.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class MotorTest {
	@Mocked private ProtocolBase protocol;
	@Mocked private HashMap<String, Object> args;
	private final int PORT = 0;
	private final String KEY_VALID = "valid";
	private final int VALUE_SPEED = 30;
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
		assertEquals(motor.getSpeed(), INITIAL_SPEED);	// initial power
		motor.setSpeed(VALUE_SPEED);
		assertEquals(motor.getSpeed(), VALUE_SPEED);
	}
	
	@Test
	public void forwardMotor() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		assertEquals(motor.forward(), VALUE_VALID);
	}

	@Test
	public void backwardMotor() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		assertEquals(motor.backward(), VALUE_VALID);
	}
	
	@Test
	public void stopMotor() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		assertEquals(motor.stop(), VALUE_VALID);
	}
	
	@Test
	public void deviceTypeIsMotor() {
		assertEquals(motor.getDeviceType(), DeviceType.MOTOR);
	}
}
