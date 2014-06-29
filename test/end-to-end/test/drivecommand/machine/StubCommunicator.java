package test.drivecommand.machine;

import java.io.IOException;

import com.pile_drive.drivecommand.model.com.ICommunicator;

public class StubCommunicator implements ICommunicator {
	private byte[] mValue = null;
	private boolean mIsOpen = false;
	
	@Override
	public void open() throws IOException {
		mIsOpen = true;
	}

	@Override
	public void close() {
		mIsOpen = false;
	}
	
	@Override
	public boolean send(byte[] data, int timeout) {
		return true;
	}

	@Override
	public byte[] recv(int length, int timeout) {
		return mValue;
	}
	
	public void setValue(byte[] value) {
		mValue = value;
	}
	
	public boolean isOpen() {
		return mIsOpen;
	}
}
