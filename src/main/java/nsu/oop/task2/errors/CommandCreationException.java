package nsu.oop.task2.errors;

import nsu.oop.task2.command.Command;

public class CommandCreationException extends Throwable{
    public CommandCreationException(String msg) {
        super(msg);
    }
}
