package com.pileproject.drivecommand.model;

import com.pileproject.drivecommand.machine.device.DeviceType;

public enum CommandType {
    SET_LED_ON {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.LED;
        }
    },
    SET_LED_OFF {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.LED;
        }
    },
    SET_MOTOR_SPEED {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.MOTOR;
        }
    },
    SET_SERVO_ANGLE {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.SERVOMOTOR;
        }
    },
    GET_SERVO_ANGLE {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.SERVOMOTOR;
        }
    },
    SET_BUZZER_ON {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.BUZZER;
        }
    },
    SET_BUZZER_OFF {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.BUZZER;
        }
    },
    SET_BUZZER_BEEP {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.BUZZER;
        }
    },
    GET_LINE_VALUE {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.LINE_SENSOR;
        }
    },
    GET_GYRO_ANGLE {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.GYRO_SENSOR;
        }
    },
    GET_GYRO_RATE {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.GYRO_SENSOR;
        }
    },
    GET_TOUCH_TOUCHED {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.TOUCH_SENSOR;
        }
    },
    GET_TOUCH_COUNT {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.TOUCH_SENSOR;
        }
    },
    GET_COLOR_RGB {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.COLOR_SENSOR;
        }
    },
    GET_COLOR_ILLUMINANCE {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.COLOR_SENSOR;
        }
    },
    GET_RANGEFINDER_DIST {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.RANGEFINDER;
        }
    },
    GET_REMOTECONTROLLER_BUTTON {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.REMOTECONTROL_RECEIVER;
        }
    },
    GET_REMOTECONTROLLER_DIST {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.REMOTECONTROL_RECEIVER;
        }
    },
    GET_SOUND_DB {
        @Override
        public DeviceType getDeviceType() {
            return DeviceType.SOUND_SENSOR;
        }
    };

    public abstract DeviceType getDeviceType();
}
