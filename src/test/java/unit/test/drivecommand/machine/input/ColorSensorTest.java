package test.drivecommand.machine.input;

import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.DeviceType;
import com.pileproject.drivecommand.machine.input.ColorSensor;
import com.pileproject.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class ColorSensorTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final byte[] VALUE_RGB = {0, 100, (byte) 255};
	private final int VALUE_ILLUMINANCE = 22;
	private final String KEY_VALUE = "value";
	
	@Test
	public void getColorRgb() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_RGB);}};
		}};
		ColorSensor cs = new ColorSensor(PORT, protocol);
		assertEquals(cs.getRgb(), VALUE_RGB);
	}
	
	@Test
	public void getColorIlluminace() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_ILLUMINANCE);}};
		}};
		ColorSensor cs = new ColorSensor(PORT, protocol);
		assertEquals(cs.getIlluminace(), VALUE_ILLUMINANCE);
	}
	
	@Test
	public void deviceTypeIsColorSensor() {
		ColorSensor cs = new ColorSensor(PORT, protocol);
		assertEquals(cs.getDeviceType(), DeviceType.COLOR_SENSOR);
	}
}

