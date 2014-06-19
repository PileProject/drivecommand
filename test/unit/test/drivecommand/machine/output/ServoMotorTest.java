package test.drivecommand.machine.output;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.output.Servomotor;
import com.pile_drive.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class ServoMotorTest {
	@Mocked private ProtocolBase protocol;
	@Mocked private HashMap<String, Object> args;
	private final int PORT = 0;
	private final String KEY_VALID = "valid";
	private final String KEY_VALUE = "value";
	private final int VALUE_ANGLE = 30;
	private final boolean VALUE_VALID = true;
	
	
	@Test
	public void getServomotorAngle() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_ANGLE);}};
		}};
		Servomotor motor = new Servomotor(PORT, protocol);
		assertEquals(motor.getAngle(), VALUE_ANGLE);
	}

	@Test
	public void setServomotorAngle() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		Servomotor motor = new Servomotor(PORT, protocol);
		assertEquals(motor.setAngle(VALUE_ANGLE), VALUE_VALID);
	}
	
	@Test
	public void deviceTypeIsServomotor() {
		Servomotor motor = new Servomotor(PORT, protocol);
		assertEquals(motor.getDeviceType(), DeviceType.SERVOMOTOR);
	}
}
