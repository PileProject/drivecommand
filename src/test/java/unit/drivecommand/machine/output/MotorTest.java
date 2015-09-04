package unit.drivecommand.machine.output;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class MotorTest {
	@Mocked private ProtocolBase protocol;
	@Mocked private HashMap<String, Object> args;
	private final int PORT = 0;
	private final String KEY_VALID = "valid";
	private final int VALUE_SPEED = 30;
	private final int VALUE_SPEED_OUT_OF_RANGE = -1;
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
	public void setMotorSpeedButItIsOutOfRange() {
		Motor motor = new Motor(PORT, protocol);
		assertEquals(motor.getSpeed(), INITIAL_SPEED);	// initial power
		motor.setSpeed(VALUE_SPEED_OUT_OF_RANGE);
		assertEquals(motor.getSpeed(), INITIAL_SPEED);
	}

	@Test
	public void forwardMotor() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		motor.forward();
	}

	@Test
	public void backwardMotor() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		motor.backward();
	}
	
	@Test
	public void stopMotor() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		motor.stop();
	}
	
	@Test
	public void deviceTypeIsMotor() {
		assertEquals(motor.getDeviceType(), DeviceType.MOTOR);
	}
}
