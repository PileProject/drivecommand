package com.pileproject.drivecommand.model.nxt.port;

import com.pileproject.drivecommand.machine.device.port.InputPort;

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
    public int getRaw() {
        return mPort;
    }

    @Override
    public String toString() {
        return "[NXT] INPUT-PORT-" + (mPort + 1);
    }
}
