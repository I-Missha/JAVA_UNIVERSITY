package task4.factory.Dealer;

import task4.factory.CarsStorageController.CarsStorageController;
import task4.factory.IdsGenerator;
import task4.factory.Products.Car;
import task4.factory.SingletonLogger;

import java.text.MessageFormat;
import java.util.logging.Level;

public class Dealer extends Thread {
    protected long id;
    protected int period;
    protected final CarsStorageController storagesController;

    private static final SingletonLogger logger = new SingletonLogger("DealerLog", "log.txt");

    private boolean log;

    public Dealer(int period, CarsStorageController storagesController, boolean log) {
        this.id = IdsGenerator.generateId();
        this.storagesController = storagesController;
        this.period = period;
        this.log = log;
    }

    public Dealer(int period, CarsStorageController storagesController) {
        this(period, storagesController, false);
    }

    public int getSpeed() {
        return this.period;
    }

    public void run() {
        while (true) {
            try {
                Car car = orderCar();
                if (log) {
                    String msg = MessageFormat.format("Dealer {0} : Auto {1} : (Body: {2}, Motor {3}, Accessory {4})",
                            id, car.getId(), car.getBody().getId(), car.getMotor().getId(), car.getAccessory().getId());
                    logger.getLogger().log(Level.INFO, msg);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Car orderCar() throws InterruptedException {
        sleep(period);
        synchronized (storagesController) {
            storagesController.notify();
        }
        return (Car) storagesController.getCarStorage().get();
    }

    public void setSpeed(int period) {
        this.period = period;
    }

}
