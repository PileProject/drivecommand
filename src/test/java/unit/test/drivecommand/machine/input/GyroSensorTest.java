package test.drivecommand.machine.input;

import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.input.GyroSensor;
import com.pile_drive.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class GyroSensorTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final int VALUE_ANGLE = 100;
	private final int VALUE_RATE = 22;
	private final String KEY_VALUE = "value";
	
	@Test
	public void getGyroAngle() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_ANGLE);}};
		}};
		GyroSensor gs = new GyroSensor(PORT, protocol);
		assertEquals(gs.getAngle(), VALUE_ANGLE);
	}
	
	@Test
	public void getGyroRate() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_RATE);}};
		}};
		GyroSensor gs = new GyroSensor(PORT, protocol);
		assertEquals(gs.getRate(), VALUE_RATE);
	}
	
	@Test
	public void deviceTypeIsGyroSensor() {
		GyroSensor gs = new GyroSensor(PORT, protocol);
		assertEquals(gs.getDeviceType(), DeviceType.GYRO_SENSOR);
	}
}

