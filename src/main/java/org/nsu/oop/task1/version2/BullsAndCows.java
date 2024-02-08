package org.nsu.oop.task1.version2;
import org.nsu.oop.task1.version2.opponent.DigitOpponent;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BullsAndCows {
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public void startGame() {
        DigitOpponent opponent = new DigitOpponent();
        System.out.println("You can start guessing");
        Scanner in = new Scanner(System.in);
        String str;
        do {
            str = in.next();
            if (str.length() != 4 || !isNumeric(str)) {
                System.out.println("Invalid input, try again");
                continue;
            }
            if (opponent.isCorrect(str)) {
                System.out.println("You guessed");
                break;
            }
            System.out.println("Cows: " + opponent.countCaws(str));
            System.out.println("Cows: " + opponent.countBulls(str));
        } while (!opponent.isCorrect(str));
    }
}
