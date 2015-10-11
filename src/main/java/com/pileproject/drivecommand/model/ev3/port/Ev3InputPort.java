package com.pileproject.drivecommand.model.ev3.port;

import com.pileproject.drivecommand.machine.device.port.InputPort;

/**
 * Created by yusaku on 2015/10/04.
 */
public class Ev3InputPort extends InputPort {
    private final int mPort;

    public static final Ev3InputPort PORT_1 = new Ev3InputPort(0);
    public static final Ev3InputPort PORT_2 = new Ev3InputPort(1);
    public static final Ev3InputPort PORT_3 = new Ev3InputPort(2);
    public static final Ev3InputPort PORT_4 = new Ev3InputPort(3);

    private Ev3InputPort(int port) {
        mPort = port;
    }

    @Override
    public int getRaw() {
        return mPort;
    }

    @Override
    public String toString() {
        return "[EV3] INPUT-PORT-" + (mPort + 1);
    }
}
