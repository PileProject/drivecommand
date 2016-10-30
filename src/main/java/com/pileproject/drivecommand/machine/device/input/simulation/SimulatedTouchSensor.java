package com.pileproject.drivecommand.machine.device.input.simulation;

import com.pileproject.drivecommand.machine.device.input.TouchSensor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

public class SimulatedTouchSensor extends TouchSensor {

    private boolean isTouched;

    private int touchedCount;

    public SimulatedTouchSensor(InputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    @Override
    public boolean isTouched() {
        return isTouched;
    }

    @Override
    public int getTouchedCount() {
        return touchedCount;
    }

    public void setTouched(boolean isTouched) {
        this.isTouched = isTouched;
    }

    public void setTouchedCount(int touchedCount) {
        this.touchedCount = touchedCount;
    }

    public void incrementTouchedCount() {
        this.touchedCount ++;
    }
}
