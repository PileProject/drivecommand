package test.drivecommand.machine;

import java.io.IOException;
import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.model.ProtocolBase;
import com.pile_drive.drivecommand.model.com.ICommunicator;

public class StubProtocol extends ProtocolBase {

	public StubProtocol(ICommunicator comm) {
		super(comm);
	}

	@Override
	public void open() throws IOException {
		getCommunicator().open();
	}

	@Override
	public void close() {
		getCommunicator().close();
	}

	@SuppressWarnings("serial")
	@Override
	public HashMap<String, Object> exec(int port, CommandBase cmd) {
		return new HashMap<String, Object>(){{put("value", true);}};
	}
}
