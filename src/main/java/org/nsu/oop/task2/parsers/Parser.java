package org.nsu.oop.task2.parsers;

import java.util.Arrays;

public class Parser {
    private String[] strArr;

    public Parser(String strToParse) {
        strArr = strToParse.split(" ");
    }

    public String getCommandName() {
        return strArr[0];
    }

    public String[] getArgs() {
        return Arrays.stream(strArr).skip(1).toArray(String[]::new);
    }
}
