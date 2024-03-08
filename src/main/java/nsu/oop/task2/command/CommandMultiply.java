package nsu.oop.task2.command;

import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.errors.CommandExecutionException;
import nsu.oop.task2.errors.DataException;
import nsu.oop.task2.util.Data;

public class CommandMultiply extends BinaryCommand{
    public CommandMultiply() throws DataException {
        super();
    }

    @Override
    public void executeCommand(Data data, String[] argsString) throws DataException, CommandExecutionException, ArgumentsException {
        super.executeCommand(data, argsString);
        data.push(firstOperand * secondOperand);
    }
}
