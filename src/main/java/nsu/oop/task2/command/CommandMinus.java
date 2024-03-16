package nsu.oop.task2.command;

import nsu.oop.task2.exceptions.ArgumentsException;
import nsu.oop.task2.exceptions.CommandExecutionException;
import nsu.oop.task2.exceptions.DataException;
import nsu.oop.task2.util.Data;

public class CommandMinus extends BinaryCommand{
    public CommandMinus(){
        super();
    }

    @Override
    public void executeCommand(Data data, String[] argsString) throws DataException, CommandExecutionException, ArgumentsException {
        super.executeCommand(data, argsString);
        data.push(firstOperand - secondOperand);
    }
}
