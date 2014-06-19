package test.drivecommand.machine.input;

import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.input.ColorSensor;
import com.pile_drive.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class ColorSensorTest {
	@Mocked private ProtocolBase protocol;
	@Mocked private CommandFactory factory = null;
	private final int PORT = 0;
	private final byte[] RGB = {0, 100, (byte) 255};
	private final int ILLUMINANCE = 22;
	
	@Test
	public void getColorRgb() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put("value", RGB);}};
		}};
		ColorSensor cs = new ColorSensor(PORT, protocol);
		assertEquals(cs.getRgb(), RGB);
	}
	
	@Test
	public void getColorIlluminace() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put("value", ILLUMINANCE);}};
		}};
		ColorSensor cs = new ColorSensor(PORT, protocol);
		assertEquals(cs.getIlluminace(), ILLUMINANCE);
	}
	
	@Test
	public void deviceTypeIsColorSensor() {
		ColorSensor cs = new ColorSensor(PORT, protocol);
		assertEquals(cs.getDeviceType(), DeviceType.COLOR_SENSOR);
	}
}

