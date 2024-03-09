package nsu.oop.task2.factory;

import nsu.oop.task2.command.*;
import nsu.oop.task2.errors.CommandCreationException;
import nsu.oop.task2.errors.FileException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandFactoryTest {
    @Test
    void createClass() {
        try {
            CommandFactory factory = new CommandFactory();
            factory.initial();
            assertEquals(CommandDefine.class, factory.createClass("DEFINE").getClass());
            assertEquals(CommandDivide.class, factory.createClass("/").getClass());
            assertEquals(CommandMinus.class, factory.createClass("-").getClass());
            assertEquals(CommandMultiply.class, factory.createClass("*").getClass());
            assertEquals(CommandPlus.class, factory.createClass("+").getClass());
            assertEquals(CommandPush.class, factory.createClass("PUSH").getClass());
            assertEquals(CommandPop.class, factory.createClass("POP").getClass());
            assertEquals(CommandPrint.class, factory.createClass("PRINT").getClass());
        } catch (FileException | CommandCreationException e) {
            fail(e.getMessage());
        }
    }
}
