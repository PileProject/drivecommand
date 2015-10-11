package com.pileproject.drivecommand.model.pile.port;

import com.pileproject.drivecommand.machine.device.port.InputPort;

/**
 * Created by yusaku on 2015/10/04.
 */
public class PileInputPort extends InputPort {
    public static final PileInputPort LINE_SENSOR_L
            = new PileInputPort(0, Type.LINE_SENSOR_L);

    public static final PileInputPort LINE_SENSOR_R
            = new PileInputPort(1, Type.LINE_SENSOR_R);

    public static final PileInputPort TOUCH_SENSOR
            = new PileInputPort(0, Type.TOUCH_SENSOR);

    public static final PileInputPort RANGEFINDER
            = new PileInputPort(0, Type.RANGEFINDER);
    private final int mPort;
    private final Type mType;
    private PileInputPort(int port, Type type) {
        mPort = port;
        mType = type;
    }

    @Override
    public int getRaw() {
        return mPort;
    }

    @Override
    public String toString() {
        return "[PILE] INPUT-PORT-" + mType;
    }

    private enum Type {
        LINE_SENSOR_R, LINE_SENSOR_L, TOUCH_SENSOR, RANGEFINDER
    }
}
