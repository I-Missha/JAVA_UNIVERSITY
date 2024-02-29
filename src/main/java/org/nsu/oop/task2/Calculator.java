package org.nsu.oop.task2;

import org.nsu.oop.task2.util.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Calculator {
    final private String fileName;
    final private Data data;
    final private Stream<String> stream; // stream of commands

    public Calculator(String fileName) throws Exception {
        this.fileName = fileName;
        data = new Data();
        try {
            stream = Files.lines(Paths.get(fileName));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Calculator() {
        data = new Data();
        fileName = null;
        stream = new BufferedReader(new InputStreamReader(System.in)).lines();
    }

    public void startCalc() {
//        CommandFactory -> foreach

    }

}
