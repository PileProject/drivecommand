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

package com.pileproject.drivecommand.model.ev3.port;

import com.pileproject.drivecommand.machine.device.port.OutputPort;

/**
 * An output port class for Ev3.
 * This class is used for connecting devices to a machine.
 *
 * There are static instances of this class;
 *  {@link Ev3OutputPort#PORT_A}
 *  {@link Ev3OutputPort#PORT_B}
 *  {@link Ev3OutputPort#PORT_C}
 *  {@link Ev3OutputPort#PORT_D}
 */
public class Ev3OutputPort extends OutputPort {
    public static final Ev3OutputPort PORT_A = new Ev3OutputPort(0);
    public static final Ev3OutputPort PORT_B = new Ev3OutputPort(1);
    public static final Ev3OutputPort PORT_C = new Ev3OutputPort(2);
    public static final Ev3OutputPort PORT_D = new Ev3OutputPort(3);
    private final int mPort;

    private Ev3OutputPort(int port) {
        mPort = port;
    }

    @Override
    public int getRaw() {
        return mPort;
    }

    @Override
    public String toString() {
        return "[EV3] OUTPUT-PORT-" + (char) ('A' + mPort);
    }
}
