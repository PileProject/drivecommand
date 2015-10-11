package com.pileproject.drivecommand.model.ev3;

public class Ev3Constants {

    // Command Types
    public static final byte DIRECT_COMMAND_REPLY = (byte) 0x00;
    public static final byte DIRECT_COMMAND_NOREPLY = (byte) 0x80;

    public static final byte DIRECT_COMMAND_SUCCESS = (byte) 0x02;
    public static final byte DIRECT_COMMAND_FAIL = (byte) 0x04;

    // Direct Commands - SOUND
    public static final byte SOUND_CONTROL = (byte) 0x94;

    // Sub code for SOUND_CONTROL
    public static final byte SOUND_BREAK = (byte) 0x00;
    public static final byte SOUND_TONE = (byte) 0x01;
    public static final byte SOUND_PLAY = (byte) 0x02;
    public static final byte SOUND_REPEAT = (byte) 0x03;
    public static final byte SOUND_SERVICE = (byte) 0x04;

    // Direct Commands - INPUT
    public static final byte INPUT_SAMPLE = (byte) 0x97;
    public static final byte INPUT_DEVICE_LIST = (byte) 0x98;
    public static final byte INPUT_DEVICE = (byte) 0x99;
    public static final byte INPUT_READ = (byte) 0x9A;
    public static final byte INPUT_TEST = (byte) 0x9B;
    public static final byte INPUT_READY = (byte) 0x9C;
    public static final byte INPUT_READSI = (byte) 0x9D;
    public static final byte INPUT_READEXT = (byte) 0x9E;
    public static final byte INPUT_WRITE = (byte) 0x9F;

    // Direct Commands - OUTPUT
    public static final byte OUTPUT_GET_TYPE = (byte) 0xA0;
    public static final byte OUTPUT_SET_TYPE = (byte) 0xA1;
    public static final byte OUTPUT_RESET = (byte) 0xA2;
    public static final byte OUTPUT_STOP = (byte) 0xA3;
    public static final byte OUTPUT_POWER = (byte) 0xA4;
    public static final byte OUTPUT_SPEED = (byte) 0xA5;
    public static final byte OUTPUT_START = (byte) 0xA6;
    public static final byte OUTPUT_POLARITY = (byte) 0xA7;
    public static final byte OUTPUT_READ = (byte) 0xA8;
    public static final byte OUTPUT_TEST = (byte) 0xA9;
    public static final byte OUTPUT_READY = (byte) 0xAA;
    public static final byte OUTPUT_POSITION = (byte) 0xAB;
    public static final byte OUTPUT_STEP_POWER = (byte) 0xAC;
    public static final byte OUTPUT_TIME_POWER = (byte) 0xAD;
    public static final byte OUTPUT_STEP_SPEED = (byte) 0xAE;
    public static final byte OUTPUT_TIME_SPEED = (byte) 0xAF;
    public static final byte OUTPUT_STEP_SYNC = (byte) 0xB0;
    public static final byte OUTPUT_TIME_SYNC = (byte) 0xB1;
    public static final byte OUTPUT_CLR_COUNT = (byte) 0xB2;
    public static final byte OUTPUT_GET_COUNT = (byte) 0xB3;
    public static final byte OUTPUT_PRG_ST = (byte) 0xB4;

    // Sub Commands for INPUT_DEVICE
    public static final byte GET_FORMAT = (byte) 0x02;
    public static final byte CAL_MINMAX = (byte) 0x03;
    public static final byte CAL_DEFAULT = (byte) 0x04;
    public static final byte GET_TYPEMODE = (byte) 0x05;
    public static final byte GET_SYMBOL = (byte) 0x06;
    public static final byte CAL_MIN = (byte) 0x07;
    public static final byte CAL_MAX = (byte) 0x08;
    public static final byte SETUP = (byte) 0x09;
    public static final byte CLR_ALL = (byte) 0x0A;
    public static final byte GET_RAW = (byte) 0x0B;
    public static final byte GET_CONNECTION = (byte) 0x0C;
    public static final byte STOP_ALL = (byte) 0x0D;
    public static final byte GET_NAME = (byte) 0x15;
    public static final byte GET_MODENAME = (byte) 0x16;
    public static final byte SET_RAW = (byte) 0x17;
    public static final byte GET_FIGURES = (byte) 0x18;
    public static final byte GET_CHANGES = (byte) 0x19;
    public static final byte CLR_CHANGES = (byte) 0x1A;
    public static final byte READY_PCT = (byte) 0x1B;
    public static final byte READY_RAW = (byte) 0x1C;
    public static final byte READY_SI = (byte) 0x1D;
    public static final byte GET_MINMAX = (byte) 0x1E;
    public static final byte GET_BUMPS = (byte) 0x1F;

    // All motors
    public static final byte ALL_MOTORS = (byte) 0x0f;

    // Layers
    public static final byte LAYER_MASTER = (byte) 0x00;
    public static final byte LAYER_SLAVE = (byte) 0x01;

    // Motor brakes
    public static final byte COAST = (byte) 0x00;
    public static final byte BRAKE = (byte) 0x01;

    // Input Device Mode
    // Sensor Type:
    public static final byte TYPE_DEFAULT = (byte) 0x00;
    public static final byte NXT_TOUCH = (byte) 0x01;
    public static final byte NXT_LIGHT = (byte) 0x02;
    public static final byte NXT_SOUND = (byte) 0x03;
    public static final byte NXT_COLOR = (byte) 0x04;
    public static final byte NXT_ULTRASONIC = (byte) 0x05;
    public static final byte L_MOTOR = (byte) 0x07;
    public static final byte M_MOTOR = (byte) 0x08;
    public static final byte EV3_TOUCH = (byte) 0x10;
    public static final byte EV3_COLOR = (byte) 0x1D;
    public static final byte EV3_ULTRASONIC = (byte) 0x1E;
    public static final byte EV3_GYRO = (byte) 0x20;
    public static final byte EV3_IR = (byte) 0x21;

    // Sensor Mode:
    public static final byte NOT_INITIALIZED = (byte) 0xff;
    public static final byte MODE_DEFAULT = (byte) 0x00;
    /**
     * Light
     */
    public static final byte LIGHT_REFLECT = (byte) 0x00;
    public static final byte LIGHT_AMBIENT = (byte) 0x01;
    /**
     * Sound
     */
    public static final byte SOUND_DB = (byte) 0x00;
    public static final byte SOUND_DBA = (byte) 0x01;
    /**
     * Touch
     */
    public static final byte TOUCH_TOUCH = (byte) 0x00;
    public static final byte TOUCH_BUMPS = (byte) 0x01;
    /**
     * Color
     */
    public static final byte COL_REFLECT = (byte) 0x00;
    public static final byte COL_AMBIENT = (byte) 0x01;
    public static final byte COL_COLOR = (byte) 0x02;
    public static final byte COL_RGB = (byte) 0x04;
    /**
     * Ultrasonic
     */
    public static final byte US_CM = (byte) 0x00;
    public static final byte US_INCH = (byte) 0x01;
    public static final byte US_LISTEN = (byte) 0x02;
    /**
     * Gyro
     */
    public static final byte GYRO_ANGLE = (byte) 0x00;
    public static final byte GYRO_RATE = (byte) 0x01;
    /**
     * IR
     */
    public static final byte IR_PROX = (byte) 0x00;
    public static final byte IR_SEEK = (byte) 0x01;
    public static final byte IR_REMOTE = (byte) 0x02;

    /**
     * L-Motor
     */
    public static final byte L_MOTOR_DEGREE = (byte) 0x00;
    public static final byte L_MOTOR_ROTATE = (byte) 0x01;
    public static final byte L_MOTOR_SPEED = (byte) 0x02;
    /**
     * M-Motor
     */
    public static final byte M_MOTOR_DEGREE = (byte) 0x00;
    public static final byte M_MOTOR_ROTATE = (byte) 0x01;
    public static final byte M_MOTOR_SPEED = (byte) 0x02;

}
