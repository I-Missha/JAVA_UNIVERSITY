package task4.factory.Suppliers;

import task4.factory.IdsGenerator;
import task4.factory.Products.Motor;
import task4.factory.Products.Product;
import task4.factory.Storages.Storage;

public class MotorsSupplier extends Supplier {

    public MotorsSupplier(int period, Storage<Product> storage) {
        super(period, storage);
    }

    @Override
    public void deliver() throws InterruptedException {
        sleep(period);
        storage.put(new Motor(IdsGenerator.generateId()));
    }
}
