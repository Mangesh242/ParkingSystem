package org.example.services;

import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.VehicleRepository;
import org.example.strategies.SlotAssignMentStrategy;
import org.example.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketServices {
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private VehicleRepository vehicleRepository;

    public TicketServices(
                         ) {
        this.gateRepository=GateRepository.getInstance();
        this.ticketRepository=TicketRepository.getInstance();
        this.vehicleRepository=VehicleRepository.getInstance();
    }
    public Optional<Ticket> getTicketById(int id){
        return ticketRepository.getTicket(id);
    }
    public Ticket issueTicket(int gateId,
                              String vehicleNumber,
                              String OwnerName,
                              VehicleType vehicleType) {
        //To create object of gate we need what all params
        //Properly create ticket object with require detail
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        //now set the gate repository
        Gate gate;
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isPresent()){
            gate=gateOptional.get();
        } else {
            throw new IllegalArgumentException("Gate not found");
        }
        ticket.setGate(gate);

        //get the parking slot //Assign Slot
        ParkingLot parkingLot = gate.getParkingLot();
        Optional<SlotAssignMentStrategy> slotASTOptional= SlotAssignmentStrategyFactory.getSlotAssignmentStrategy(parkingLot.getSlotAssignmentStrategyType());
        SlotAssignMentStrategy slotAST;
        if(slotASTOptional.isPresent()){
            slotAST=slotASTOptional.get();
        }else{
            throw new IllegalArgumentException("Slot assignment strategy not found");
        }

        Optional<ParkingSlot> parkingSlotOptional= slotAST.assignSlot(parkingLot,vehicleType);
        if(parkingSlotOptional.isPresent()){
            ParkingSlot parkingSlot = parkingSlotOptional.get();
            ticket.setParkingSlot(parkingSlot);
        }else{
            throw new IllegalArgumentException("Parking slot not found");
        }

        //Vehicle Assign to Ticket : check vehicle present in data otherwise save it
        Vehicle vehicle;
        Optional<Vehicle> optionalVehicle=vehicleRepository.findByVehicleNumber(vehicleNumber);
        if(!optionalVehicle.isPresent()){
                vehicle=new Vehicle();
                vehicle.setLicencePlateNumber(vehicleNumber);
                vehicle.setOwnerName(OwnerName);
                vehicle.setVehicleType(vehicleType);
                vehicleRepository.saveVehicle(vehicle);
        }else{
            vehicle=optionalVehicle.get();
        }
        ticket.setVehicle(vehicle);
        ticketRepository.saveTicket(ticket);
        return ticket;
        //Steps :
        //1.Assigning slot
        //2.Create strategy for that
        //3.Strategy means parking lot
            //3.1Either get parking lot via tricky process
        //3.2 Get the parking lot from customer
        //3.3 Have the parking lot reference in Gate, when you get the gate you get execution as well.
    }

}


//Issue Ticket
//Controller : TicketController
//DTO's
//Services : Business logic will come
