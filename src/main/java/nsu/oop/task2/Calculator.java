package nsu.oop.task2;

import nsu.oop.task2.errors.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nsu.oop.task2.command.Command;
import nsu.oop.task2.command.CommandFactory;
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
    final private CommandFactory factory;
    final public Logger logger = LoggerFactory.getLogger(Calculator.class);

    public Calculator(String fileName) throws FileException, CommandCreationException {
        data = new Data();
        this.fileName = fileName;
        factory = new CommandFactory();
    }

    public Calculator() throws FileException, CommandCreationException {
        data = new Data();
        fileName = null;
        factory = new CommandFactory();

    }

    public void startCalc() throws Exception {
//  stream -> createCommand -> run command
        Stream<String> stream; // stream of commands

        if (fileName == null) {
            stream = new BufferedReader(new InputStreamReader(System.in)).lines();
        } else {
            try {
                stream = Files.lines(Paths.get(fileName));
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        stream.forEach(this::executeExpression);
//    stream.forEach( -> System.out.println(str));
    }

    private void executeExpression(String inputExpr){
        Parser parser = new Parser(inputExpr);
        Command command = factory.createClass(parser.getCommandName());
//        System.out.println(command.getClass());
        try {
//            Arrays.stream(parser.getArgs()).forEach(str -> System.out.println(str));
            command.executeCommand(data, parser.getArgs());
            logger.debug(command + " was executed.");
        } catch(DataException | ArgumentsException | CommandExecutionException e) {
            logger.warn("error: " + e.getMessage());
        }
    }
}
