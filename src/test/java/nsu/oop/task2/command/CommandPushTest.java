package nsu.oop.task2.command;

import nsu.oop.task2.exceptions.ArgumentsException;
import nsu.oop.task2.exceptions.DataException;
import nsu.oop.task2.parser.Parser;
import nsu.oop.task2.util.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandPushTest {

    @Test
    void executeCommand() {
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