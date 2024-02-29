package org.nsu.oop.task2;

import java.util.*;

// Class 1
// Super Class
//class Fruit {
//    public int fruit = 0;
//    // Method inside super class
//    public Fruit() {
//
//        // Print statement
//        System.out.println("Super class constructor");
//
//        // Displaying object hashcode of super class
//        System.out.println("Super class object hashcode :" +
//                this.hashCode());
//
//        System.out.println(this.getClass().getName());
//    }
//    public void getFruit() {
//        System.out.println();
//    }
//}
//
//// Class 2
//// Sub class extending above super class
//class Apple extends Fruit {
//    public int apple = 1;
//    // Method inside sub class
//    public Apple() {
//
//        // Print statement
//        System.out.println("Subclass constructor invoked");
//
//        // Displaying object hashcode of sub class
//        System.out.println("Sub class object hashcode :" +
//                this.hashCode());
//
//        System.out.println(this.hashCode() + " " +
//                super.hashCode());
//
//        System.out.println(this.getClass().getName() + " " +
//                super.getClass().getName());
//    }
//    public void getApple() {
//        System.out.println(apple);
//    }
//}

// Class 3
// Main class
public class Main {
    // Main driver method
    public static void main(String[] args) {
        // Creating an instance of above class
        // inside main() method
        Calculator calculator = new Calculator();
        calculator.startCalc();
    }
}