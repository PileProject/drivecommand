/**
 * Copyright (C) 2011-2016 The DriveCommand Authors <pile-dev@googlegroups.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pileproject.drivecommand.model.ev3;

import com.pileproject.drivecommand.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * A formatter class for Ev3 byte codes.
 * This class makes byte arrays which are used as byte code commands to control
 * Ev3 with a device.
 */
public class ByteCodeFormatter {
    // parameter size
    private static final byte BYTE_SIZE = (byte) 0x81;
    private static final byte SHORT_SIZE = (byte) 0x82;
    private static final byte INT_SIZE = (byte) 0x83;
    @SuppressWarnings("unused")
    private static final byte STRING_SIZE = (byte) 0x84;
    private static final byte GLOBAL_INDEX_SIZE = (byte) 0xe1;
    private static String TAG = "ByteCodeFormatter";
    private ByteArrayOutputStream mStream;
    // use DataOutputStream as a writer of ByteArrayOutputStream
    private DataOutputStream mWriter;

    public ByteCodeFormatter() {
        mStream = new ByteArrayOutputStream();
        mWriter = new DataOutputStream(mStream);

        // add header
        // the 1st and 2nd byte show the length of this byte code
        // they will be set when byteArray() is called
        // next 2 bytes are identification codes
        // you can use them to identify the pair of
        // request and response
        // (in current implementation, the default is [0x00, 0x00]).
        byte[] header = {
                0x00, 0x00, 0x00, 0x00
        };
        try {
            mWriter.write(header);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add an opcode.
     *
     * @param opcode the operation code
     */
    public void addOpCode(byte opcode) {
        try {
            mWriter.writeByte(opcode);
        } catch (IOException e) {
            Log.e(TAG, "Couldn't write opcode", e);
        }
    }

    /**
     * Add global and local buffer size.
     *
     * @param global size of global buffer in byte
     * @param local  size of local buffer in byte
     */
    public void addGlobalAndLocalBufferSize(int global, int local) {
        if (global > 1024)
            throw new IllegalArgumentException("Global buffer must be less than 1024 bytes");
        if (local > 64)
            throw new IllegalArgumentException("Local buffer must be less than 64 bytes");

        // write 2 bytes in form of (llllllgg gggggggg)
        try {
            mWriter.writeByte(global); // LSB
            mWriter.writeByte((local << 2) | ((global >> 8) & 0x03)); // MSB
        } catch (IOException e) {
            Log.e(TAG, "Couldn't write global and local buffer size", e);
        }
    }

    /**
     * Add a byte type parameter.
     *
     * @param param a parameter in byte
     */
    public void addParameter(byte param) {
        try {
            mWriter.writeByte(BYTE_SIZE);
            mWriter.writeByte(param);
        } catch (IOException e) {
            Log.e(TAG, "Couldn't write parameter (byte)", e);
        }
    }

    /**
     * Add a short type parameter.
     *
     * @param param a parameter in short
     */
    public void addParameter(short param) {
        try {
            mWriter.writeByte(SHORT_SIZE);
            mWriter.writeByte(param);
            mWriter.writeByte(param >> 8);
        } catch (IOException e) {
            Log.e(TAG, "Couldn't write parameter (short)", e);
        }
    }

    /**
     * Add an int type parameter.
     *
     * @param param a parameter in int
     */
    public void addParameter(int param) {
        try {
            mWriter.writeByte(INT_SIZE);
            mWriter.writeByte(param);
            mWriter.writeByte(param >> 8);
            mWriter.writeByte(param >> 16);
            mWriter.writeByte(param >> 24);
        } catch (IOException e) {
            Log.e(TAG, "Couldn't write parameter (int)", e);
        }
    }


    /**
     * Add the global index.
     *
     * @param index the global index
     */
    public void addGlobalIndex(byte index) {
        try {
            mWriter.writeByte(GLOBAL_INDEX_SIZE);
            mWriter.writeByte(index);
        } catch (IOException e) {
            Log.e(TAG, "Couldn't add global index", e);
        }
    }

    /**
     * Append other command.
     *
     * @param command an other command
     */
    public void appendCommand(ByteCodeFormatter command) {
        try {
            mWriter.write(command.byteArray());
        } catch (IOException e) {
            Log.e(TAG, "Couldn't append command", e);
        }
    }

    /**
     * Get the byte code in array of byte.
     *
     * @return byte[] an array of bytes
     */
    public byte[] byteArray() {
        byte[] byteCode = mStream.toByteArray();

        // subtract 2 for the first 2 bytes
        // which are used to tell the length of this byte code
        int bodyLength = byteCode.length - 2;

        // update the first 2 bytes to express the length of body
        byteCode[0] = (byte) (bodyLength & 0xff);
        byteCode[1] = (byte) ((bodyLength >>> 8) & 0xff);
        return byteCode;
    }
}
