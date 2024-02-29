package org.nsu.oop.task2.command;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.IllegalFormatWidthException;
import java.util.Scanner;

public class CommandFactory {
    final private HashMap<String, Class<?>> commandsMap;
    public CommandFactory() throws Exception {
        try {
            CommandsContainer commandsContainer = new CommandsContainer();
            commandsMap = commandsContainer.getCommandsAsHashMap();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    Object createClass(String commandName) throws Exception {
        try {
            return commandsMap.get(commandName).getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalFormatWidthException |
                 InvocationTargetException e) {
            throw new Exception(e.getMessage());
        }
    }
}

