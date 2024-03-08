package nsu.oop.task2.command;

import nsu.oop.task2.errors.ArgumentsException;
import nsu.oop.task2.errors.CommandExecutionException;
import nsu.oop.task2.errors.DataException;
import nsu.oop.task2.util.Data;

public abstract class Command {
    int numOfArguments;
    public Command(int numOfArguments) {
        this.numOfArguments = numOfArguments;
    }

    protected boolean isNumOfArgumentsCorrect(int num) {
        return num == numOfArguments;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    protected void isArgumentsCorrect(Data data, String[] args) throws ArgumentsException {
        if (!isNumOfArgumentsCorrect(args.length)) {
            throw new ArgumentsException("too many arguments");
        }
    }

    public void executeCommand(Data data, String[] argsVec) throws DataException, ArgumentsException, CommandExecutionException {

    };
}
