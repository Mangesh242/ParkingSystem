package org.example.repositories;

import org.example.models.Ticket;
import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Integer,Ticket> tickets;
    private static TicketRepository instance;
    private static int previousId=0;
    private TicketRepository() {

    }
    public static TicketRepository getInstance() {
        if (instance == null) {
            instance = new TicketRepository();
        }
        return instance;
    }

    public Ticket saveTicket(Ticket ticket) {
        previousId+=1;
        ticket.setId(previousId);
        if(tickets == null){
            tickets=new TreeMap<>();

        }

        tickets.put(previousId,ticket);
        return ticket;
    }
}
