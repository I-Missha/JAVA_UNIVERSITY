package org.nsu.oop.task2.command;

import org.nsu.oop.task2.util.Data;

import java.util.Vector;

public abstract class Command {
    int numOfArguments;
    public Command(int numOfArguments) {
        this.numOfArguments = numOfArguments;
    }

    protected boolean isNumOfArgumentsCorrect(int num) {
        return num == numOfArguments;
    }

    public void executeCommand(Data data, String[] argsVec) throws Exception {

    };

    public abstract void executeCommand(Data data, String[] argsString) throws Exception;

}

//command ->