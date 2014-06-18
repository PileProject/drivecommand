package test.drivecommand.machine.output;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.input.ColorSensor;
import com.pile_drive.drivecommand.machine.output.Motor;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class MotorTest {
	@Mocked private ProtocolBase protocol;
	@Mocked private CommandFactory factory = null;
	private final int PORT = 0;
	private final int SPEED = 30;
	private final boolean SUCCESS = true;
	private final int STOP = 0; 
	
	private Motor motor;
	
	@BeforeMethod
	public void setUp() {
		motor = new Motor(PORT, protocol);
		motor.setSpeed(SPEED);
	}
	
	@Test
	public void setMotorSpeed() {
		Motor motor = new Motor(PORT, protocol);
		motor.setSpeed(SPEED);
		assertEquals(motor.getSpeed(), SPEED);
	}
	
	@Test
	public void forwardMotor() {
		// TODO consider how to use hashmap args
		new Expectations() {{
			HashMap<String, Object> args = new HashMap<String, Object>() {{put("speed", SPEED);}};
			CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, (HashMap<String, Object>)any);
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put("valid", SUCCESS);}};
		}};
		
		motor.forward();
	}

	@Test
	public void backwardMotor() {
		// TODO consider how to use hashmap args
		new Expectations() {{
			HashMap<String, Object> args = new HashMap<String, Object>() {{put("speed", -SPEED); }};
			CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, (HashMap<String, Object>)any);
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put("valid", SUCCESS);}};
		}};

		Motor motor = new Motor(PORT, protocol);
		motor.backward();
	}
	
	@Test
	public void stopMotor() {
		// TODO consider how to use hashmap args
		new Expectations() {{
			HashMap<String, Object> args = new HashMap<String, Object>(){{put("speed", STOP);}};
			CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, (HashMap<String, Object>)any);
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put("valid", SUCCESS);}};
		}};
		
		motor.stop();
	}
	
	@Test
	public void deviceTypeIsMotor() {
		assertEquals(motor.getDeviceType(), DeviceType.MOTOR);
	}
}

