package unit.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.GyroSensor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class GyroSensorTest {
	@Mocked
	private ProtocolBase protocol;
	private final InputPort PORT = new InputPort() {
		@Override
		public int getRaw() {
			return 1;
		}
	};
	private final int VALUE_ANGLE = 100;
	private final int VALUE_RATE = 22;
	private final String KEY_VALUE = "value";
	
	@Test
	public void getGyroAngle() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase) any);
			result = new HashMap<String, Object>() {{
				put(KEY_VALUE, VALUE_ANGLE);
			}};
		}};
		GyroSensor gs = new GyroSensor(PORT, protocol);
		AssertJUnit.assertEquals(gs.getAngle(), VALUE_ANGLE);
	}
	
	@Test
	public void getGyroRate() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase) any);
			result = new HashMap<String, Object>() {{
				put(KEY_VALUE, VALUE_RATE);
			}};
		}};
		GyroSensor gs = new GyroSensor(PORT, protocol);
		AssertJUnit.assertEquals(gs.getRate(), VALUE_RATE);
	}
	
	@Test
	public void deviceTypeIsGyroSensor() {
		GyroSensor gs = new GyroSensor(PORT, protocol);
		AssertJUnit.assertEquals(gs.getDeviceType(), DeviceType.GYRO_SENSOR);
	}
}

