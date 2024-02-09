package org.nsu.oop.task1.version2.opponent;
import java.lang.StringBuilder;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;


public class DigitOpponent {
    private String quest;
    private int lengthSeq = 4;

    public DigitOpponent(int lengthSeq) {
        this.lengthSeq = lengthSeq;
    }

    private String generatequest() {
        StringBuilder str = new StringBuilder();
        HashSet<Integer> st = new HashSet<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        while (str.length() < lengthSeq) {
            int rand = random.nextInt(1, 11);
            if (!st.contains(rand)) {
                str.append(rand);
                st.add(rand);
            }
        }

        return str.toString();
    }

    public DigitOpponent() {
        quest = generatequest();
    }

    public int countCows(String str) {
        int counter = 0;
        for (char it: str.toCharArray()) {
            if (quest.indexOf((int)it) > -1 && quest.indexOf(it) != str.indexOf(it)) {
                counter++;
            }
        }
        return counter;
    }

    public int countBulls(String str) {
        int counter = 0;
        for (char it: str.toCharArray()) {
            if (quest.indexOf(it) == str.indexOf(it)) {
                counter++;
            }
        }
        return counter;
    }

    public boolean isCorrect(String str) {
        return countBulls(str) == 4;
    }
}
