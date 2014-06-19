package test.drivecommand.machine.input;

import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.input.Rangefinder;
import com.pile_drive.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class RangefinderTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final int VALUE_DISTANCE = 200;
	private final String KEY_VALUE = "value";
	
	@Test
	public void getDistance() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_DISTANCE);}};
		}};
		Rangefinder rf = new Rangefinder(PORT, protocol);
		assertEquals(rf.getDistance(), VALUE_DISTANCE);
	}
	
	@Test
	public void deviceTypeIsRangefinder() {
		Rangefinder rf = new Rangefinder(PORT, protocol);
		assertEquals(rf.getDeviceType(), DeviceType.RANGEFINDER);
	}
}

