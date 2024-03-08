package nsu.oop.task2.command;

import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.errors.CommandExecutionException;
import nsu.oop.task2.errors.DataException;
import nsu.oop.task2.util.Data;

public class CommandDivide extends BinaryCommand{
    public CommandDivide(){
        super();
    }

    @Override
    public void executeCommand(Data data, String[] argsString) throws DataException, CommandExecutionException, ArgumentsException {
        super.executeCommand(data, argsString);
        if (secondOperand == 0) {
            data.push(firstOperand);
            data.push(secondOperand);
            throw new CommandExecutionException("cant divide by zero");
        }
        data.push(firstOperand / secondOperand);
    }
}
