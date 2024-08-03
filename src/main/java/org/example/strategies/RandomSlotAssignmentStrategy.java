package org.example.strategies;

import org.example.models.*;

import java.util.Optional;

public class RandomSlotAssignmentStrategy implements SlotAssignMentStrategy{

    @Override
    public Optional<ParkingSlot> assignSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for(ParkingFloor parkingFloor:parkingLot.getParking_floors()){
            for(ParkingSlot parkingSlot:parkingFloor.getParkingSlots()){
                if(parkingSlot.getParkingSlotsStatus().equals(ParkingSlotStatus.AVAILABLE)
                        &&
                parkingSlot.getVehicleType().getVehicleType().equals(vehicleType)){
                    return Optional.of(parkingSlot);
                }
            }
        }
        return Optional.empty();
    }
}
