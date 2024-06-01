package task4.factory.Products;

import task4.factory.IdsGenerator;

public class Car extends Product{
    protected final Body body;
    protected final Motor motor;
    protected final Accessory accessory;

    public Car(Body body, Motor motor, Accessory accessory) {
        super(IdsGenerator.generateId());
        this.body = body;
        this.motor = motor;
        this.accessory = accessory;
    }

    public Body getBody() {
        return body;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public Motor getMotor() {
        return motor;
    }
}

