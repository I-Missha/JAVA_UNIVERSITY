package org.nsu.oop.task2.util;

import java.util.HashMap;
import java.util.Stack;

public class Data {
    private final Stack<Double> stack;
    private final HashMap<String, Double> varMap;

    public Data() {
        this.stack = new Stack<>();
        this.varMap = new HashMap<>();
    }

    public void push(double element) {
        stack.push(element);
    }

    public double pop() throws Exception {
        if (stack.empty()) {
            throw new Exception();
        }
        return stack.pop();
    }
}
