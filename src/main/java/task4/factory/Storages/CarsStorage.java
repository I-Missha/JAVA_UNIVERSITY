package task4.factory.Storages;

import task4.factory.CarsStorageController.CarsStorageController;
import task4.factory.Products.Car;
import task4.factory.Products.Product;

public class CarsStorage extends Storage<Product> {
    private CarsStorageController carsStorageController;
    public CarsStorage(int capacity) {
        super(capacity);
    }

    public void setCarsStorage(CarsStorageController carsStorageController) {
        this.carsStorageController = carsStorageController;
    }

    @Override
    public Car get() {
        if (this.carsStorageController == null) {
            throw new RuntimeException("set cars storage controller.");
        }
        synchronized (this.carsStorageController) {
            this.carsStorageController.notify();
        }
        return (Car) super.get();
    }


}
