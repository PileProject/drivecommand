package com.pileproject.drivecommand.model.nxt.port;

import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.model.nxt.NxtProtocol;

/**
 * Created by tatsuya on 15/09/03.
 */
public class NxtOutputPort extends OutputPort {
	private final int mPort;

	public static final NxtOutputPort PORT_A = new NxtOutputPort(0);
	public static final NxtOutputPort PORT_B = new NxtOutputPort(1);
	public static final NxtOutputPort PORT_C = new NxtOutputPort(2);

	private NxtOutputPort(int port) {
		mPort = port;
	}

	@Override
	public boolean isValid(ProtocolBase protocol) {
		return protocol instanceof NxtProtocol;
	}

	@Override
	public boolean isInvalid(ProtocolBase protocol) {
		return !isValid(protocol);
	}

	@Override
	public int getRaw() {
		return mPort;
	}
}

