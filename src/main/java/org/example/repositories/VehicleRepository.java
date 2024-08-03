package org.example.repositories;

import org.example.models.Vehicle;

import java.util.*;

public class VehicleRepository {
    private static VehicleRepository instance;

    private Map<String, Vehicle> vehicleList=new TreeMap<>();
    private VehicleRepository() {}
    public static VehicleRepository getInstance() {
        if(instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }
    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
       if(vehicleList.containsKey(vehicleNumber)) {
           return Optional.of(vehicleList.get(vehicleNumber));
       }
        return Optional.empty();
    }
    public boolean saveVehicle(Vehicle vehicle) {
        if(vehicleList.containsKey(vehicle.getLicencePlateNumber())){
            return false;
        }
        vehicleList.put(vehicle.getLicencePlateNumber(),vehicle);
        return true;
    }
}
