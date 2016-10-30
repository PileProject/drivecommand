package com.pileproject.drivecommand.machine.device.output.simulation;

import com.pileproject.drivecommand.machine.device.output.Motor;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

public class SimulatedMotor extends Motor {

    public SimulatedMotor(OutputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    @Override
    public void forward() {
        // no-op
    }

    @Override
    public void backward() {
        // no-op
    }

    @Override
    public void stop() {
        // no-op
    }
}
