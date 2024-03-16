package nsu.oop.task2.command;

import nsu.oop.task2.exceptions.DataException;
import nsu.oop.task2.util.Data;

public class CommandPrint extends Command{
    public CommandPrint() {
        super(1);
    }

    @Override
    public void executeCommand(Data data, String[] argsString) throws DataException {
        try {
            System.out.println(data.checkPeek());
        } catch(DataException exception) {
            throw exception;
        }
    }
}
