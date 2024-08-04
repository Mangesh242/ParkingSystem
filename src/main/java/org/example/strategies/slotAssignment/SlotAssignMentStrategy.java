package org.example.strategies.slotAssignment;

import org.example.models.ParkingLot;
import org.example.models.ParkingSlot;
import org.example.models.VehicleType;

import java.util.Optional;

public interface SlotAssignMentStrategy {
    public Optional<ParkingSlot> assignSlot(ParkingLot parkingLot, VehicleType vehicleType);
    //What all parameter require to assign slot ?
    //1.VehicleType
    //2.ParkingLot
    //3.
}
