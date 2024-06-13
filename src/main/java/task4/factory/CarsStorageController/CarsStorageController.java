package task4.factory.CarsStorageController;
import task4.factory.BlockingQueueModel.BlockingQueue;
import task4.factory.Storages.CarsStorage;
import task4.factory.Storages.StoragesMap;

public class CarsStorageController extends Thread {

    protected final CarsStorage storage;
    protected final BlockingQueue<Runnable> tasks;
    protected final StoragesMap storages;
    protected int criticalSize;


    public CarsStorageController(CarsStorage storage, BlockingQueue<Runnable> tasks, StoragesMap storages, int criticalSize) {
        this.storage = storage;
        this.criticalSize = criticalSize;
        this.tasks = tasks;
        this.storages = storages;
    }


    protected void addTasks(int numTasks) {
        for (int i = 0; i < numTasks; i++) {
            this.tasks.put(new WorkerTask(storages));
        }
    }

    public synchronized void run() {
        while (true) {
            try {
                wait();
                synchronized (storage) {
                    if (storage.getCurrentSize() < criticalSize && tasks.getCurrentSize() <= criticalSize * 4) {
                        addTasks(criticalSize * 2);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
