package task3;

import task3.Model.Events;

public interface Listener {
    void update(Events eventType, int x, int y);
}
