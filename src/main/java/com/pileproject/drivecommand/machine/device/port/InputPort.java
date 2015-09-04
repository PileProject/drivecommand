package com.pileproject.drivecommand.machine.device.port;

import com.pileproject.drivecommand.model.ProtocolBase;

/**
 * Created by tatsuya on 15/09/04.
 */
public abstract class InputPort implements DevicePort {
    @Override
    public abstract boolean isValid(ProtocolBase protocol);

    @Override
    public abstract boolean isInvalid(ProtocolBase protocol);

    @Override
    public abstract int getRaw();
}
