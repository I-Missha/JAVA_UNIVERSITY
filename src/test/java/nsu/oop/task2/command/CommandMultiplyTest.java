package nsu.oop.task2.command;

import junit.framework.TestCase;
import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.errors.CommandExecutionException;
import nsu.oop.task2.errors.DataException;
import nsu.oop.task2.parser.Parser;
import nsu.oop.task2.util.Data;

public class CommandMultiplyTest extends TestCase {

    public void testExecuteCommand() {
        Data data = new Data();
        CommandMultiply comm = new CommandMultiply();
        Parser parser = new Parser("*");

        data.push(2);
        data.push(1);
        try {
            comm.executeCommand(data, parser.getArgs());
            assertEquals(data.checkPeek(), 2.0);
        } catch(DataException | CommandExecutionException | ArgumentsException e) {
            fail(e.getMessage());
        }
    }
}