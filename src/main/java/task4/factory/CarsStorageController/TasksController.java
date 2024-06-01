package task4.factory.CarsStorageController;

import task4.factory.BlockingQueueModel.BlockingQueue;
import task4.factory.Storages.*;
import task4.factory.workerThreadpool.ThreadPool;

public class TasksController {

    protected StoragesMap storages;
    protected BlockingQueue<Runnable> tasks;

    protected ThreadPool workers;

    public TasksController(int workersNum, StoragesMap storages) {
        this.storages = storages;
        this.tasks = new BlockingQueue<>();
        this.workers = new ThreadPool(workersNum, tasks);
        this.workers.start();
    }

    public void addTasks(int num) {
        for (int i = 0; i < num; i++) {
            tasks.put(new WorkerTask(storages));
        }
    }

}
