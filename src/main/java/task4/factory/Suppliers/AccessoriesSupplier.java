package task4.factory.Suppliers;

import task4.factory.IdsGenerator;
import task4.factory.Products.Accessory;
import task4.factory.Products.Product;
import task4.factory.Storages.Storage;

public class AccessoriesSupplier extends Supplier {

    public AccessoriesSupplier(int period, Storage<Product> storage) {
        super(period, storage);
    }

    @Override
    public void deliver() throws InterruptedException {
        sleep(period);
        storage.put(new Accessory(IdsGenerator.generateId()));
    }
}

