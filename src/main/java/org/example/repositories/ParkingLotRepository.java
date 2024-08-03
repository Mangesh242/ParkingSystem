package org.example.repositories;

import org.example.models.Gate;
import org.example.models.ParkingLot;

import java.util.*;

public class ParkingLotRepository {
    private static ParkingLotRepository instance;
    private Map<Integer, ParkingLot> parkingLots;


    private ParkingLotRepository(){
    }
    public ParkingLot findParkingLotByGate(Gate gate){
        return null;
    }
    public static ParkingLotRepository getInstance(){
        if(instance == null){
            instance = new ParkingLotRepository();
        }
        return instance;
    }
    public boolean save(ParkingLot parkingLot){
        if(parkingLots == null){
            parkingLots = new TreeMap<>();
        }

        if(parkingLots.containsKey(parkingLot.getId())){
            return false;
        }
        parkingLots.put(parkingLot.getId(),parkingLot);
        return true;
    }

    public Optional<ParkingLot> getParkingLotById(String id) {
        Optional<ParkingLot> parkingLots = Optional.empty();
        ParkingLot parkingLot;
        return parkingLots;
    }
}
