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
package com.pileproject.drivecommand.model.pile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * A formatter class for packets of PILE machines.
 */
public class PilePacketFormatter {
    private ByteArrayOutputStream mByteStream;
    private boolean mIsValid;
    private boolean mIsFixed;

    public PilePacketFormatter(PileConstants.CommandTypes type) {
        mByteStream = new ByteArrayOutputStream();
        mByteStream.write(type.value());
        mIsValid = false;
        mIsFixed = false;
    }

    public PilePacketFormatter(byte[] byteArray) {
        mByteStream = new ByteArrayOutputStream();
        try {
            byte checksum = 0x00;
            for (int i = 0; i < byteArray.length - 1; i++)
                checksum ^= byteArray[i];
            if (checksum != byteArray[byteArray.length - 1])
                throw new IOException("Invalid Checksum");
            mByteStream.write(byteArray);
            mIsValid = true;
        } catch (IOException e) {
            e.printStackTrace();
            mByteStream = new ByteArrayOutputStream();
            mIsValid = false;
        }
        mIsFixed = true;
    }

    /**
     * Sets a data byte to the packet.
     *
     * @param dataByte a data to be appended
     */
    public void setDataByte(byte dataByte) {
        if (mIsFixed)
            return;
        mByteStream.write((int) dataByte);
    }

    /**
     * Calculates the checksum and fixes the command.
     */
    public void calculateChecksum() {
        if (mIsFixed)
            return;
        byte[] dataArray = mByteStream.toByteArray();
        int size = mByteStream.size() + 2; // (+2 means checksum)
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(size);
        byte checksum = (byte) (size & 0xFF);
        // Length
        byteStream.write(size);
        // Type, Data
        for (byte b : dataArray) {
            checksum ^= b;
            byteStream.write(b);
        }
        // Checksum
        byteStream.write(checksum);
        // Swap
        mByteStream = byteStream;
        mIsValid = true;
        mIsFixed = true;
    }

    /**
     * Returns the packet in a byte array format.
     *
     * @return a packet in a byte array
     */
    public byte[] byteArray() {
        if (!mIsValid)
            return null;
        return mByteStream.toByteArray();
    }

    /**
     * Gets the packet without its header.
     *
     * @return a data packet without its header
     */
    public byte[] data() {
        if (!mIsValid)
            return null;
        byte[] src = mByteStream.toByteArray();
        byte[] dst = new byte[src.length - 3];
        System.arraycopy(src, 2, dst, 0, src.length - 3);
        return dst;
    }

    /**
     * Checks the validity of this packet.
     *
     * @return valid (<code>true</code>) or (<code>false</code>)
     */
    public boolean isValid() {
        return mIsValid;
    }

    /**
     * Checks whether this packet is fixed or not.
     *
     * @return fixed (<code>true</code>) or (<code>false</code>)
     */
    public boolean isFixed() {
        return mIsFixed;
    }
}
