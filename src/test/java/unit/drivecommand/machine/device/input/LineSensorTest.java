package unit.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.model.nxt.port.NxtInputPort;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class LineSensorTest {
	@Mocked
	private ProtocolBase protocol;
	private final InputPort PORT = new InputPort() {
		@Override
		public int getRaw() {
			return 1;
		}
	};
	private final int VALUE_SENSOR = 50;
	private final String KEY_VALUE = "value";
	
	@Test
	public void getSensorValue() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase) any);
			result = new HashMap<String, Object>() {{
				put(KEY_VALUE, VALUE_SENSOR);
			}};
		}};

		LineSensor ls = new LineSensor(PORT, protocol);
		AssertJUnit.assertEquals(ls.getSensorValue(), VALUE_SENSOR);
	}
	
	@Test
	public void deviceTypeIsLineSensor() {
		LineSensor ls = new LineSensor(NxtInputPort.PORT_1, protocol);
		AssertJUnit.assertEquals(ls.getDeviceType(), DeviceType.LINE_SENSOR);
	}
}
