package org.example.repositories;

import org.example.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleRepository {
    private static VehicleRepository instance;

    private List<Vehicle> vehicleList=new ArrayList<>();
    private VehicleRepository() {}
    public static VehicleRepository getInstance() {
        if(instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }
    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        for(Vehicle vehicle : vehicleList) {
            if(vehicle.getLicencePlateNumber().equalsIgnoreCase(vehicleNumber)){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }
    public boolean saveVehicle(Vehicle vehicle) {
        for(Vehicle existingVehicle : vehicleList) {
            if(existingVehicle.getLicencePlateNumber().equalsIgnoreCase(vehicle.getLicencePlateNumber())){
                return false;
            }
        }
        vehicleList.add(vehicle);
        return true;
    }
}
