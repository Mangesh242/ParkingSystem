package org.example.controllers;

import org.example.dtos.IssueTicketRequestDTO;
import org.example.dtos.IssueTicketResponseDTO;
import org.example.dtos.ResponseStatus;
import org.example.models.Ticket;
import org.example.services.TicketServices;

public class TicketController {
    private TicketServices ticketServices;

    public int add(int no,int no2){
        return no+no2;
    }


    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO req){
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        try {
            //Do validation of request object
            //As request object will have lot of objects so we do not pass whole request DTO object everywhere.
            Ticket ticket = ticketServices.issueTicket(req.getGateID(),
                    req.getVehicleNumber(),
                    req.getOwnerName(),
                    req.getVehicleType());

            responseDTO.setTicketId(ticket.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e){
            responseDTO.setFailureMessage(e.getMessage());
        }

        return responseDTO;

    }
}


//Using model directly with client is not suggested.
//We need to transfer Data not models
//DTO : Data Transfer Objects