package nsu.oop.task2.command;

import nsu.oop.task2.errors.CommandCreationException;
import nsu.oop.task2.errors.FileException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.IllegalFormatWidthException;

public class CommandFactory {
    private HashMap<String, Class<?>> commandsMap;

    public CommandFactory() {

    }

    public void initial() throws FileException, CommandCreationException {
        CommandsContainer commandsContainer = new CommandsContainer();
        commandsMap = commandsContainer.getCommandsAsHashMap();
        commandsContainer.initial();
    }

    public Command createClass(String commandName) throws RuntimeException {
        try {
            return (Command) commandsMap.get(commandName).getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalFormatWidthException |
                 InvocationTargetException e) {
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

