package org.example.models;

import java.util.List;

public class ParkingSlot extends BaseModel {
    private String slotNumber;
    private ParkingSlotStatus parkingSlotsStatus;
//    private List<SupportedVehicleTypes> vehicleTypes;
    private SupportedVehicleType vehicleType;

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

    public SupportedVehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleTypes(SupportedVehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
