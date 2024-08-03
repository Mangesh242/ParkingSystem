package org.example.utils;

import org.example.models.Gate;
import org.example.models.ParkingLot;
import org.example.repositories.GateRepository;
import org.example.repositories.ParkingLotRepository;

public class Util {
    public static boolean addGate(Gate gte){
        GateRepository getre=GateRepository.getInstance();
        return getre.save(gte);
    }
    public static boolean addParkingLot(ParkingLot parkingLot){
        ParkingLotRepository parkingLotRepository=ParkingLotRepository.getInstance();
        parkingLotRepository.save(parkingLot);
        return true;
    }
}
