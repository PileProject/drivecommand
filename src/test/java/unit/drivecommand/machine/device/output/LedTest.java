package unit.drivecommand.machine.device.output;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.output.Led;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class LedTest {
	@Mocked
	private ProtocolBase protocol;
	private final OutputPort PORT = new OutputPort() {
		@Override
		public int getRaw() {
			return 1;
		}
	};

	private final String KEY_VALID = "valid";
	private final boolean VALUE_VALID = true;
	
	@Test
	public void turnOnLed() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase) any);
			result = new HashMap<String, Object>() {{
				put(KEY_VALID, VALUE_VALID);
			}};
		}};
		Led led = new Led(PORT, protocol);
		led.turnOn();
	}
	
	@Test
	public void turnOffLed() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase) any);
			result = new HashMap<String, Object>() {{
				put(KEY_VALID, VALUE_VALID);
			}};
		}};
		Led led = new Led(PORT, protocol);
		led.turnOff();
	}
	
	
	@Test
	public void deviceTypeIsLed() {
		Led led = new Led(PORT, protocol);
		AssertJUnit.assertEquals(led.getDeviceType(), DeviceType.LED);
	}
}
