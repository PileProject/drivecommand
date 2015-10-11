package com.pileproject.drivecommand.model.com;

import java.io.IOException;

public interface ICommunicator {
    /**
     * Open the connection between devices.
     *
     * @throws IOException
     */
    void open() throws IOException;
    
    /**
     * Close the connection between devices.
     */
    void close();
    
    /**
     * Write the byte array data to the device.
     *
     * @param data
     * @param timeout Max waiting time for the end of this communication. [Unit: ms]
     * @throws RuntimeException
     */
    void write(byte[] data, int timeout) throws RuntimeException;
    
    /**
     * Read the response from the device.
     *
     * @param length  The max length of response wanted to be read.
     * @param timeout Max waiting time for the end of this communication. [Unit: ms]
     * @return
     * @throws RuntimeException
     */
    byte[] read(int length, int timeout) throws RuntimeException;
}
