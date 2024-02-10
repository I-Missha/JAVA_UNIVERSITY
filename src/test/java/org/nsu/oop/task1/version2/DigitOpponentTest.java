package org.nsu.oop.task1.version2;

import org.nsu.oop.task1.version2.opponent.DigitOpponent;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DigitOpponentTest extends TestCase{
    public DigitOpponentTest(String testName) {
        super(testName);
    }
    public static Test suite() {
        return new TestSuite(DigitOpponentTest.class);
    }

    public void testApp() {
        DigitOpponent opponent = new DigitOpponent(4);
        assertEquals( 0,opponent.countCows(opponent.getAnswer()));
        assertEquals(4, opponent.countBulls(opponent.getAnswer()));
        assertTrue(opponent.isCorrect(opponent.getAnswer()));

    }
}
