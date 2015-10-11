package com.pileproject.drivecommand.command;

import com.pileproject.drivecommand.model.CommandType;

import java.util.Map;

public class CommandFactory {

    /**
     * Create command
     *
     * @param type
     * @param args
     * @return command
     */
    public static CommandBase createCommand(CommandType type, Map<String, Object> args) {
        return new Command(type, args);
    }
}
