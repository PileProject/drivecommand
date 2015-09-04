package unit.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class LineSensorTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final int VALUE_SENSOR = 50;
	private final String KEY_VALUE = "value";
	
	@Test
	public void getSensorValue() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_SENSOR);}};
		}};
		LineSensor ls = new LineSensor(PORT, protocol);
		assertEquals(ls.getSensorValue(), VALUE_SENSOR);
	}
	
	@Test
	public void deviceTypeIsLineSensor() {
		LineSensor ls = new LineSensor(PORT, protocol);
		assertEquals(ls.getDeviceType(), DeviceType.LINE_SENSOR);
	}
}
