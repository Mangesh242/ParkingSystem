package org.example.models;

import java.util.List;

public class ParkingSlots extends BaseModel {
    private String slotNumber;
    private ParkingSlotStatus parkingSlotsStatus;
    private List<SupportedVehicleTypes> vehicleTypes;

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingSlotStatus getParkingSlotsStatus() {
        return parkingSlotsStatus;
    }

    public void setParkingSlotsStatus(ParkingSlotStatus parkingSlotsStatus) {
        this.parkingSlotsStatus = parkingSlotsStatus;
    }

    public List<SupportedVehicleTypes> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<SupportedVehicleTypes> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
