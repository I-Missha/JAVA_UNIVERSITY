package nsu.oop.task2.command;

import nsu.oop.task2.exceptions.ArgumentsException;
import nsu.oop.task2.exceptions.CommandExecutionException;
import nsu.oop.task2.exceptions.DataException;
import nsu.oop.task2.parser.Parser;
import nsu.oop.task2.util.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandMultiplyTest {

    @Test
    void executeCommand() {
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
