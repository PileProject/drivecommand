package com.pile_drive.drivecommand.machine;

import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

import com.pile_drive.drivecommand.command.ICommand;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.IProtocol;

public class LineSensorTest {
	@Mocked private IProtocol protocol;
	
	@SuppressWarnings("serial")
	@Test
	public void getSensorValue() {
		new Expectations() {{
			protocol.exec(CommandType.GET_LS_VALUE.ordinal(), (ICommand)any); 
			result = new HashMap<String, Object>() {{put("value", 0xFF);}};
		}};
		LineSensor ls = new LineSensor(0, protocol);
		assertEquals(ls.getSensorValue(), 0xFF);
	}
}
