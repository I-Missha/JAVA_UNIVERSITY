package nsu.oop.task2.command;

import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.util.Data;

public class CommandDefine extends Command{
    public CommandDefine() {
        super(2);
    }

    @Override
    protected void isArgumentsCorrect(Data data, String[] args) throws ArgumentsException {
        super.isArgumentsCorrect(data, args);
        if (isNumeric(args[0]) || !isNumeric(args[1])) {
            throw new ArgumentsException("illegal arguments");
        }
    }

    @Override
    public void executeCommand(Data data, String[] argsString) throws ArgumentsException {
        isArgumentsCorrect(data, argsString);
        data.setVar(argsString[0], Double.parseDouble(argsString[1]));
    }
}
