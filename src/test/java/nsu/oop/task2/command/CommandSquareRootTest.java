package nsu.oop.task2.command;

import nsu.oop.task2.exceptions.DataException;
import nsu.oop.task2.parser.Parser;
import nsu.oop.task2.util.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandSquareRootTest {

    @Test
    void executeCommand() {
        Data data = new Data();
        CommandSquareRoot comm = new CommandSquareRoot();
        Parser parser = new Parser("SQRT");

        data.push(2);
        data.push(1);
        try {
            comm.executeCommand(data, parser.getArgs());
            assertEquals(data.checkPeek(), 1.0);
        } catch(DataException e) {
            fail(e.getMessage());
        }
    }
}
