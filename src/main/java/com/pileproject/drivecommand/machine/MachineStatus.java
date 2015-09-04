package com.pileproject.drivecommand.machine;

import com.pileproject.drivecommand.machine.device.port.DevicePort;
import com.pileproject.drivecommand.machine.device.DeviceType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tatsuya on 15/09/03.
 */
public class MachineStatus {
    private Map<DevicePort, DeviceType> mDevices;

    public MachineStatus() {
        mDevices = new HashMap<>();
    }

    public MachineStatus(Map<DevicePort, DeviceType> devices) {
        this.mDevices = devices;
    }

    public boolean bind(DevicePort port, DeviceType type) {
        if (mDevices.containsKey(port)) return false;
        mDevices.put(port, type);
        return true;
    }

    public Map<DevicePort, DeviceType> getPorts() {
        return mDevices;
    }

}
