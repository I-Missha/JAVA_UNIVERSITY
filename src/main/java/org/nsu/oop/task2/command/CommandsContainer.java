package org.nsu.oop.task2.command;

import java.util.HashMap;

public class CommandsContainer {
    HashMap<String, Class<?>> commandsMap;
    public CommandsContainer() throws ClassNotFoundException {
        try {
            commandsMap.put("POP", CommandPop.class);
            commandsMap.put("PUSH", )
        } catch (Exception e) {
            throw new ClassNotFoundException();
        }
    }
}
