package nsu.oop.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        try {
            Calculator calculator = new Calculator();
            calculator.startCalc();

        } catch(Throwable e) {
            logger.warn("error: " + e.getMessage());
        }
    }
}
