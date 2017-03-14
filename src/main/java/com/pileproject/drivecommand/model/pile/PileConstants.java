/**
 * Copyright (C) 2011-2017 The PILE Developers <pile-dev@googlegroups.com>
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

import com.pileproject.drivecommand.machine.device.output.Led;
import com.pileproject.drivecommand.machine.device.output.Motor;

/**
 * A class that holds <code>byte</code> constants for making PILE machines' commands.
 */
public class PileConstants {

    /**
     * An enum class for the types of commands. This class will be used as <code>Type</code> in a command which has the
     * following syntax.
     *
     * <pre><code>
     *     |Length[1 byte]|Type[1 byte]|Data[Length-3 bytes]|CheckSum[1 byte]|
     * </code></pre>
     * <ul>
     *      <li>Length: Total packet length including the length byte. This must be equal or less than 64 bytes.</li>
     *      <li>Type: See each constant below</li>
     *      <li>Data: See JavaDocs of each command below</li>
     *      <li>Checksum: Xored value of each byte: Length, Type and Data.</li>
     * </ul>
     */
    public enum CommandTypes {
        /**
         * Moves a machine.
         * <p><b>NOTE: It is necessary to call {@link #APPLY} command after this command.</b></p>
         *
         * <pre><code>
         *  INPUT:  |RESERVED[2 bit],PORT[4 bit],DIR[2 bit]|PERCENT[8 bit]|
         * </code></pre>
         * <ul>
         *      <li>PORT:
         *          <ul>
         *              <li>0: LEFT wheel</li>
         *              <li>1: RIGHT wheel</li>
         *          </ul>
         *      </li>
         *      <li>DIR:
         *          <ul>
         *              <li>0x00: FREE</li>
         *              <li>0x01: FORWARD</li>
         *              <li>0x02: BACKWARD</li>
         *              <li>0x03: BRAKE</li>
         *          </ul>
         *      </li>
         *      <li>PERCENT: 0-100</li>
         * </ul>
         *
         * <pre><code>
         *  OUTPUT: |RESERVED[7 bit],ACK[1 bit]|
         * </code></pre>
         * <ul>
         *      <li>ACK:
         *          <ul>
         *              <li>0: Failure</li>
         *              <li>1: Success</li>
         *          </ul>
         *      </li>
         * </ul>
         */
        MOVE(0x00),
        /**
         * Starts a music.
         * <p><b>NOTE: It is necessary to call {@link #APPLY} command after this command.</b></p>
         *
         * <pre><code>
         *  INPUT:  |Type[1 byte]|
         * </code></pre>
         *
         * <pre><code>
         *  OUTPUT: |RESERVED[7 bit],ACK[1 bit]|
         * </code></pre>
         * <ul>
         *      <li>ACK:
         *          <ul>
         *              <li>0: Failure</li>
         *              <li>1: Success</li>
         *          </ul>
         *      </li>
         * </ul>
         */
        MUSIC(0x01),
        /**
         * Returns the status of a touch sensor.
         *
         * <pre><code>
         *  INPUT:  |PORT[1 byte]|
         * </code></pre>
         *
         * <pre><code>
         *  OUTPUT: |RESERVED[7 bit],STATUS[1 bit]|
         * </code></pre>
         * <ul>
         *      <li>STATUS:
         *          <ul>
         *              <li>0: Not pressed</li>
         *              <li>1: Pressed</li>
         *          </ul>
         *      </li>
         * </ul>
         * If <code>PORT</code> is out of range, <code>STATUS</code> will be zero.
         */
        TOUCH(0x10),
        /**
         * Returns the distance between an obstacle and a rangefinder.
         *
         * <pre><code>
         *  INPUT:  |PORT[1 byte]|
         * </code></pre>
         *
         * <pre><code>
         *  OUTPUT: |DISTANCE[1 byte]|
         * </code></pre>
         * <ul>
         *      <li>DISTANCE: Raw value of the sensor will be returned (no unit).</li>
         * </ul>
         * If <code>PORT</code> is out of range, <code>DISTANCE</code> will be zero.
         */
        DISTANCE(0x11),
        /**
         * Returns the brightness from a light sensor.
         *
         * <pre><code>
         *  INPUT:  |PORT[1 byte]|
         * </code></pre>
         * <ul>
         *      <li>PORT:
         *          <ul>
         *              <li>0: Left side</li>
         *              <li>1: Right side</li>
         *          </ul>
         *      </li>
         * </ul>
         *
         * <pre><code>
         *  OUTPUT: |BRIGHTNESS[1 byte]|
         * </code></pre>
         * <ul>
         *      <li>BRIGHTNESS: No unit. Raw value of the sensor will be returned.
         *          The brightness would be different w/ and w/o light.</li>
         * </ul>
         * If <code>PORT</code> is out of range, <code>BRIGHTNESS</code> will be zero.
         */
        LIGHTSENSOR(0x12),
        /**
         * Changes the status of a LED.
         * <p><b>NOTE: It is necessary to call {@link #APPLY} command after this command.</b></p>
         *
         * <pre><code>
         *  INPUT:  |RESERVED[4 bit],PORT[3 bit],ONOFF[1 bit]|
         * </code></pre>
         * <ul>
         *      <li>PORT:
         *          <ul>
         *              <li>0: LED(white)</li>
         *          </ul>
         *      </li>
         *      <li>ONOFF:
         *          <ul>
         *              <li>0: OFF</li>
         *              <li>1: ON</li>
         *          </ul>
         *      </li>
         * </ul>
         *
         * <pre><code>
         *  OUTPUT: |RESERVED[7 bit],ACK[1 bit]|
         * </code></pre>
         * <ul>
         *      <li>ACK:
         *          <ul>
         *              <li>0: Failure</li>
         *              <li>1: Success</li>
         *          </ul>
         *      </li>
         * </ul>
         */
        LED(0x13),
        /**
         * Loads a parameter stored with the specified key from the target machine.
         *
         * <pre><code>
         *  INPUT:  |KEY_ID[1 byte]|
         * </code></pre>
         * <ul>
         *      <li>KEY_ID: ID to load a value</li>
         * </ul>
         *
         * <pre><code>
         *  OUTPUT: |LENGTH[1 byte]|PAYLOAD[LENGTH bytes]|
         * </code></pre>
         * <ul>
         *      <li>LENGTH:  Length of the payload. Zero will be returned if the key does not exist.</li>
         *      <li>PAYLOAD: Data specified by <code>KEY_ID</code></li>
         * </ul>
         */
        LOAD(0x60),
        /**
         * Stores a parameter with a key to the target machine.
         *
         * <pre><code>
         *  INPUT: |KEY_ID[1 byte]|PAYLOAD[variable bytes]|
         * </code></pre>
         * <ul>
         *      <li>KEY_ID: ID which is associated with the payload</li>
         *      <li>PAYLOAD: Data to be stored. If the length of payload is zero (i.e., payload is empty), a parameter
         *      specified by <code>KEY_ID</code> will be removed</li>
         * </ul>
         *
         * <pre><code>
         *  OUTPUT:  |RESERVED[7 bits],ACK[1 bit]|
         * </code></pre>
         * <ul>
         *      <li>ACK:
         *          <ul>
         *              <li>0: Failure</li>
         *              <li>1: Success</li>
         *          </ul>
         *      </li>
         * </ul>
         */
        STORE(0x61),
        /**
         * Applies the changes of output values atomically ({@link #MOVE}/{@link #MUSIC}/{@link #LED}).
         *
         * <pre><code>
         *  INPUT:  |RESERVED[1 byte]|
         * </code></pre>
         *
         * <pre><code>
         *  OUTPUT:  |RESERVED[7 bits],ACK[1 bit]|
         * </code></pre>
         * <ul>
         *      <li>ACK:
         *          <ul>
         *              <li>0: Failure</li>
         *              <li>1: Success</li>
         *          </ul>
         *      </li>
         * </ul>
         */
        APPLY(0x70),
        /**
         * Prints the data to UART (for debug).
         *
         * <pre><code>
         *  INPUT:  any
         * </code></pre>
         *
         * <pre><code>
         *  OUTPUT:  noting
         * </code></pre>
         */
        PRINT(0x80),
         /**
         * Prints the data to UART and returns the same data to Bluetooth (for debug).
         *
         * <pre><code>
         *  INPUT:  any
         * </code></pre>
         *
         * <pre><code>
         *  OUTPUT:  INPUT
         * </code></pre>
         */
        ECHOBACK(0x81);

        private int mValue;

        CommandTypes(int value) {
            mValue = value;
        }

        public int value() {
            return mValue;
        }
    }

    /**
     * An enum class for the status (ON/OFF) of {@link Led}s. This class will be used as <code>ONOFF</code> in a
     * {@link CommandTypes#LED} command which has the following syntax.
     *
     * <pre><code>
     *     |RESERVED[4 bit],PORT[3 bit],ONOFF[1 bit]|
     * </code></pre>
     *
     * @see CommandTypes#LED
     */
    public enum LedState {
        ON((byte) 0x01),
        OFF((byte) 0x00);

        private byte mValue;

        LedState(byte value) {
            mValue = value;
        }

        public byte value() {
            return mValue;
        }
    }

    /**
     * An enum class for the status of {@link Motor}s. This class will be used as <code>DIR</code> in a
     * {@link CommandTypes#MOVE} command which has the following syntax.
     *
     * <pre><code>
     *     |RESERVED[2 bit],PORT[4 bit],DIR[2 bit]|PERCENT[8 bit]|
     * </code></pre>
     *
     * @see CommandTypes#MOVE
     */
    public enum MotorDir {
        FREE((byte) 0x00),
        FORWARD((byte) 0x01),
        BACKWARD((byte) 0x02),
        BRAKE((byte) 0x03);

        private byte mValue;

        MotorDir(byte value) {
            mValue = value;
        }

        public byte value() {
            return mValue;
        }
    }
}
