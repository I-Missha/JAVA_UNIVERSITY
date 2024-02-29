package org.nsu.oop.task2.command;

import org.nsu.oop.task2.util.Data;

import java.util.Vector;

public class CommandPush extends Command{

    public CommandPush() {
        super(1);
    }

    @Override
    public void executeCommand(Data data, Vector<Object> argsVec) throws Exception{
        if (isNumOfArgumentsCorrect(argsVec.size())) {
            throw new Exception();
        }
        data.push( (double) argsVec.getFirst());
    }
}
