package org.nsu.oop.task1.version2.input;

import org.junit.jupiter.api.Test;
import org.nsu.oop.task1.version2.util.Config;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputTest {
    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
    @Test
    public void getInputTest() {
        Config config = new Config();
        provideInput("1234");
        ConsoleInput consoleInput = new ConsoleInput(config);
        assertEquals("1234", consoleInput.getConsoleInput());
        provideInput("1111");
        ConsoleInput consoleInput2 = new ConsoleInput(config);
        assertThrows(IllegalArgumentException.class, consoleInput2::getConsoleInput);
    }
}