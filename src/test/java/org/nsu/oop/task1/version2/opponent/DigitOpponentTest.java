package org.nsu.oop.task1.version2.opponent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitOpponentTest {

    @Test
    public void testApp() {
        DigitOpponent opponent = new DigitOpponent(4);
        assertEquals( 0,opponent.countCows(opponent.getAnswer()));
        assertEquals(4, opponent.countBulls(opponent.getAnswer()));
        assertTrue(opponent.isCorrect(opponent.getAnswer()));

    }
}