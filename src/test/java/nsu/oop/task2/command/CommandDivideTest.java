package nsu.oop.task2.command;

import junit.framework.TestCase;
import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.errors.CommandExecutionException;
import nsu.oop.task2.errors.DataException;
import nsu.oop.task2.parser.Parser;
import nsu.oop.task2.util.Data;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandDivideTest extends TestCase {

    public void testExecuteCommand() {
        Data data = new Data();
        CommandDivide comm = new CommandDivide();
        Parser parser = new Parser("/");

        data.push(2);
        data.push(1);
        try {
            comm.executeCommand(data, parser.getArgs());
            assertEquals(data.checkPeek(), 2.0);
        } catch (DataException | CommandExecutionException | ArgumentsException e) {
            fail(e.getMessage());
        }

        data.push(1);
        data.push(0);

        assertThrows(CommandExecutionException.class, () -> comm.executeCommand(data, parser.getArgs()));
    }
}