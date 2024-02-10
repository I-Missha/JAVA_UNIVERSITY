package org.nsu.oop.task1.version2;

public class Main {
    public static void main(String[] args) {
        try {
            BullsAndCows game = new BullsAndCows();
            game.startGameOnDigits();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
