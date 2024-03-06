package org.nsu.oop.task2.command;

import org.nsu.oop.task2.util.Data;

import java.util.concurrent.ExecutionException;

public class CommandPlus extends Command{


    public CommandPlus(int numOfArguments) {
        super(numOfArguments);
    }

    @Override
    public void executeCommand(Data data, String[] argsString) throws Exception {
        double operand1;
        double operand2;
//       ошибку надо обрабатывать
        try {
            operand2 = data.pop();
            operand1 = data.pop();
        } catch(Exception e) {
            throw new Exception();
        }
        data.push(operand1 + operand2);
    }
}
