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

package com.pileproject.drivecommand.model.pile.port;

import com.pileproject.drivecommand.machine.device.port.InputPort;

/**
 * Created by yusaku on 2015/10/04.
 */
public class PileInputPort extends InputPort {
    public static final PileInputPort LINE_SENSOR_L
            = new PileInputPort(0, Type.LINE_SENSOR_L);

    public static final PileInputPort LINE_SENSOR_R
            = new PileInputPort(1, Type.LINE_SENSOR_R);

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
        LINE_SENSOR_R, LINE_SENSOR_L, TOUCH_SENSOR, RANGEFINDER
    }
}
