package nsu.oop.task2;

import nsu.oop.task2.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nsu.oop.task2.command.Command;
import nsu.oop.task2.factory.CommandFactory;
import nsu.oop.task2.parser.Parser;
import nsu.oop.task2.util.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Calculator {
    private String fileName = null;
    final private Data data; // stack and table of vars
    final public Logger logger = LoggerFactory.getLogger(Calculator.class);

    public Calculator(String fileName) {
        data = new Data();
        this.fileName = fileName;

    }

    public Calculator() {
        data = new Data();
        fileName = null;

    }

    public void startCalc() throws FileException, CommandCreationException {
//  stream -> createCommand -> run command
        CommandFactory factory = new CommandFactory();
        factory.initial();
        Stream<String> stream; // stream of commands

        if (fileName == null) {
            stream = new BufferedReader(new InputStreamReader(System.in)).lines();
        } else {
            try {
                stream = Files.lines(Paths.get(fileName));
            } catch (Exception e) {
                throw new FileException("cant read from the file: " + fileName);
            }
        }
        
    stream.forEach( str -> executeExpression(str, factory));
    }

    private void executeExpression(String inputExpr, CommandFactory factory){
        Parser parser = new Parser(inputExpr);
        Command command = factory.createClass(parser.getCommandName());
        try {
            command.executeCommand(data, parser.getArgs());
            logger.debug(command + " was executed.");
        } catch(DataException | ArgumentsException | CommandExecutionException e) {
            logger.warn("error: " + e.getMessage());
        }
    }
}
