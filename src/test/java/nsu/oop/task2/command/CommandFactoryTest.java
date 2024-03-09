package nsu.oop.task2.command;

import junit.framework.TestCase;
import nsu.oop.task2.errors.CommandCreationException;
import nsu.oop.task2.errors.FileException;
import nsu.oop.task2.factory.CommandFactory;

public class CommandFactoryTest extends TestCase {

    public void testCreateClass() {
        try {
            CommandFactory factory = new CommandFactory();
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