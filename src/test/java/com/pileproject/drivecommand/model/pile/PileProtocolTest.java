package com.pileproject.drivecommand.model.pile;

import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.model.com.ICommunicator;

import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Mocked;

/**
 * Created by tatsuya on 2016/02/22.
 */
public class PileProtocolTest {
    @Mocked
    private ICommunicator communicator;

    // TODO: add negative version of tests

    @Test
    public void openSuccessfully() throws Exception {
        new Expectations() {{
            communicator.open();
        }};
        ProtocolBase protocol = new PileProtocol(communicator);
        protocol.open();
    }

    @Test
    public void closeSuccessfully() throws Exception {
        new Expectations() {{
            communicator.close();
        }};
        ProtocolBase protocol = new PileProtocol(communicator);
        protocol.close();
    }

    @Test
    public void execSuccessfully() throws Exception {
        // TODO: check whether each operation works properly
    }

    @Test
    public void applySuccessfully() throws Exception {
        // TODO: complete this
        new Expectations() {{
            // communicator.write(foo);
        }};
        ProtocolBase protocol = new PileProtocol(communicator);
        // protocol.apply();
    }

    @Test
    public void loadSuccessfully() throws Exception {
        // TODO: complete this method
        new Expectations() {{
            // communicator.write(foo);
            // communicator.read(foo);
        }};
        ProtocolBase protocol = new PileProtocol(communicator);
        // TODO: check the value and add a value for this before this
        // protocol.load(0);
    }

    @Test
    public void storeSuccessfully() throws Exception {
        // TODO: complete this method
        new Expectations() {{
            // communicator.write();
        }};
        ProtocolBase protocol = new PileProtocol(communicator);
        // TODO: specify key and value, and read the value after this
        // protocol.store(0, null);
    }
}