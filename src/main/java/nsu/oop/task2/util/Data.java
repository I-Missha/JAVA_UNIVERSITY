package nsu.oop.task2.util;

import nsu.oop.task2.exceptions.DataException;

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

    public double pop() throws DataException {
        if (stack.empty()) {
            throw new DataException("Cant execute pop due to an empty stack");
        }
        return stack.pop();
    }

    public void setVar(String name, double value) {
        varMap.put(name, value);
    }

    public double checkPeek() throws DataException {
        if (stack.empty()) {
            throw new DataException("Cant execute checkPeek due to an empty stack");
        }
        return stack.peek();
    }
    public boolean checkVar(String name) {
        return varMap.containsKey(name);
    }

    public double getVarValue(String name) {
        return varMap.get(name);
    }
}
