package test.drivecommand.machine.input;

import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.input.GyroSensor;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class GyroSensorTest {
	@Mocked private ProtocolBase protocol;
	@Mocked private CommandFactory factory = null;
	private final int PORT = 0;
	private final int ANGLE = 100;
	private final int RATE = 22;
	
	@Test
	public void getGyroAngle() {
		new Expectations() {{
			CommandFactory.createCommand(CommandType.GET_GYRO_ANGLE, null);
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put("value", ANGLE);}};
		}};
		GyroSensor gs = new GyroSensor(PORT, protocol);
		assertEquals(gs.getAngle(), ANGLE);
	}
	
	@Test
	public void getGyroRate() {
		new Expectations() {{
			CommandFactory.createCommand(CommandType.GET_GYRO_RATE, null);
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put("value", RATE);}};
		}};
		GyroSensor gs = new GyroSensor(PORT, protocol);
		assertEquals(gs.getRate(), RATE);
	}
	
	@Test
	public void deviceTypeIsGyroSensor() {
		GyroSensor gs = new GyroSensor(PORT, protocol);
		assertEquals(gs.getDeviceType(), DeviceType.GYRO_SENSOR);
	}
}

