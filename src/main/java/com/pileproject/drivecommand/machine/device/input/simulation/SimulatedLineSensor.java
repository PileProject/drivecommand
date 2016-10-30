package com.pileproject.drivecommand.machine.device.input.simulation;

import com.pileproject.drivecommand.machine.device.input.LineSensor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

public class SimulatedLineSensor extends LineSensor {

    private int sensorValue;

    public SimulatedLineSensor(InputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    @Override
    public int getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(int sensorValue) {
        this.sensorValue = sensorValue;
    }
}
