package nsu.oop.task2.command;

import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.errors.DataException;
import nsu.oop.task2.parser.Parser;
import nsu.oop.task2.util.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandPopTest {

    @Test
    void executeCommand() {
        Data data = new Data();
        CommandPop comm = new CommandPop();
        Parser parser = new Parser("POP");

        data.push(2);
        data.push(1);
        try {
            comm.executeCommand(data, parser.getArgs());
            assertEquals(data.checkPeek(), 2.0);
        } catch(DataException | ArgumentsException e) {
            fail(e.getMessage());
        }
    }
}
