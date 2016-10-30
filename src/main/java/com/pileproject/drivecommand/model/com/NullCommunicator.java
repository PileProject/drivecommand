package com.pileproject.drivecommand.model.com;

import java.io.IOException;

/**
 * Null object of {@link ICommunicator}.
 */
public class NullCommunicator implements ICommunicator {

    @Override
    public void open() throws IOException {
        // no-op
    }

    @Override
    public void close() {
        // no-op
    }

    @Override
    public void write(byte[] data) throws RuntimeException {
        // no-op
    }

    @Override
    public byte[] read(int length) throws RuntimeException {
        return new byte[length];
    }
}
