package com.pile_drive.drivecommand.machine.input;

import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class GyroSensorTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final int ANGLE = 100;
	
	@SuppressWarnings("serial")
	@Test
	public void getGyroAngle() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any); 
			result = new HashMap<String, Object>() {{put("value", ANGLE);}};
		}};
		GyroSensor gs = new GyroSensor(PORT, protocol);
		assertEquals(gs.getAngle(), ANGLE);
	}
	
	@Test
	public void getGyroRate() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put("value", RATE);}};
		}};
		GyroSensor gs = new GyroSensor(PORT, protocol);
		assertEquals(gs.getRate(), RATE);
	}
}

