package com.pile_drive.drivecommand.machine;

import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.command.ICommand;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.IProtocol;

public class LineSensor implements IDevice {
	int port;
	IProtocol protocol;
	
	public LineSensor(int port, IProtocol protocol) {
		this.port = port;
		this.protocol = protocol;
	}
	int getSensorValue() {
		CommandFactory cmdfactory = new CommandFactory();
		ICommand cmd = cmdfactory.createCommand(CommandType.GET_LS_VALUE, null);
		HashMap<String, Object> value = protocol.exec(port, cmd);
		return (Integer)value.get("value");
	}
}
