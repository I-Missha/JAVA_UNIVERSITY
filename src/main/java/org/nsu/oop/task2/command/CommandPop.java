package org.nsu.oop.task2.command;

import org.nsu.oop.task2.util.Data;

import java.util.Vector;

public class CommandPop extends Command{
    public CommandPop() {
        super(0);
    }

    @Override
    public void executeCommand(Data data, Vector<Object> argsVec) throws Exception {
        if (isNumOfArgumentsCorrect(argsVec.size())) {
            throw new Exception();
        }
        data.pop();
    }

}
