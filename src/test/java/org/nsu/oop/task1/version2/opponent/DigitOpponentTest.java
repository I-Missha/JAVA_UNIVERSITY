package org.nsu.oop.task1.version2.opponent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitOpponentTest {

    @Test
    public void testApp() {
        DigitOpponent opponent = new DigitOpponent(4);
        opponent.setSequenceNumb("1234");

        assertEquals( 2,opponent.countCows("7148"));
        assertEquals( 2,opponent.countCows("5347"));
        assertEquals(4, opponent.countBulls("1234"));
        assertEquals(2, opponent.countBulls("1784"));

        assertThrows(RuntimeException.class, () -> opponent.setSequenceNumb("98765"));
        assertThrows(RuntimeException.class, () -> opponent.setSequenceNumb(null));
        assertThrows(RuntimeException.class, () -> opponent.setSequenceNumb("1123"));
        assertTrue(opponent.isCorrect(opponent.getAnswer()));
    }
}