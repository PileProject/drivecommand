package com.pileproject.drivecommand.model.nxt;

import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.input.SoundSensor;
import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.input.simulation.SimulatedLineSensor;
import com.pileproject.drivecommand.machine.device.input.simulation.SimulatedSoundSensor;
import com.pileproject.drivecommand.machine.device.input.simulation.SimulatedTouchSensor;
import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.output.simulation.SimulatedMotor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.machine.device.port.OutputPort;

public class NxtMachineSimulator extends NxtMachine {

    public NxtMachineSimulator() {
        super(new NxtNullProtocol());
    }

    @Override
    public Motor createMotor(OutputPort port) {
        checkOutputPortCompatibility(port);

        mStatus.bind(port, DeviceType.MOTOR);
        return new SimulatedMotor(port, mProtocol);
    }

    @Override
    public LineSensor createLineSensor(InputPort port) {
        checkInputPortCompatibility(port);

        mStatus.bind(port, DeviceType.LINE_SENSOR);
        return new SimulatedLineSensor(port, mProtocol);
    }

    @Override
    public TouchSensor createTouchSensor(InputPort port) {
        checkInputPortCompatibility(port);

        mStatus.bind(port, DeviceType.TOUCH_SENSOR);
        return new SimulatedTouchSensor(port, mProtocol);
    }

    @Override
    public SoundSensor createSoundSensor(InputPort port) {
        checkInputPortCompatibility(port);

        mStatus.bind(port, DeviceType.SOUND_SENSOR);
        return new SimulatedSoundSensor(port, mProtocol);
    }
}
