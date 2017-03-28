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

import com.pileproject.drivecommand.machine.device.port.InputPort;

/**
 * An input port class for PILE machines. This class is used for connecting a device to an input port.
 *
 * There are static instances of this class:
 * <ul>
 *  <li>{@link PileInputPort#LIGHT_SENSOR_L}</li>
 *  <li>{@link PileInputPort#LIGHT_SENSOR_R}</li>
 *  <li>{@link PileInputPort#TOUCH_SENSOR}</li>
 *  <li>{@link PileInputPort#RANGEFINDER}</li>
 * </ul>
 */
public class PileInputPort extends InputPort {
    public static final PileInputPort LIGHT_SENSOR_L
            = new PileInputPort(0, Type.LIGHT_SENSOR_L);
    public static final PileInputPort LIGHT_SENSOR_R
            = new PileInputPort(1, Type.LIGHT_SENSOR_R);
    public static final PileInputPort TOUCH_SENSOR
            = new PileInputPort(0, Type.TOUCH_SENSOR);
    public static final PileInputPort RANGEFINDER
            = new PileInputPort(0, Type.RANGEFINDER);

    private final int mPort;
    private final Type mType;

    private PileInputPort(int port, Type type) {
        mPort = port;
        mType = type;
    }

    @Override
    public int getRaw() {
        return mPort;
    }

    @Override
    public String toString() {
        return "[PILE] INPUT-PORT-" + mType;
    }

    private enum Type {
        LIGHT_SENSOR_R, LIGHT_SENSOR_L, TOUCH_SENSOR, RANGEFINDER
    }
}
