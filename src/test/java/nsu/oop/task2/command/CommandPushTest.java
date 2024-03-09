package nsu.oop.task2.command;

import junit.framework.TestCase;
import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.errors.DataException;
import nsu.oop.task2.parser.Parser;
import nsu.oop.task2.util.Data;

public class CommandPushTest extends TestCase {

    public void testExecuteCommand() {
        Data data = new Data();
        CommandPush comm = new CommandPush();
        Parser parser = new Parser("PUSH 1");

        try {
            comm.executeCommand(data, parser.getArgs());
            assertEquals(data.checkPeek(), 1.0);
        } catch(DataException | ArgumentsException e) {
            fail(e.getMessage());
        }
    }
}