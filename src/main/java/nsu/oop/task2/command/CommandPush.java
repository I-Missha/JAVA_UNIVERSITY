package nsu.oop.task2.command;

import nsu.oop.task2.exceptions.ArgumentsException;
import nsu.oop.task2.util.Data;

public class CommandPush extends Command{

    public CommandPush() {
        super( 1);
    }

    @Override
    protected void isArgumentsCorrect(Data data, String[] args) throws ArgumentsException {
        super.isArgumentsCorrect(data, args);
        if (!data.checkVar(args[0]) && !isNumeric(args[0])) {
            throw new ArgumentsException("doesn't has this var");
        }
    }

    @Override
    public void executeCommand(Data data, String[] argsString) throws ArgumentsException {
        isArgumentsCorrect(data, argsString);
        if (!isNumeric(argsString[0])) {
            data.push(data.getVarValue(argsString[0]));
            return;
        }
        data.push(Double.parseDouble(argsString[0]));
    }
}
