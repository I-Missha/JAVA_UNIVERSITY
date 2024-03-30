package nsu.oop.task2.command;

import nsu.oop.task2.exceptions.ArgumentsException;
import nsu.oop.task2.exceptions.CommandExecutionException;
import nsu.oop.task2.exceptions.DataException;
import nsu.oop.task2.util.Data;

public class CommandPlus extends BinaryCommand{
    public CommandPlus() {
        super();
    }

    @Override
    public void executeCommand(Data data, String[] argsString) throws DataException, ArgumentsException, CommandExecutionException {
        super.executeCommand(data, argsString);
        data.push(firstOperand + secondOperand);
    }
}
