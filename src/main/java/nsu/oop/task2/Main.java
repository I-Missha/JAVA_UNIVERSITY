package nsu.oop.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Class 3
// Main class
public class Main {
    // Main driver method
    public static void main(String[] args) {
        // Creating an instance of above class
        // inside main() method
        Logger logger = LoggerFactory.getLogger(Main.class);
        try {
            Calculator calculator = new Calculator();
            calculator.startCalc();

        } catch(Throwable e) {
            logger.warn("error: " + e.getMessage());
        }
    }
}