package com.pileproject.drivecommand.machine.device.output;


import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.machine.device.DeviceBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.port.OutputPort;
import com.pileproject.drivecommand.model.CommandType;
import com.pileproject.drivecommand.model.ProtocolBase;

public class Led extends DeviceBase {
    
    public Led(OutputPort port, ProtocolBase protocol) {
        super(port, protocol);
    }
    
    /**
     * Turn on the LED if it is off
     */
    public void turnOn() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.SET_LED_ON, null);
        exec(cmd);
    }
    
    /**
     * Turn off the LED if it is on
     */
    public void turnOff() {
        CommandBase cmd = CommandFactory.createCommand(CommandType.SET_LED_OFF, null);
        exec(cmd);
    }
    
    @Override
    public DeviceType getDeviceType() {
        return DeviceType.LED;
    }
    
}
