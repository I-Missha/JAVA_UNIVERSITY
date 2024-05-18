package nsu.oop.task2.command;

import nsu.oop.task2.exceptions.ArgumentsException;
import nsu.oop.task2.exceptions.CommandExecutionException;
import nsu.oop.task2.exceptions.DataException;
import nsu.oop.task2.util.Data;

public class CommandPow extends Command{

    public CommandPow() {
        super(1);
    }

    @Override
    public void executeCommand(Data data, String[] argsVec) throws DataException, ArgumentsException, CommandExecutionException {
        isArgumentsCorrect(data, argsVec);
        double i  = data.pop();
        data.push(Math.pow(i, Double.parseDouble(argsVec[0])));
    }
}
