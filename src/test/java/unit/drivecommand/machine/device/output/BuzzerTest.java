package unit.drivecommand.machine.device.output;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.output.Buzzer;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class BuzzerTest {
	@Mocked private ProtocolBase protocol;
	private final OutputPort PORT = new OutputPort() {
		@Override
		public boolean isValid(ProtocolBase protocol) {
			return true;
		}

		@Override
		public boolean isInvalid(ProtocolBase protocol) {
			return false;
		}

		@Override
		public int getRaw() {
			return 1;
		}
	};

	private final String KEY_VALID = "valid";
	private final boolean VALUE_VALID = true;
	
	@Test
	public void turnOnBuzzer() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		Buzzer bz = new Buzzer(PORT, protocol);
		bz.turnOn();
	}
	
	@Test
	public void turnOffBuzzer() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		Buzzer bz = new Buzzer(PORT, protocol);
		bz.turnOff();
	}
	
	@Test
	public void beepBuzzer() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALID, VALUE_VALID);}};
		}};
		Buzzer bz = new Buzzer(PORT, protocol);
		bz.beep();
	}
	
	@Test
	public void deviceTypeIsBuzzer() {
		Buzzer bz = new Buzzer(PORT, protocol);
		AssertJUnit.assertEquals(bz.getDeviceType(), DeviceType.BUZZER);
	}}
