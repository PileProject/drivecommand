package unit.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.SoundSensor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class SoundSensorTest {
	@Mocked private ProtocolBase protocol;
	private final InputPort PORT = new InputPort() {
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
	private final int VALUE_DB = 100;
	private final String KEY_VALUE = "value";
	
	@Test
	public void getSoundDb() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_DB);}};
		}};
		SoundSensor ss = new SoundSensor(PORT, protocol);
		AssertJUnit.assertEquals(ss.getDb(), VALUE_DB);
	}
	
	@Test
	public void deviceTypeIsSoundSensor() {
		SoundSensor ss = new SoundSensor(PORT, protocol);
		AssertJUnit.assertEquals(ss.getDeviceType(), DeviceType.SOUND_SENSOR);
	}
}

