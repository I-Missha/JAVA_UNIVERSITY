package nsu.oop.task2.command;

import nsu.oop.task2.errors.CommandCreationException;
import nsu.oop.task2.errors.FileException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CommandsContainer {
    HashMap<String, Class<?>> commandsMap;
    final private String configFilePath = "/config.txt";

    public CommandsContainer() {
        commandsMap = new HashMap<>();
    }

    public void initial() throws FileException, CommandCreationException {
        InputStream stream = CommandsContainer.class.getResourceAsStream(configFilePath);
        if (stream == null) {
            throw new FileException("can't open file with path: " + configFilePath);
        }
        Properties properties = new Properties();
        try {
            properties.load(stream);
            for (Object it: properties.keySet()) {
                commandsMap.put(it.toString(), Class.forName(properties.get(it).toString()));
            }
        } catch (ClassNotFoundException e) {
            throw new CommandCreationException("can't find class ");
        } catch (IOException e) {
            throw new FileException("cant read from the file, file path: " + configFilePath);
        }
    }

    public HashMap<String, Class<?>> getCommandsAsHashMap() {
        return commandsMap;
    }
}
