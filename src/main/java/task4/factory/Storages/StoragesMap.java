package task4.factory.Storages;

import task4.factory.Products.Product;

import java.util.HashMap;

public class StoragesMap {
    protected final HashMap<WarehouseNames, Storage<Product>> warehouses;

    public enum WarehouseNames {
        accessories(AccessoriesStorage.class.getName()),
        motors(MotorsStorage.class.getName()),
        bodies(BodiesStorage.class.getName()),
        cars(CarsStorage.class.getName());

        private final String name;
        WarehouseNames(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    public StoragesMap(MotorsStorage motorsWarehouse, BodiesStorage bodiesWarehouse, AccessoriesStorage accessoriesWarehouse, CarsStorage carsWarehouse) {
        this.warehouses = new HashMap<>();
        this.warehouses.put(WarehouseNames.accessories, accessoriesWarehouse);
        this.warehouses.put(WarehouseNames.motors, motorsWarehouse);
        this.warehouses.put(WarehouseNames.bodies, bodiesWarehouse);
        this.warehouses.put(WarehouseNames.cars, carsWarehouse);
    }

    public Storage<Product> get(WarehouseNames name) {
        return warehouses.getOrDefault(name, null);
    }
}
