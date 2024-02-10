package org.nsu.oop.task1.version2.opponent;
import java.lang.StringBuilder;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;


public class DigitOpponent {
    private String quest;
    private int lengthSeq = 4;

    private String generateQuest() {
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

    public DigitOpponent(int lengthSeq) {
        quest = generateQuest();
        this.lengthSeq = lengthSeq;
    }

    public DigitOpponent() {
        quest = generateQuest();
    }

    public int countCows(String str) {
        int counter = 0;
        for (char it: str.toCharArray()) {
            if (quest.indexOf(it) > -1 && quest.indexOf(it) != str.indexOf(it)) {
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

    public String getAnswer() {
        return this.quest;
    }
}
