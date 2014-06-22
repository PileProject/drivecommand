package test.drivecommand.machine;

import java.io.IOException;
import java.nio.ByteBuffer;

import com.pile_drive.drivecommand.model.com.ICommunicator;

public class StubCommunicator implements ICommunicator{

	@Override
	public void open() throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void close() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public boolean send(ByteBuffer data, int timeout) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public ByteBuffer recv(int length, int timeout) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
}
