package org.example;

import org.example.controllers.TicketController;
import org.example.dtos.IssueTicketRequestDTO;
import org.example.dtos.IssueTicketResponseDTO;
import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.services.TicketServices;

public class Client
{
    public static void main(String[] args) {
        //Save all metadata to objects
        Gate gte=new Gate();
        Operator operator=new Operator();
        operator.setOperatorName("Sukh");
        operator.setId(1001);
        gte.setOperator(operator);
        gte.setId(1);
        gte.setGateNumber("1");
        gte.setGateType(GateType.ENTRY);
        gte.setGateStatus(GateStatus.OPEN);

        //
        GateRepository getre=GateRepository.getInstance();
        getre.save(gte);

        TicketController ticket=new TicketController(new TicketServices());
        IssueTicketRequestDTO req=new IssueTicketRequestDTO();
        req.setGateID(1);
        req.setOwnerName("Mangesh");
        req.setVehicleNumber("MH16CQ6604");
        req.setVehicleType(VehicleType.TWO_WHEELER);


        IssueTicketResponseDTO res=ticket.issueTicket(req);
        System.out.println(res.getResponseStatus());


    }
}

//Creation of ticket : CRUD : ticket
//TicketController

//Major crud operation will be happening on Ticket so we can name the thing
//as TicketController
