package org.example.models;
import java.util.*;

public class ParkingLots extends BaseModel {

    private String name;
    private int floors;
    private ParkingLotStatus parkingLotStatus;


    private List<ParkingFloors> parking_floors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;

    //Don't use HM better to use class
    private List<SupportedVehicleTypes> vehicleTypes;


}
