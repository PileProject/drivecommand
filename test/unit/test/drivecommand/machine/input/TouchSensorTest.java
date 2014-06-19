package test.drivecommand.machine.input;

import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.input.TouchSensor;
import com.pile_drive.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class TouchSensorTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final boolean VALUE_TOUCHED = true;
	private final int VALUE_COUNT = 20;
	private final String KEY_VALUE = "value";
	
	@Test
	public void checkTouchSensorWasTouched() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_TOUCHED);}};
		}};
		TouchSensor ts = new TouchSensor(PORT, protocol);
		assertEquals(ts.isTouched(), VALUE_TOUCHED);
	}
	
	@Test
	public void getTouchedCount() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_COUNT);}};
		}};
		TouchSensor ts = new TouchSensor(PORT, protocol);
		assertEquals(ts.getTouchedCount(), VALUE_COUNT);
	}
	
	@Test
	public void deviceTypeIsTouchSensor() {
		TouchSensor ts = new TouchSensor(PORT, protocol);
		assertEquals(ts.getDeviceType(), DeviceType.TOUCH_SENSOR);
	}
}

