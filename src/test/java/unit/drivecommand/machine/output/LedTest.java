package unit.drivecommand.machine.output;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Mocked;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.DeviceType;
import com.pileproject.drivecommand.machine.output.Led;
import com.pileproject.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class LedTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final String KEY_VALID = "valid";
	private final boolean VALUE_VALID = true;
	
	@Test
	public void turnOnLed() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		Led led = new Led(PORT, protocol);
		led.turnOn();
	}
	
	@Test
	public void turnOffLed() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		Led led = new Led(PORT, protocol);
		led.turnOff();
	}
	
	
	@Test
	public void deviceTypeIsLed() {
		Led led = new Led(PORT, protocol);
		assertEquals(led.getDeviceType(), DeviceType.LED);
	}
}
