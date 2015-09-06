package com.pileproject.drivecommand.model.nxt.port;

import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.model.nxt.NxtProtocol;

/**
 * Created by tatsuya on 15/09/03.
 */
public class NxtInputPort extends InputPort {
	private final int mPort;

	public static final NxtInputPort PORT_1 = new NxtInputPort(0);
	public static final NxtInputPort PORT_2 = new NxtInputPort(1);
	public static final NxtInputPort PORT_3 = new NxtInputPort(2);
	public static final NxtInputPort PORT_4 = new NxtInputPort(3);

	private NxtInputPort(int port) {
		mPort = port;
	}

	@Override
	public boolean isValid(ProtocolBase protocol) {
		return protocol instanceof NxtProtocol;
	}

	@Override
	public boolean isInvalid(ProtocolBase protocol) {
		return !(protocol instanceof NxtProtocol);
	}

	@Override
	public int getRaw() {
		return mPort;
	}
}
