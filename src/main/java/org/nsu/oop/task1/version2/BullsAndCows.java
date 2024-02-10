package org.nsu.oop.task1.version2;
import org.nsu.oop.task1.version2.opponent.DigitOpponent;
import org.nsu.oop.task1.version2.input.ConsoleInput;
import org.nsu.oop.task1.version2.output.ConsoleOutput;
import org.nsu.oop.task1.version2.util.Config;
import java.util.regex.Pattern;

public class BullsAndCows {
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    Config config;
    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public void startGameOnDigits() throws RuntimeException {
        System.out.println("You can start guessing");
        config = new Config();
        config.setSequenceLength(4);
        ConsoleInput input = new ConsoleInput(config);
        ConsoleOutput output = new ConsoleOutput();
        DigitOpponent opponent = new DigitOpponent(config.getLengthOfSequence());
        String str;
        while(true) {
            try {
                str = input.getConsoleInput();
            } catch(IllegalArgumentException e) {
                System.err.println("Illegal argument input, enter 4 different digits in a line");
                continue;
            }
            if (opponent.isCorrect(str)) {
                output.consoleOut("You guessed");
                break;
            }
            output.consoleOut("Cows: " + opponent.countCows(str));
            output.consoleOut("Bulls: " + opponent.countBulls(str));
        }
    }
    public void changeConfig(int length) {
        config.setSequenceLength(length);
    }
}
