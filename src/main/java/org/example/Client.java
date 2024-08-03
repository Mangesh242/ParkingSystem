package org.example;

import org.example.controllers.TicketController;
import org.example.dtos.IssueTicketRequestDTO;
import org.example.dtos.IssueTicketResponseDTO;
import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.services.TicketServices;
import org.example.utils.Util;

import java.util.ArrayList;
import java.util.List;

public class Client
{
    public static void main(String[] args) {
        //Save all metadata to objects
        Gate entryGate=new Gate();
        Operator operator=new Operator();
        operator.setOperatorName("Sukh");
        operator.setId(1001);
        entryGate.setOperator(operator);
        entryGate.setId(1);
        entryGate.setGateNumber("1");
        entryGate.setGateType(GateType.ENTRY);
        entryGate.setGateStatus(GateStatus.OPEN);


        Gate exitGate=new Gate();
        Operator operatorExit=new Operator();
        operatorExit.setOperatorName("Dukh");
        operatorExit.setId(1002);
        exitGate.setOperator(operatorExit);
        exitGate.setId(2);
        exitGate.setGateNumber("2");
        exitGate.setGateType(GateType.EXIT);
        exitGate.setGateStatus(GateStatus.OPEN);

        ParkingLot parkingLot=new ParkingLot();
        parkingLot.setName("Danger");
        parkingLot.setFloors(1);
        parkingLot.setId(10001);
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setSlotAssignmentStrategyType(SlotAssignmentStrategyType.RANDOM);

        //Set parking floors
        List<ParkingFloor> parkingFloors=new ArrayList<>();

        ParkingFloor parkingFloor=new ParkingFloor();
        parkingFloor.setFloorNumber("D01");
        //Set parking Slot
        List<ParkingSlot> parkingSlotsList=new ArrayList<>();
        ParkingSlot parkingSlot=new ParkingSlot();
        parkingSlot.setSlotNumber("1");
        parkingSlot.setParkingSlotsStatus(ParkingSlotStatus.AVAILABLE);
        SupportedVehicleType vehicleType=new SupportedVehicleType();
        vehicleType.setVehicleType(VehicleType.TWO_WHEELER);
        parkingSlot.setVehicleTypes(vehicleType);
        parkingSlotsList.add(parkingSlot);

        parkingFloor.setParkingSlots(parkingSlotsList);
        parkingFloor.setParkingFloorStatus(ParkingFloorStatus.OPEN);
        List<SupportedVehicleType> vehicleTypes=new ArrayList<>();
        vehicleTypes.add(vehicleType);
        parkingFloor.setVehicleTypes(vehicleTypes);

        parkingFloors.add(parkingFloor);

        parkingLot.setParking_floors(parkingFloors);
        List<Gate> entryGates=new ArrayList<>();
        entryGates.add(entryGate);
        List<Gate> exitGates=new ArrayList<>();
        exitGates.add(exitGate);
        parkingLot.setEntryGates(entryGates);
        parkingLot.setExitGates(exitGates);
        parkingLot.setVehicleTypes(vehicleTypes);

        entryGate.setParkingLot(parkingLot);
        exitGate.setParkingLot(parkingLot);
        //Save all data to repo's
        Util.addGate(entryGate);
        Util.addGate(exitGate);
        Util.addParkingLot(parkingLot);

        TicketController ticket=new TicketController(new TicketServices());
        IssueTicketRequestDTO req=new IssueTicketRequestDTO();
        req.setGateID(1);
        req.setOwnerName("Mangesh");
        req.setVehicleNumber("MH16CQ6604");
        req.setVehicleType(VehicleType.TWO_WHEELER);


        IssueTicketResponseDTO res=ticket.issueTicket(req);
        System.out.println(res.getResponseStatus());

        //Generate Bill





    }
}

//Creation of ticket : CRUD : ticket
//TicketController

//Major crud operation will be happening on Ticket so we can name the thing
//as TicketController
