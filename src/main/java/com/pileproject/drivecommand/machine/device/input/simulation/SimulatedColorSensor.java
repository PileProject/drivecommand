package com.pileproject.drivecommand.machine.device.input.simulation;

import com.pileproject.drivecommand.machine.device.input.ColorSensor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

public class SimulatedColorSensor extends ColorSensor {

    private float red;
    private float green;
    private float blue;

    private int illuminance;

    public SimulatedColorSensor(InputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }

    @Override
    public float[] getRgb() {
        return new float[]{ red, green, blue };
    }

    @Override
    public int getIlluminance() {
        return illuminance;
    }

    public void setRbg(float[] rgb) {
        red = rgb[0];
        green = rgb[1];
        blue = rgb[2];
    }

    public void setIlluminance(int illuminance) {
        this.illuminance = illuminance;
    }
}
