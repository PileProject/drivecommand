package com.pileproject.drivecommand.model.nxt;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.model.com.NullCommunicator;

import java.io.IOException;
import java.util.Map;

public class NxtNullProtocol extends NxtProtocol {

    public NxtNullProtocol() {
        super(new NullCommunicator());
    }

    @Override
    public void open() throws IOException {
        // no-op
    }

    @Override
    public void close() {
        // no-op
    }

    @Override
    public Map<String, Object> exec(int port, CommandBase cmd) {
        throw new UnsupportedOperationException("NxtNullProtocol does not support execution");
    }

    @Override
    public boolean apply() {
        throw new UnsupportedOperationException("NxtNullProtocol does not support transactions");
    }

    @Override
    public byte[] load(int key) {
        throw new UnsupportedOperationException("NxtNullProtocol does not support key-value store");
    }

    @Override
    public boolean store(int key, byte[] data) {
        throw new UnsupportedOperationException("NxtNullProtocol does not support key-value store");
    }
}
