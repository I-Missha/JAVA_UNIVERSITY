package task4.factory.Dealer;

import task4.factory.IdsGenerator;
import task4.factory.Products.Car;
import task4.factory.SingletonLogger;
import task4.factory.Storages.CarsStorage;

import java.text.MessageFormat;
import java.util.logging.Level;

public class Dealer extends Thread {
    protected long id;
    protected int period;

    protected final CarsStorage carsStorage;
    private static final SingletonLogger logger = new SingletonLogger("DealerLog", "log.txt");

    private boolean log;

    public Dealer(int period, CarsStorage carsStorage, boolean log) {
        this.id = IdsGenerator.generateId();
        this.carsStorage = carsStorage;
        this.period = period;
        this.log = log;
    }

    public Dealer(int period, CarsStorage carsStorage) {
        this(period, carsStorage, false);
    }

    public int getSpeed() {
        return this.period;
    }

    public void run() {
        while (true) {
            try {
                sleep((int) (period * 2));
                Car car = carsStorage.get();
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

    public void setSpeed(int period) {
        this.period = period;
    }

}
