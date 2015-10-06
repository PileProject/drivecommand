package unit.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.RemoteControlReceiver;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class RemoteControlRecieverTest {
	@Mocked
	private ProtocolBase protocol;
	private final InputPort PORT = new InputPort() {
		@Override
		public int getRaw() {
			return 1;
		}
	};
	private final int VALUE_BUTTON = 3;
	private final int VALUE_DISTANCE = 3;
	private final String KEY_VALUE = "value";
	
	@Test
	public void getRemoteControllerButton() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase) any);
			result = new HashMap<String, Object>() {{
				put(KEY_VALUE, VALUE_BUTTON);
			}};
		}};
		RemoteControlReceiver rr = new RemoteControlReceiver(PORT, protocol);
		AssertJUnit.assertEquals(rr.getRemoteButton(), VALUE_BUTTON);
	}
	
	@Test
	public void getRemoteControllerDistance() {
		new Expectations() {{
			protocol.exec(PORT.getRaw(), (CommandBase) any);
			result = new HashMap<String, Object>() {{
				put(KEY_VALUE, VALUE_DISTANCE);
			}};
		}};
		RemoteControlReceiver rr = new RemoteControlReceiver(PORT, protocol);
		AssertJUnit.assertEquals(rr.getRemoteDistance(), VALUE_DISTANCE);
	}
	
	@Test
	public void deviceTypeIsRemoteControlReciever() {
		RemoteControlReceiver rr = new RemoteControlReceiver(PORT, protocol);
		AssertJUnit.assertEquals(rr.getDeviceType(), DeviceType.REMOTECONTROL_RECIEVER);
	}
}

