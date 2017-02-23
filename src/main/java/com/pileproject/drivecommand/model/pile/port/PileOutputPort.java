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
package com.pileproject.drivecommand.model.pile.port;

import com.pileproject.drivecommand.machine.device.port.OutputPort;

/**
 * An output port class for PILE machines. This class is used for connecting a device to an output port.
 *
 * There are static instances of this class:
 * <ul>
 *  <li>{@link PileOutputPort#MOTOR_LEFT}</li>
 *  <li>{@link PileOutputPort#MOTOR_RIGHT}</li>
 * </ul>
 */
public class PileOutputPort extends OutputPort {
    public static final PileOutputPort MOTOR_LEFT
            = new PileOutputPort(0, Type.MOTOR_LEFT);
    public static final PileOutputPort MOTOR_RIGHT
            = new PileOutputPort(1, Type.MOTOR_RIGHT);

    private final int mPort;
    private final Type mType;

    private PileOutputPort(int port, Type type) {
        mPort = port;
        mType = type;
    }

    @Override
    public int getRaw() {
        return mPort;
    }

    @Override
    public String toString() {
        return "[PILE] OUTPUT-PORT-" + mType;
    }

    private enum Type {
        MOTOR_LEFT, MOTOR_RIGHT,
    }
}
