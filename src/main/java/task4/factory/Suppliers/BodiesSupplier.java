package task4.factory.Suppliers;

import task4.factory.IdsGenerator;
import task4.factory.Products.Body;
import task4.factory.Products.Product;
import task4.factory.Storages.Storage;

public class BodiesSupplier extends Supplier {

    public BodiesSupplier(int period, Storage<Product> storage) {
        super(period, storage);
    }

    @Override
    public void deliver() throws InterruptedException {
        sleep(period);
        storage.put(new Body(IdsGenerator.generateId()));
    }
}
