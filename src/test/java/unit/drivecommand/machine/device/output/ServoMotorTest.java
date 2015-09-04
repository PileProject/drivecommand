package unit.drivecommand.machine.device.output;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.output.Servomotor;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

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
		motor.getAngle();
	}

	@Test
	public void setServomotorAngle() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		Servomotor motor = new Servomotor(PORT, protocol);
		motor.setAngle(VALUE_ANGLE);
	}
	
	@Test
	public void deviceTypeIsServomotor() {
		Servomotor motor = new Servomotor(PORT, protocol);
		assertEquals(motor.getDeviceType(), DeviceType.SERVOMOTOR);
	}
}
