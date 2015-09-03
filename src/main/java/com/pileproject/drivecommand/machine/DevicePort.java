package com.pileproject.drivecommand.machine;

import com.pileproject.drivecommand.model.ProtocolBase;

/**
 * Created by tatsuya on 15/09/03.
 */
public interface DevicePort {
    public boolean isValid(ProtocolBase protocol);
    public boolean isInvalid(ProtocolBase protocol);
    public int getRaw();
}
