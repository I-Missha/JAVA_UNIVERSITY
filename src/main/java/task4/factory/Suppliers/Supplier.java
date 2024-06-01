package task4.factory.Suppliers;

import task4.factory.Products.Product;
import task4.factory.Storages.Storage;

abstract public class Supplier extends Thread {

    protected int period;
    protected final Storage<Product> storage;

    public Supplier(int period, Storage<Product> storage) {
        this.period = period;
        this.storage = storage;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int newPeriod) {
        if (newPeriod > 0) {
            this.period = newPeriod;
        }
    }

    public void run() {
        while (true) {
            try {
                deliver();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    abstract public void deliver() throws InterruptedException;
}
