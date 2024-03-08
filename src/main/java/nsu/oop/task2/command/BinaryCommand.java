package nsu.oop.task2.command;

import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.errors.CommandExecutionException;
import nsu.oop.task2.errors.DataException;
import nsu.oop.task2.util.Data;

public class BinaryCommand extends Command {
    protected double firstOperand;
    protected double secondOperand;
    public BinaryCommand(){
        super(0);
    }

    @Override
    public void executeCommand(Data data, String[] argsString) throws DataException, CommandExecutionException, ArgumentsException {
        try {
            secondOperand = data.pop();
        } catch(DataException exception) {
            throw exception;
        }
        try {
            firstOperand = data.pop();
        } catch(DataException exception) {
            throw exception;
        }
        isArgumentsCorrect(data, argsString);
    }
}
