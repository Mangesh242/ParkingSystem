package org.example.models;
import java.util.*;

public class ParkingLot extends BaseModel {

    private String name;
    private int floors;
    private ParkingLotStatus parkingLotStatus;
    private SlotAssignmentStrategyType slotAssignmentStrategyType;
    private List<ParkingFloor> parking_floors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;

    //Don't use HM better to use class
    private List<SupportedVehicleType> vehicleTypes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<ParkingFloor> getParking_floors() {
        return parking_floors;
    }

    public void setParking_floors(List<ParkingFloor> parking_floors) {
        this.parking_floors = parking_floors;
    }

    public List<Gate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(List<Gate> entryGates) {
        this.entryGates = entryGates;
    }

    public List<Gate> getExitGates() {
        return exitGates;
    }

    public void setExitGates(List<Gate> exitGates) {
        this.exitGates = exitGates;
    }

    public List<SupportedVehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<SupportedVehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public SlotAssignmentStrategyType getSlotAssignmentStrategyType() {
        return slotAssignmentStrategyType;
    }

    public void setSlotAssignmentStrategyType(SlotAssignmentStrategyType slotAssignmentStrategyType) {
        this.slotAssignmentStrategyType = slotAssignmentStrategyType;
    }
}
