package org.nsu.oop.task2.command;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.IllegalFormatWidthException;
import java.util.Scanner;

public class CommandFactory {
    final private HashMap<String, Class<?>> commandsMap;
    final String config = "Config.txt";
    public CommandFactory() {

        InputStream stream = CommandFactory.class.getResourceAsStream(config);

//        if (stream == null) {
//            throw new ConfigException();
//        }

        commandsMap = new HashMap<>();
        Scanner scanner = new Scanner(stream);

        while(scanner.hasNext()) {
            // str have to contain name of class and object of class
            String str[] = scanner.nextLine().split("\\s*=\\s*");

//            if (str.length < 2) {
//                throw new ConfigException();
//            }

            try {
                commandsMap.put(str[0], Class.forName(str[1]));
            } catch (ClassNotFoundException e) {
//                throw new ConnectException();
            }
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

