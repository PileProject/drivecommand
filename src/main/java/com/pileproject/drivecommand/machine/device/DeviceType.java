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
package com.pileproject.drivecommand.machine.device;

/**
 * An enum class which expresses types of devices.
 */
public enum DeviceType {
    /**
     * Motor
     * cf. SERVOMOTOR
     */
    MOTOR,

    /**
     * Servomotor
     * cf. MOTOR
     */
    SERVOMOTOR,
    BUZZER,
    LED,

    /**
     * Line sensor
     * ex. Light sensor for ev3
     */
    LINE_SENSOR,
    GYRO_SENSOR,
    TOUCH_SENSOR,
    COLOR_SENSOR,

    /**
     * Range finder
     * ex. Ultrasonic sensor for ev3
     */
    RANGEFINDER,
    SOUND_SENSOR,
    REMOTECONTROL_RECEIVER
}
