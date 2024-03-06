package org.nsu.oop.task2;

import org.nsu.oop.task2.command.Command;
import org.nsu.oop.task2.command.CommandFactory;
import org.nsu.oop.task2.parsers.Parser;
import org.nsu.oop.task2.util.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Calculator {
    final private String fileName;
    final private Data data; // stack and table of vars
    final private Stream<String> stream; // stream of commands
    final private CommandFactory factory;

    public Calculator(String fileName) throws Exception {
        data = new Data();
        this.fileName = fileName;
        try {
            stream = Files.lines(Paths.get(fileName));
            factory = new CommandFactory();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Calculator() throws Exception {
        data = new Data();
        fileName = null;
        stream = new BufferedReader(new InputStreamReader(System.in)).lines();
        try {
            factory = new CommandFactory();
        } catch(Exception e) {
            throw new Exception();
        }
    }

    public void startCalc() {
//  stream -> createCommand -> run command
        stream.forEach(this::executeExpression);
//    stream.forEach( -> System.out.println(str));
    }

    private void executeExpression(String inputExpr) throws RuntimeException {
        Parser parser = new Parser(inputExpr);
        Command command = factory.createClass(parser.getCommandName());
        try {
            command.executeCommand(data, parser.getArgs());
        } catch(Exception e) {
            throw new RuntimeException();
        }
        return ;
    }

}
