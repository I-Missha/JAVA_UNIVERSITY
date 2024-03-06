package org.nsu.oop.task2.command;

import org.nsu.oop.task2.util.Data;

import java.util.Vector;

public class CommandPush extends Command{

    public CommandPush() {
        super(1);
    }

    @Override
    public void executeCommand(Data data, String[] argsString) throws Exception{
        if (isNumOfArgumentsCorrect(argsString.length)) {
            throw new Exception();
        }
        data.push( Double.parseDouble(argsString[0]));
    }
}
