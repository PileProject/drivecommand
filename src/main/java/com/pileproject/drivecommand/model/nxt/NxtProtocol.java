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

package com.pileproject.drivecommand.model.nxt;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.model.com.ICommunicator;
import com.pileproject.drivecommand.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.pileproject.drivecommand.model.nxt.NxtConstants.BOOLEANMODE;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.BRAKE;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.DIRECT_COMMAND_NOREPLY;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.DIRECT_COMMAND_REPLY;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.GET_INPUT_VALUES;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.LIGHT_ACTIVE;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.MOTORON;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.MOTOR_RUN_STATE_RUNNING;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.PCTFULLSCALEMODE;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.REGULATED;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.REGULATION_MODE_MOTOR_SPEED;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.SET_INPUT_MODE;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.SET_OUTPUT_STATE;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.SOUND_DB;
import static com.pileproject.drivecommand.model.nxt.NxtConstants.SWITCH;

/**
 * A protocol class for Nxt.
 *
 * @see <a href="http://sourceforge.net/projects/lejos/files/lejos-NXJ/">LeJOS</a>
 */
public class NxtProtocol extends ProtocolBase {
    private static final String KEY_VALUE = "value";
    private static final String TAG = "NxtProtocol";
    private static final int MAX_RES_LENGTH = 66;
    private Map<Integer, Byte> mPortTypes;

    public NxtProtocol(ICommunicator comm) {
        super(comm);
    }

    @Override
    public void open() throws IOException {
        mCommunicator.open();
        mPortTypes = new HashMap<>();
    }

    @Override
    public void close() {
        mCommunicator.close();
        mPortTypes = null;
    }

    @Override
    public Map<String, Object> exec(int port, CommandBase cmd) {
        Map<String, Object> res = new HashMap<>();
        CommandType type = cmd.getCommandType();
        switch (type) {
            case GET_COLOR_ILLUMINANCE: {
                throw new UnsupportedOperationException("GET COLOR ILLUMINANCE Operation hasn't been implemented yet");
            }
            case GET_COLOR_RGB: {
                throw new UnsupportedOperationException("GET COLOR RGB Operation hasn't been implemented yet");
            }
            case GET_GYRO_ANGLE: {
                throw new UnsupportedOperationException("GET GYRO ANGLE Operation hasn't been implemented yet");
            }
            case GET_GYRO_RATE: {
                throw new UnsupportedOperationException("GET GYRO RATE Operation hasn't been implemented yet");
            }
            case GET_LINE_VALUE: {
                setInputMode(port, LIGHT_ACTIVE, PCTFULLSCALEMODE);
                InputValues values = getInputValues(port);
                res.put(KEY_VALUE, values.scaledValue / 10);
                break;
            }
            case GET_RANGEFINDER_DIST: {
                throw new UnsupportedOperationException("GET RANGEFINDER DIST Operation hasn't been implemented yet");
            }
            case GET_REMOTECONTROLLER_BUTTON: {
                throw new UnsupportedOperationException("GET REMOTECONTROLLER BUTTON Operation hasn't been implemented yet");
            }
            case GET_REMOTECONTROLLER_DIST: {
                throw new UnsupportedOperationException("GET GET REMOTECONTROLLER DIST Operation hasn't been implemented yet");
            }
            case GET_SERVO_ANGLE: {
                throw new UnsupportedOperationException("GET SERVO ANGLE Operation hasn't been implemented yet");
            }
            case GET_SOUND_DB: {
                setInputMode(port, SOUND_DB, PCTFULLSCALEMODE);
                InputValues values = getInputValues(port);
                res.put(KEY_VALUE, values.scaledValue / 10);
                break;
            }
            case GET_TOUCH_COUNT: {
                throw new UnsupportedOperationException("GET TOUCH COUNT Operation hasn't been implemented yet");
            }
            case GET_TOUCH_TOUCHED: {
                setInputMode(port, SWITCH, BOOLEANMODE);
                InputValues values = getInputValues(port);
                res.put(KEY_VALUE, values.scaledValue < 600);
                break;
            }
            case SET_BUZZER_BEEP: {
                throw new UnsupportedOperationException("SET BUZZER BEEP Operation hasn't been implemented yet");
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
                setOutputState(port, speed, BRAKE + MOTORON + REGULATED,
                        REGULATION_MODE_MOTOR_SPEED, 0, MOTOR_RUN_STATE_RUNNING, 0);
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
     * Set the output device status.
     *
     * @param port           the port of a device (0 ~ 3)
     * @param speed          the speed of a device
     * @param mode           the mode of the device (ex. MOTORON, BRAKE, and/or
     *                       REGULATED) This field is a bit field
     * @param regulationMode see {@link NxtConstants}
     * @param turnRatio      use this parameter to move more than two motor
     * @param runState       see {@link NxtConstants}
     * @param tachoLimit     the number of degrees to rotate before stopping
     */
    private void setOutputState(int port, int speed, int mode,
                                int regulationMode, int turnRatio, int runState, int tachoLimit) {
        byte[] request = {
                DIRECT_COMMAND_NOREPLY,
                SET_OUTPUT_STATE,
                (byte) port,
                (byte) speed,
                (byte) mode,
                (byte) regulationMode,
                (byte) turnRatio,
                (byte) runState,
                (byte) tachoLimit,
                (byte) (tachoLimit >>> 8),
                (byte) (tachoLimit >>> 16),
                (byte) (tachoLimit >>> 24)
        };
        // Send request
        sendData(request);
    }

    /**
     * A small helper to send data.
     * This method calculates the size of the data
     * and append it to the data.
     *
     * @param request a request to be sent to a machine
     */
    private void sendData(byte[] request) {
        // Calculate the size of request and append them
        byte[] data = new byte[request.length + 2];
        data[0] = (byte) request.length;
        data[1] = (byte) (request.length >> 8);
        System.arraycopy(request, 0, data, 2, request.length);

        // Send request
        mCommunicator.write(data);
    }

    private InputValues getInputValues(int port) {
        byte[] request = {
                DIRECT_COMMAND_REPLY,
                GET_INPUT_VALUES,
                (byte) port
        };
        sendData(request);
        byte[] reply = mCommunicator.read(MAX_RES_LENGTH);
        InputValues inputValues = new InputValues();
        inputValues.inputPort = reply[3];
        // 0 is false, 1 is true
        inputValues.valid = (reply[4] != 0);
        // 0 is false, 1 is true
        inputValues.isCalibrated = (reply[5] == 0);
        inputValues.sensorType = reply[6];
        inputValues.sensorMode = reply[7];
        inputValues.rawADValue = (short) ((0xFF & reply[8]) | ((0xFF & reply[9]) << 8));
        inputValues.normalizedADValue = (short) ((0xFF & reply[10]) | ((0xFF & reply[11]) << 8));
        inputValues.scaledValue = (short) ((0xFF & reply[12]) | ((0xFF & reply[13]) << 8));
        inputValues.calibratedValue = (short) ((0xFF & reply[14]) | ((0xFF & reply[15]) << 8));

        return inputValues;
    }

    /**
     * Tells an NXT what type of sensor you are
     * using and the mode to operate in.
     *
     * @param port       the port of a device (0 ~ 3)
     * @param sensorType see {@link NxtConstants}
     * @param sensorMode see {@link NxtConstants}
     */
    public void setInputMode(int port, int sensorType, int sensorMode) {
        // If the port is not initialized, set the mode
        if (!mPortTypes.containsKey(port) || sensorType != mPortTypes.get(port)) {
            // Save the setting to a map and set the mode of sensor
            mPortTypes.put(port, (byte) sensorType);
            Log.d(TAG, "port(" + port + ") is initailized to " + sensorType);

            byte[] request = {
                    DIRECT_COMMAND_NOREPLY,
                    SET_INPUT_MODE,
                    (byte) port,
                    (byte) sensorType,
                    (byte) sensorMode
            };

            sendData(request);
            getInputValues(port); // Skip the first value (it may be invalid)

            // sound sensor needs more initializing
            // time based on our experiments
            if (sensorType == SOUND_DB) waitMillSeconds(250);
        }
    }

    /**
     * A helper method to wait for specified milli seconds.
     *
     * @param milliseconds time to wait in millisecond
     */
    private void waitMillSeconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean apply() {
        // this protocol does not support transactions
        throw new UnsupportedOperationException("Nxt Protocol does not support transactions");
    }

    @Override
    public byte[] load(int key) {
        throw new UnsupportedOperationException("Nxt Protocol hasn't supported key-value store yet");
    }

    @Override
    public boolean store(int key, byte[] data) {
        throw new UnsupportedOperationException("Nxt Protocol hasn't supported key-value store yet");
    }
}

