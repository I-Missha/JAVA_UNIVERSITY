package task4.factory;

import task4.factory.model.Observable;
import task4.factory.model.Observer;

public class Settings extends Observable implements Observer {
    public int accessoriesSupplierSpeed;
    public int bodiesSupplierSpeed;
    public int motorsSupplierSpeed;
    public int dealerPeriod;

    public Settings(int accessoriesSupplierSpeed, int bodiesSupplierSpeed, int motorsSupplierSpeed, int dealerPeriod) {
        this.accessoriesSupplierSpeed = accessoriesSupplierSpeed;
        this.bodiesSupplierSpeed = bodiesSupplierSpeed;
        this.dealerPeriod = dealerPeriod;
        this.motorsSupplierSpeed = motorsSupplierSpeed;
    }
}