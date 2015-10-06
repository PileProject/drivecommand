package com.pileproject.drivecommand.model.pile.port;

import com.pileproject.drivecommand.machine.device.port.OutputPort;

/**
 * Created by yusaku on 2015/10/04.
 */
public class PileOutputPort extends OutputPort {
    public static final PileOutputPort MOTOR_LEFT
            = new PileOutputPort(0, Type.MOTOR_LEFT);

    public static final PileOutputPort MOTOR_RIGHT
            = new PileOutputPort(1, Type.MOTOR_RIGHT);

    private enum Type {
        MOTOR_LEFT, MOTOR_RIGHT,
    }

    private final int mPort;
    private final Type mType;

    private PileOutputPort(int port, Type type) {
        mPort = port;
        mType = type;
    }

    @Override
    public int getRaw() {
        return mPort;
    }

    @Override
    public String toString() {
        return "[PILE] OUTPUT-PORT-" + mType;
    }
}
