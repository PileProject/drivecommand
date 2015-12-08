/*
 * Copyright (C) 2011-2015 PILE Project, Inc. <dev@pileproject.com>
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
 *
 */

package com.pileproject.drivecommand.model.pile;

public class PileConstants {
    // Command Types
    public enum CommandTypes {
        MOVE(0x00),
        MUSIC(0x01),
        TOUCH(0x10),
        DISTANCE(0x11),
        LINESENSOR(0x12),
        LED(0x13),
        LOAD(0x60),
        STORE(0x61),
        APPLY(0x70),
        PRINT(0x80),
        ECHOBACK(0x81);

        private int mValue;

        CommandTypes(int value) {
            mValue = value;
        }

        public int value() {
            return mValue;
        }
    }

    public enum LedState {
        // RESERVED[4bit] | PORT[3bit] (0: default) | ONOFF[1bit] (1: ON, 0: OFF)
        ON((byte) (0x00 | 0x00 | 0x01)),
        OFF((byte) (0x00 | 0x00 | 0x00));

        private byte mValue;

        LedState(byte value) {
            mValue = value;
        }

        public byte value() {
            return mValue;
        }
    }

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
