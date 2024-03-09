package nsu.oop.task2.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void getCommandName() {
        Parser parser = new Parser("PUSH");
        assertEquals(parser.getCommandName(), "PUSH");
    }

    @Test
    void getArgs() {
        Parser parser = new Parser("PUSH");
        String[] empty = new String[0];
        assertEquals(parser.getArgs().length, empty.length);
        Parser parser1 = new Parser("DEFINE a 1");
        String[] args = new String[2];
        args[0] = "a";
        args[1] = "1";
//        assertEquals(parser.getArgs(), args);
        for (int i = 0; i < 1; i++) {
            assertEquals(parser1.getArgs()[i], args[i]);
        }
    }
}
