package unit.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class TouchSensorTest {
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
	private final boolean VALUE_TOUCHED = true;
	private final int VALUE_COUNT = 20;
	private final String KEY_VALUE = "value";
	
	@Test
	public void checkTouchSensorWasTouched() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_TOUCHED);}};
		}};
		TouchSensor ts = new TouchSensor(PORT, protocol);
		AssertJUnit.assertEquals(ts.isTouched(), VALUE_TOUCHED);
	}
	
	@Test
	public void getTouchedCount() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_COUNT);}};
		}};
		TouchSensor ts = new TouchSensor(PORT, protocol);
		AssertJUnit.assertEquals(ts.getTouchedCount(), VALUE_COUNT);
	}
	
	@Test
	public void deviceTypeIsTouchSensor() {
		TouchSensor ts = new TouchSensor(PORT, protocol);
		AssertJUnit.assertEquals(ts.getDeviceType(), DeviceType.TOUCH_SENSOR);
	}
}

