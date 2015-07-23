package unit.drivecommand.machine.output;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Mocked;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.DeviceType;
import com.pileproject.drivecommand.machine.output.Buzzer;
import com.pileproject.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class BuzzerTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final String KEY_VALID = "valid";
	private final boolean VALUE_VALID = true;
	
	@Test
	public void turnOnBuzzer() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		Buzzer bz = new Buzzer(PORT, protocol);
		bz.turnOn();
	}
	
	@Test
	public void turnOffBuzzer() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		Buzzer bz = new Buzzer(PORT, protocol);
		bz.turnOff();
	}
	
	@Test
	public void beepBuzzer() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		Buzzer bz = new Buzzer(PORT, protocol);
		bz.beep();
	}
	
	@Test
	public void deviceTypeIsBuzzer() {
		Buzzer bz = new Buzzer(PORT, protocol);
		assertEquals(bz.getDeviceType(), DeviceType.BUZZER);
	}}
