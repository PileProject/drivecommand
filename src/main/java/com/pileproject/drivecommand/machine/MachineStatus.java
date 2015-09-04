package com.pileproject.drivecommand.machine;

import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.port.DevicePort;

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

    /**
     * Bind ports and device types
     * @param port
     * @param type
     * @return updated or not
     */
    public boolean bind(DevicePort port, DeviceType type) {
        boolean isUpdated = mDevices.containsKey(port);
        mDevices.put(port, type);
        return isUpdated;
    }

    public Map<DevicePort, DeviceType> getPorts() {
        return mDevices;
    }
}
