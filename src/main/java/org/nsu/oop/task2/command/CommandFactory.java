package org.nsu.oop.task2.command;

import java.util.HashMap;

public class CommandFactory {
    final private HashMap<String, Class<Command>> commandsMap;

    public CommandFactory() {

    }
}

