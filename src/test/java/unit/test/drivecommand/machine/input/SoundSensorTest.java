package test.drivecommand.machine.input;

import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.input.SoundSensor;
import com.pile_drive.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class SoundSensorTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final int VALUE_DB = 100;
	private final String KEY_VALUE = "value";
	
	@Test
	public void getSoundDb() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_DB);}};
		}};
		SoundSensor ss = new SoundSensor(PORT, protocol);
		assertEquals(ss.getDb(), VALUE_DB);
	}
	
	@Test
	public void deviceTypeIsSoundSensor() {
		SoundSensor ss = new SoundSensor(PORT, protocol);
		assertEquals(ss.getDeviceType(), DeviceType.SOUND_SENSOR);
	}
}

