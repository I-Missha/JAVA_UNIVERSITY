package org.nsu.oop.task2.command;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class CommandsContainer {
    HashMap<String, Class<?>> commandsMap;
    final private String configFilePath = "/config.txt";

    public CommandsContainer() throws Exception {
        commandsMap = new HashMap<>();
        InputStream stream = this.getClass().getResourceAsStream(configFilePath);

        if (stream == null) {
//            throw new ConfigException();
            throw new Exception();
        }

        Scanner scanner = new Scanner(stream);

        while(scanner.hasNext()) {
            // str have to contain name of class and object of class
            String[] str = scanner.nextLine().split("\\s*=\\s*");

            if (str.length < 2) {
                throw new Exception();
            }

            try {
                commandsMap.put(str[0], Class.forName(str[1]));
            } catch (ClassNotFoundException e) {
                throw new Exception();
            }
        }
    }

    public HashMap<String, Class<?>> getCommandsAsHashMap() throws Exception {
        if (commandsMap == null) {
            throw new Exception();
        }

        return commandsMap;
    }
}
