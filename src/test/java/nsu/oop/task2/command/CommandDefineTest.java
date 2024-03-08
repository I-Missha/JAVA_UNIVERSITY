package nsu.oop.task2.command;

import junit.framework.TestCase;
import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.parser.Parser;
import nsu.oop.task2.util.Data;

public class CommandDefineTest extends TestCase {

    public void testExecuteCommand() {
        Data data = new Data();
        CommandDefine comm = new CommandDefine();
        Parser parser = new Parser("DEFINE var 1");
        assertFalse(data.checkVar("var"));
        try {
            comm.executeCommand(data, parser.getArgs());
        } catch (ArgumentsException e) {
            fail(e.getMessage());
        }
        assertTrue(data.checkVar("var"));
        assertEquals(data.getVarValue("var"), 1.0);
    }
}