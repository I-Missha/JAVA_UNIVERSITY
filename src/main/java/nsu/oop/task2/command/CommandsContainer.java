package nsu.oop.task2.command;

import nsu.oop.task2.errors.CommandCreationException;
import nsu.oop.task2.errors.FileException;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class CommandsContainer {
    HashMap<String, Class<?>> commandsMap;
    final private String configFilePath = "/config.txt";

    public CommandsContainer() throws FileException, CommandCreationException {
        commandsMap = new HashMap<>();
        InputStream stream = CommandsContainer.class.getResourceAsStream(configFilePath);
        if (stream == null) {
            throw new FileException("can't open file with path: " + configFilePath);
        }
        Scanner scanner = new Scanner(stream);

        while(scanner.hasNext()) {
            // str have to contain name of class and object of class
            String[] str = scanner.nextLine().split("\\s*=\\s*");

            try {
                commandsMap.put(str[0], Class.forName(str[1]));
            } catch (ClassNotFoundException e) {
                throw new CommandCreationException("can't find class with the name: " + str[1]);
            }
        }
    }

    public HashMap<String, Class<?>> getCommandsAsHashMap() {
        return commandsMap;
    }
}
