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
package com.pileproject.drivecommand.model.ev3.port;

import com.pileproject.drivecommand.machine.device.port.InputPort;

/**
 * An input port class for LEGO MINDSTORMS EV3. This class is used for connecting a device to an input port.
 *
 * There are static instances of this class:
 * <ul>
 *  <li>{@link Ev3InputPort#PORT_1}</li>
 *  <li>{@link Ev3InputPort#PORT_2}</li>
 *  <li>{@link Ev3InputPort#PORT_3}</li>
 *  <li>{@link Ev3InputPort#PORT_4}</li>
 * </ul>
 */
public class Ev3InputPort extends InputPort {
    public static final Ev3InputPort PORT_1 = new Ev3InputPort(0);
    public static final Ev3InputPort PORT_2 = new Ev3InputPort(1);
    public static final Ev3InputPort PORT_3 = new Ev3InputPort(2);
    public static final Ev3InputPort PORT_4 = new Ev3InputPort(3);
    private final int mPort;

    private Ev3InputPort(int port) {
        mPort = port;
    }

    @Override
    public int getRaw() {
        return mPort;
    }

    @Override
    public String toString() {
        return "[EV3] INPUT-PORT-" + (mPort + 1);
    }
}
