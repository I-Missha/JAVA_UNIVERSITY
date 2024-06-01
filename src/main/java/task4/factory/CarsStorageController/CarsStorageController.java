package task4.factory.CarsStorageController;
import task4.factory.Storages.CarsStorage;

public class CarsStorageController extends Thread {

    protected final CarsStorage storage;
    protected final TasksController tasksController;
    protected int criticalSize;

    public CarsStorageController(CarsStorage storage, TasksController tasksController, int criticalSize) {
        this.storage = storage;
        this.criticalSize = criticalSize;
        this.tasksController = tasksController;
    }

    public CarsStorageController(CarsStorage storage, TasksController tasksController) {
        this(storage, tasksController, 5);
    }
    public CarsStorage getCarStorage() {
        return storage;
    }

    public synchronized void run() {
        while (true) {
            try {
                wait();
                synchronized (storage) {
                    if (storage.getCurrentSize() < criticalSize) {
                        tasksController.addTasks((criticalSize - storage.getCurrentSize()));
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
