package com.pileproject.drivecommand.machine.device.input.simulation;

import com.pileproject.drivecommand.machine.device.input.SoundSensor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

public class SimulatedSoundSensor extends SoundSensor {

    private int dB;

    public SimulatedSoundSensor(InputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    @Override
    public int getDb() {
        return dB;
    }

    public void setDb(int db) {
        this.dB = db;
    }
}
