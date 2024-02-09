package org.nsu.oop.task1.version2.input;


import java.util.Scanner;

public class ConsoleInput implements Input{
    Scanner in;
    public ConsoleInput() {
        in = new Scanner(System.in);
    }

    @Override
    public String getConsoleInput() {
        return in.nextLine();
    }
}
