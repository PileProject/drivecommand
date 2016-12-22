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
package com.pileproject.drivecommand.model.ev3;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.model.com.ICommunicator;
import com.pileproject.drivecommand.util.Log;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.pileproject.drivecommand.model.ev3.Ev3Constants.COL_REFLECT;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.COL_RGB;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.DIRECT_COMMAND_NOREPLY;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.DIRECT_COMMAND_REPLY;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.EV3_COLOR;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.EV3_GYRO;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.EV3_IR;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.EV3_TOUCH;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.EV3_ULTRASONIC;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.GYRO_ANGLE;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.GYRO_RATE;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.INPUT_DEVICE;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.IR_REMOTE;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.IR_SEEK;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.LAYER_MASTER;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.LIGHT_REFLECT;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.L_MOTOR;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.L_MOTOR_DEGREE;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.NXT_LIGHT;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.NXT_SOUND;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.OUTPUT_POWER;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.OUTPUT_START;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.READY_PCT;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.READY_SI;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.SOUND_CONTROL;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.SOUND_DB;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.SOUND_TONE;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.TOUCH_BUMPS;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.TOUCH_TOUCH;
import static com.pileproject.drivecommand.model.ev3.Ev3Constants.US_CM;

/**
 * A protocol class for Ev3.
 */
public class Ev3Protocol extends ProtocolBase {
    private static final String KEY_VALUE = "value";
    private static final String TAG = "Ev3Protocol";
    private static final byte OUTPUT_PORT_OFFSET = 0x10;

    public Ev3Protocol(ICommunicator comm) {
        super(comm);
    }

    @Override
    public void open() throws IOException {
        mCommunicator.open();
    }

    @Override
    public void close() {
        mCommunicator.close();
    }

    @Override
    public Map<String, Object> exec(int port, CommandBase cmd) {
        Map<String, Object> res = new HashMap<>();
        CommandType type = cmd.getCommandType();
        switch (type) {
            case GET_COLOR_ILLUMINANCE: {
                // TODO: EV3 also can use NXT's color sensor (NXT_COLOR).
                // I should switch the types (EV3_COLOR/NXT_COLOR) based on the device info.
                short[] values = getPercentValue(port, EV3_COLOR, COL_REFLECT, 1);
                res.put(KEY_VALUE, (int) values[0]);
                break;
            }
            case GET_COLOR_RGB: {
                // TODO: EV3 also can use NXT's color sensor (NXT_COLOR).
                // I should switch the types (EV3_COLOR/NXT_COLOR) based on the device info.
                // TODO: Reading value is failed because ev3 returns
                // DIRECT_COMMAND_FAILED.
                // So the byte code is something wrong.
                float[] values = getSiValue(port, EV3_COLOR, COL_RGB, 3);
                res.put(KEY_VALUE, values);
                break;
            }
            case GET_GYRO_ANGLE: {
                float[] value = getSiValue(port, EV3_GYRO, GYRO_ANGLE, 1);
                res.put(KEY_VALUE, (int) value[0]);
                break;
            }
            case GET_GYRO_RATE: {
                float[] value = getSiValue(port, EV3_GYRO, GYRO_RATE, 1);
                res.put(KEY_VALUE, (int) value[0]);
                break;
            }
            case GET_LINE_VALUE: {
                // TODO: NOT TESTED
                short[] values = getPercentValue(port, NXT_LIGHT, LIGHT_REFLECT, 1);
                res.put(KEY_VALUE, (int) values[0]);
                break;
            }
            case GET_RANGEFINDER_DIST: {
                float[] values = getSiValue(port, EV3_ULTRASONIC, US_CM, 1);
                res.put(KEY_VALUE, (int) values[0]);
                break;
            }
            case GET_REMOTECONTROLLER_BUTTON: {
                // TODO: NOT TESTED
                float[] values = getSiValue(port, EV3_IR, IR_REMOTE, 1);
                res.put(KEY_VALUE, (int) values[0]);
                break;
            }
            case GET_REMOTECONTROLLER_DIST: {
                // TODO: NOT TESTED
                float[] values = getSiValue(port, EV3_IR, IR_SEEK, 1);
                res.put(KEY_VALUE, (int) values[0]);
                break;
            }
            case GET_SERVO_ANGLE: {
                float[] values = getSiValue((OUTPUT_PORT_OFFSET | port), L_MOTOR, L_MOTOR_DEGREE, 1);
                res.put(KEY_VALUE, (int) values[0]);
                break;
            }
            case GET_SOUND_DB: {
                float[] values = getSiValue(port, NXT_SOUND, SOUND_DB, 1);
                res.put(KEY_VALUE, (int) values[0]);
                break;
            }
            case GET_TOUCH_COUNT: {
                float[] values = getSiValue(port, EV3_TOUCH, TOUCH_BUMPS, 1);
                res.put(KEY_VALUE, (int) values[0]);
                break;
            }
            case GET_TOUCH_TOUCHED: {
                float[] values = getSiValue(port, EV3_TOUCH, TOUCH_TOUCH, 1);
                res.put(KEY_VALUE, ((int) values[0]) == 1);
                break;
            }
            case SET_BUZZER_BEEP: {
                // TODO: maybe OK.
                // Indeed, it beeps but I'm not sure that the arguments (frep =
                // 600, duration = 200) are okay.
                soundTone(50, 600, 200);
                break;
            }
            case SET_BUZZER_OFF: {
                throw new UnsupportedOperationException("SET BUZZER OFF Operation hasn't been implemented yet");
            }
            case SET_BUZZER_ON: {
                throw new UnsupportedOperationException("SET BUZZER ON Operation hasn't been implemented yet");
            }
            case SET_LED_OFF: {
                throw new UnsupportedOperationException("SET LED OFF Operation hasn't been implemented yet");
            }
            case SET_LED_ON: {
                throw new UnsupportedOperationException("SET LED ON Operation hasn't been implemented yet");
            }
            case SET_MOTOR_SPEED: {
                Map<String, Object> args = cmd.getArgs();
                int speed = (Integer) args.get("speed");
                setOutputState(port, speed);
                break;
            }
            case SET_SERVO_ANGLE: {
                throw new UnsupportedOperationException("SET SERVO ANGLE Operation hasn't been implemented yet");
            }
            default: {
                throw new UnsupportedOperationException("This Operation hasn't been implemented yet");
            }
        }
        return res;
    }

    /**
     * Get SI unit value.
     *
     * @param port   the port of a device
     * @param type   the device type
     * @param mode   the mode of the device
     * @param nvalue the number of the response value
     * @return returned value in SI unit
     */
    private float[] getSiValue(int port, int type, int mode, int nvalue) {
        ByteCodeFormatter byteCode = new ByteCodeFormatter();
        byteCode.addOpCode(DIRECT_COMMAND_REPLY);

        // TODO: NOT TESTED when nvalue is more than 2
        byteCode.addGlobalAndLocalBufferSize(4 * nvalue, 0);
        byteCode.addOpCode(INPUT_DEVICE);
        byteCode.addOpCode(READY_SI);
        byteCode.addParameter(LAYER_MASTER);
        byteCode.addParameter((byte) port);
        byteCode.addParameter((byte) type);
        byteCode.addParameter((byte) mode);
        byteCode.addParameter((byte) nvalue); // number of values
        byteCode.addGlobalIndex((byte) 0x00);

        // Send message
        mCommunicator.write(byteCode.byteArray());

        byte[] reply = readData();

        // Check the validity of the response
        // boolean valid = (reply[2] == DIRECT_COMMAND_SUCCESS);

        // Read the SI unit value in float type
        float[] result = new float[nvalue];
        for (int i = 0; i < nvalue; i++) {
            byte[] data = Arrays.copyOfRange(reply, 3 + 4 * i, 7 + 4 * i);
            result[i] = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getFloat();
        }
        return result;
    }

    /**
     * Get percent value.
     *
     * @param port   the port of a device
     * @param type   the device type
     * @param mode   the mode of the device
     * @param nvalue the number of the response value
     * @return returned value in percent
     */
    private short[] getPercentValue(int port, int type, int mode, int nvalue) {
        ByteCodeFormatter byteCode = new ByteCodeFormatter();
        byteCode.addOpCode(DIRECT_COMMAND_REPLY);

        // TODO: NOT TESTED when nvalue is more than 2
        byteCode.addGlobalAndLocalBufferSize(1 * nvalue, 0);
        byteCode.addOpCode(INPUT_DEVICE);
        byteCode.addOpCode(READY_PCT);
        byteCode.addParameter(LAYER_MASTER);
        byteCode.addParameter((byte) port);
        byteCode.addParameter((byte) type);
        byteCode.addParameter((byte) mode);
        byteCode.addParameter((byte) nvalue); // number of values
        byteCode.addGlobalIndex((byte) 0x00);

        // Send message
        mCommunicator.write(byteCode.byteArray());

        byte[] reply = readData();

        // Check the validity of the response
        // boolean valid = (reply[2] == DIRECT_COMMAND_SUCCESS);

        // Read the percent value in short type
        short[] result = new short[nvalue];
        for (int i = 0; i < nvalue; i++) {
            result[i] = (short) reply[3 + i];
        }
        return result;
    }

    /**
     * Convert a output port to a byte code port.
     *
     * @param port port to be converted
     * @return a byte code which expresses a output port
     */
    private byte toByteCodePort(int port) {
        if (port >= 0x00 && port <= 0x03) return (byte) (0x01 << port);
        else return 0x00; // this will not happen
    }

    /**
     * Set output device condition.
     *
     * @param port  the port of a device
     * @param speed the speed of a device
     */
    private void setOutputState(int port, int speed) {
        ByteCodeFormatter byteCode = new ByteCodeFormatter();

        // Convert port number
        byte byteCodePort = toByteCodePort(port);

        byteCode.addOpCode(DIRECT_COMMAND_NOREPLY);
        byteCode.addGlobalAndLocalBufferSize(0, 0);

        byteCode.addOpCode(OUTPUT_POWER);
        byteCode.addParameter(LAYER_MASTER);
        byteCode.addParameter(byteCodePort);
        byteCode.addParameter((byte) speed);

        byteCode.addOpCode(OUTPUT_START);
        byteCode.addParameter(LAYER_MASTER);
        byteCode.addParameter(byteCodePort);

        // Send message
        mCommunicator.write(byteCode.byteArray());
    }

    /**
     * Make a sound.
     *
     * @param volume   the volume of a sound (0 ~ 100 [%])
     * @param freq     the frequency [Hz]
     * @param duration the duration of a sound [msec]
     */
    private void soundTone(int volume, int freq, int duration) {
        ByteCodeFormatter byteCode = new ByteCodeFormatter();

        byteCode.addOpCode(DIRECT_COMMAND_NOREPLY);
        byteCode.addGlobalAndLocalBufferSize(0, 0);

        byteCode.addOpCode(SOUND_CONTROL);
        byteCode.addOpCode(SOUND_TONE);
        byteCode.addParameter((byte) volume);
        byteCode.addParameter((short) freq);
        byteCode.addParameter((short) duration);

        // Send message
        mCommunicator.write(byteCode.byteArray());
    }

    /**
     * Read data from a machine.
     *
     * @return returned results
     */
    private byte[] readData() {
        // Calculate the size of response by reading 2 bytes.
        byte[] header = mCommunicator.read(2);
        int numBytes = ((header[1] & 0x00ff) << 8) | (header[0] & 0x00ff);

        // Get result
        byte[] result = mCommunicator.read(numBytes);
        Log.d(TAG, "read: " + result.length + " bytes");

        return result;
    }

    @Override
    public boolean apply() {
        // this protocol does not support transactions.
        throw new UnsupportedOperationException("Ev3 Protocol does not support transactions");
    }

    @Override
    public byte[] load(int key) {
        throw new UnsupportedOperationException("Ev3 Protocol hasn't supported key-value store yet");
    }

    @Override
    public boolean store(int key, byte[] data) {
        throw new UnsupportedOperationException("Ev3 Protocol hasn't supported key-value store yet");
    }
}
