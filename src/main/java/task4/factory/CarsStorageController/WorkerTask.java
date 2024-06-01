package task4.factory.CarsStorageController;
import task4.factory.Products.*;
import task4.factory.Storages.*;

import static java.lang.Thread.sleep;

public class WorkerTask implements Runnable {

    protected final StoragesMap storages;

    public WorkerTask(StoragesMap storages) {
        this.storages = storages;
    }

    @Override
    public void run() {
        Body body;
        Motor motor;
        Accessory accessory;

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        body = (Body) storages.get(StoragesMap.WarehouseNames.bodies).get();
        motor = (Motor)  storages.get(StoragesMap.WarehouseNames.motors).get();
        accessory = (Accessory)  storages.get(StoragesMap.WarehouseNames.accessories).get();

        Car car = new Car(body, motor, accessory);

        storages.get(StoragesMap.WarehouseNames.cars).put(car);
    }
}
