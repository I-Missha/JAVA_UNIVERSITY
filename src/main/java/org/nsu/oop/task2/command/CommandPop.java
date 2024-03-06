package org.nsu.oop.task2.command;

import org.nsu.oop.task2.util.Data;

import java.util.Vector;

public class CommandPop extends Command{
    public CommandPop() {
        super(0);
    }

    @Override
    public void executeCommand(Data data,String[] argsString) throws Exception {
        if (isNumOfArgumentsCorrect(argsString.length)) {
            throw new Exception();
        }
        data.pop();
    }

}
