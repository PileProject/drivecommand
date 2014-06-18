package test.drivecommand.machine.input;

import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.input.LineSensor;
import com.pile_drive.drivecommand.model.ProtocolBase;
@SuppressWarnings("serial")
public class LineSensorTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final int SENSOR_VALUE = 50;
	
	@Test
	public void getSensorValue() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put("value", SENSOR_VALUE);}};
		}};
		LineSensor ls = new LineSensor(PORT, protocol);
		assertEquals(ls.getSensorValue(), SENSOR_VALUE);
	}
	
	@Test
	public void deviceTypeIsLineSensor() {
		LineSensor ls = new LineSensor(PORT, protocol);
		assertEquals(ls.getDeviceType(), DeviceType.LINE_SENSOR);
	}
}
