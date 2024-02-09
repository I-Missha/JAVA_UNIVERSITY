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

    public void startGameOnDigits() {
        System.out.println("You can start guessing");
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();
        config = new Config();
        config.setSequenceLength(4);
        DigitOpponent opponent = new DigitOpponent(config.getLengthOfSequence());
        String str;
        do {
            str = input.getConsoleInput();
            if (str.length() != config.getLengthOfSequence() || !isNumeric(str)) {
                output.consoleOut("Invalid input, try again");
                continue;
            }
            if (opponent.isCorrect(str)) {
                output.consoleOut("You guessed");
                break;
            }
            output.consoleOut("Cows: " + opponent.countCows(str));
            output.consoleOut("Bulls: " + opponent.countBulls(str));
        } while (!opponent.isCorrect(str));
    }
    public void changeConfig(int length) {
        config.setSequenceLength(length);
    }
}
