package nsu.oop.task2.command;

import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.errors.DataException;
import nsu.oop.task2.util.Data;

public class CommandPop extends Command{
    public CommandPop() {
        super(0);
    }

    @Override
    public void executeCommand(Data data,String[] argsString) throws ArgumentsException, DataException {
        isArgumentsCorrect(data, argsString);
        data.pop();
    }

}
