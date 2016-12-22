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
package com.pileproject.drivecommand.model.nxt.port;

import com.pileproject.drivecommand.machine.device.port.InputPort;

/**
 * An input port class for Nxt.
 * This class is used for connecting devices to a machine.
 *
 * There are static instances of this class;
 *  {@link NxtInputPort#PORT_1}
 *  {@link NxtInputPort#PORT_2}
 *  {@link NxtInputPort#PORT_3}
 *  {@link NxtInputPort#PORT_4}
 */
public class NxtInputPort extends InputPort {
    public static final NxtInputPort PORT_1 = new NxtInputPort(0);
    public static final NxtInputPort PORT_2 = new NxtInputPort(1);
    public static final NxtInputPort PORT_3 = new NxtInputPort(2);
    public static final NxtInputPort PORT_4 = new NxtInputPort(3);
    private final int mPort;

    private NxtInputPort(int port) {
        mPort = port;
    }

    @Override
    public int getRaw() {
        return mPort;
    }

    @Override
    public String toString() {
        return "[NXT] INPUT-PORT-" + (mPort + 1);
    }
}
