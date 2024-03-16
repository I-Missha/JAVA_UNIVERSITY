package nsu.oop.task2.command;

import nsu.oop.task2.exceptions.DataException;
import nsu.oop.task2.util.Data;

import static java.lang.Math.sqrt;

public class CommandSquareRoot extends Command{
    public CommandSquareRoot() {
        super(0);
    }
    @Override
    public void executeCommand(Data data, String[] argsString) throws DataException {
        double operand;
        try {
            operand = data.pop();
        } catch(DataException exception) {
            throw exception;
        }
        data.push(sqrt(operand));
    }
}
