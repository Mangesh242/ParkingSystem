package org.example.models;

import java.util.List;

public class ParkingFloors extends BaseModel {
    private String floorNumber;
    private List<ParkingSlots> parkingSlots;
    private ParkingFloorStatus parkingFloorStatus;
    private List<SupportedVehicleTypes> vehicleTypes;

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlots> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlots> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public List<SupportedVehicleTypes> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<SupportedVehicleTypes> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
