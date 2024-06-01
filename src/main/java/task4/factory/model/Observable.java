package task4.factory.model;

import task4.view.events.Event;

import java.util.ArrayList;
import java.util.List;
public abstract class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver (Observer observer) {
        observers.add(observer);
    }

    public void notify(Event event) {
        for (Observer o: observers) {
            o.notify(event);
        }
    }
}
