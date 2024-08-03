package org.example.repositories;

public class VehicleRepository {
    private static VehicleRepository instance;
    private VehicleRepository() {}
    public static VehicleRepository getInstance() {
        if(instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }
}
