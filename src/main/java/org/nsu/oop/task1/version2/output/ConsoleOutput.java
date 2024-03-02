package org.nsu.oop.task1.version2.output;

public class ConsoleOutput implements Output{
    @Override
    public void consoleOut(String out) {
        System.out.println(out);
    }
}
