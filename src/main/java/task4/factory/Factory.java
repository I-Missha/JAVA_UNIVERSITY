package task4.factory;

import task4.factory.BlockingQueueModel.BlockingQueue;
import task4.factory.CarsStorageController.CarsStorageController;
import task4.factory.ConfigReader.ConfigReader;
import task4.factory.Dealer.Dealer;
import task4.factory.Storages.*;
import task4.factory.Suppliers.AccessoriesSupplier;
import task4.factory.Suppliers.BodiesSupplier;
import task4.factory.Suppliers.MotorsSupplier;
import task4.factory.model.Observer;
import task4.factory.workerThreadpool.ThreadPool;
import task4.view.events.*;
import task4.view.events.Event;

import java.util.ArrayList;

public class Factory implements Runnable, Observer {


    public final ArrayList<Dealer> dealers;
    public final Settings settings;
    public final ArrayList<AccessoriesSupplier> accessoriesSuppliers;
    public final BodiesSupplier bodiesSupplier;
    public final MotorsSupplier motorsSupplier;

    public final StoragesMap storages;
    public final CarsStorageController carsStorageController;
    public final ThreadPool workersThreadPool;
    public final BlockingQueue<Runnable> tasks;

    public Factory(ConfigReader configReader, Settings settings) {
        this.settings = settings;
        settings.addObserver(this);

        CarsStorage carsStorage = new CarsStorage(configReader.get(ConfigReader.Settings.storageAutoSize));
        BodiesStorage bodiesStorage = new BodiesStorage(configReader.get(ConfigReader.Settings.storageBodySize));
        MotorsStorage motorsStorage = new MotorsStorage(configReader.get(ConfigReader.Settings.storageMotorSize));
        AccessoriesStorage accessoriesStorage = new AccessoriesStorage(configReader.get(ConfigReader.Settings.storageAccessorySize));

        accessoriesSuppliers = new ArrayList<>();
        for (int i = 0; i < configReader.get(ConfigReader.Settings.accessorySuppliers); i++) {
            accessoriesSuppliers.add(new AccessoriesSupplier(settings.accessoriesSupplierSpeed, accessoriesStorage));
        }

        bodiesSupplier = new BodiesSupplier(settings.bodiesSupplierSpeed, bodiesStorage);
        motorsSupplier = new MotorsSupplier(settings.motorsSupplierSpeed, motorsStorage);

        storages = new StoragesMap(motorsStorage, bodiesStorage, accessoriesStorage, carsStorage);

        tasks = new BlockingQueue<>();
        workersThreadPool = new ThreadPool(configReader.get(ConfigReader.Settings.workers), tasks);

        double criticalCarsStorageSize = (configReader.get(ConfigReader.Settings.storageAutoSize) * 0.1);
        carsStorageController = new CarsStorageController(carsStorage, tasks, storages,
                (int) criticalCarsStorageSize + 1);
        carsStorage.setCarsStorage(carsStorageController);
        dealers = new ArrayList<>();
        boolean log = configReader.get(ConfigReader.Settings.logSale) == 1;
        for (int i = 0; i < configReader.get(ConfigReader.Settings.dealers); i++) {
            if (log) {
                dealers.add(new Dealer(settings.dealerPeriod, carsStorage, true));
            } else {
                dealers.add(new Dealer(settings.dealerPeriod, carsStorage));
            }
        }
    }

    public void run() {
        for (AccessoriesSupplier supplier : accessoriesSuppliers) {
            supplier.start();
        }
        bodiesSupplier.start();
        motorsSupplier.start();
        workersThreadPool.run();
        for (Dealer dealer : dealers) {
            dealer.start();
        }
        carsStorageController.start();
    }

    @Override
    public void notify(Event event) {
        if (event instanceof AccessoriesSupplierEvent) {
            this.settings.accessoriesSupplierSpeed = event.value * 1000;
            for (AccessoriesSupplier supplier : accessoriesSuppliers) {
                supplier.setPeriod(this.settings.accessoriesSupplierSpeed);
            }
        } else if (event instanceof BodySupplierEvent) {
            this.settings.bodiesSupplierSpeed = event.value * 1000;
            bodiesSupplier.setPeriod(this.settings.bodiesSupplierSpeed);
        } else if (event instanceof DealerEvent) {
            this.settings.dealerPeriod = event.value * 1000;
            for (Dealer dealer : dealers) {
                dealer.setSpeed(this.settings.dealerPeriod);
            }
        } else if (event instanceof MotorSupplierEvent) {
            this.settings.motorsSupplierSpeed = event.value * 1000;
            motorsSupplier.setPeriod(this.settings.motorsSupplierSpeed);
        }
    }
}
