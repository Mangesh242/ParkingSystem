package org.example.services;

import org.example.models.Gate;
import org.example.models.Ticket;
import org.example.models.VehicleType;
import org.example.repositories.GateRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketServices {
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private VehicleRepository vehicleRepository;

    public TicketServices(GateRepository gateRepository, TicketRepository ticketRepository, VehicleRepository vehicleRepository) {
        this.gateRepository=gateRepository;
        this.ticketRepository=ticketRepository;
        this.vehicleRepository=vehicleRepository;

    }
    public Ticket issueTicket(int gateId,
                              String VehicleNumber,
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
        }else{
            throw new IllegalArgumentException("Gate not found");
        }
        ticket.setGate(gate);


        return ticket;
        //Steps :
        //1.Assigning slot
        //2.Return the data
    }

}


//Issue Ticket
//Controller : TicketController
//DTO's
//Services : Business logic will come
