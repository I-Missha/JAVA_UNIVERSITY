package org.nsu.oop.task1.version2.input;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.nsu.oop.task1.version2.util.Config;

public class ConsoleInput implements Input{
    Scanner in;
    Config config;
    boolean legal = true;
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public ConsoleInput(Config conf) {
        in = new Scanner(System.in);
        this.config = conf;
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
    private boolean isUniq(String str) {
        char[] strMas = str.toCharArray();
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length() - 1; j++) {
                if (strMas[i] == strMas[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getConsoleInput() throws IllegalArgumentException {
        String str = in.nextLine();
        if (str.length() != config.getLengthOfSequence() || !isNumeric(str) || !isUniq(str)) {
            legal = false;
            throw new IllegalArgumentException();
        }
        legal = true;
        return str;
    }
}
