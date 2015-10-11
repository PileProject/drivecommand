package com.pileproject.drivecommand.model.ev3.port;

import com.pileproject.drivecommand.machine.device.port.OutputPort;

/**
 * Created by yusaku on 2015/10/04.
 */
public class Ev3OutputPort extends OutputPort {
    public static final Ev3OutputPort PORT_A = new Ev3OutputPort(0);
    public static final Ev3OutputPort PORT_B = new Ev3OutputPort(1);
    public static final Ev3OutputPort PORT_C = new Ev3OutputPort(2);
    public static final Ev3OutputPort PORT_D = new Ev3OutputPort(3);
    private final int mPort;

    private Ev3OutputPort(int port) {
        mPort = port;
    }

    @Override
    public int getRaw() {
        return mPort;
    }

    @Override
    public String toString() {
        return "[EV3] OUTPUT-PORT-" + (char) ('A' + mPort);
    }
}
