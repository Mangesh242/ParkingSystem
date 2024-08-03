package org.example.repositories;

import org.example.models.ParkingLots;
import org.example.models.ParkingSlots;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotRepository {
    private static ParkingLotRepository instance;
    private List<ParkingLots> parkingLots;

    private ParkingLotRepository(){

    }
    public static ParkingLotRepository getInstance(){
        if(instance == null){
            instance = new ParkingLotRepository();
        }
        return instance;
    }
    private boolean save(ParkingLots parkingLot){
        if(parkingLots == null){
            parkingLots = new ArrayList<>();
        }

        for(ParkingLots plot : parkingLots){
            if(plot.getId() == parkingLot.getId()){
                return false;
            }
        }
        parkingLots.add(parkingLot);

    }

    public Optional<ParkingLots> getParkingLotById(String id) {
        Optional<ParkingLots> parkingLots = Optional.empty();
        ParkingLots parkingLot;
        return parkingLots;
    }
}
