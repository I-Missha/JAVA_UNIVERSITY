package task4.factory.model;

import task4.view.events.Event;

public interface Observer {
    void notify(Event event);
}