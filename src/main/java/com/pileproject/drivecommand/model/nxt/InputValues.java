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
package com.pileproject.drivecommand.model.nxt;

/**
 * A sensor input values for a remote NXT accessed via LCP.
 *
 * @author <a href="mailto:bbagnall@mts.net">Brian Bagnall</a>
 * @see <a href="http://sourceforge.net/projects/lejos/files/lejos-NXJ/">LeJOS</a>
 */
public class InputValues {
    public int inputPort;
    /**
     * NXT indicates if it thinks the data is valid
     */
    public boolean valid = true;
    public boolean isCalibrated;
    public int sensorType;
    public int sensorMode;
    /**
     * The raw value from the Analog to Digital (AD) converter.
     */
    public int rawADValue;
    /**
     * The normalized value from the Analog to Digital (AD) converter.
     * I really don't know for sure which values are normalized yet.
     * 0 to 1023
     */
    public int normalizedADValue;
    /**
     * The scaled value starts working after the first call to the sensor.
     * The first value will be the raw value, but after that it produces scaled values.
     * With the touch sensor, off scales to 0 and on scales to 1.
     */
    public short scaledValue;
    /**
     * Currently unused.
     */
    public short calibratedValue;
}
