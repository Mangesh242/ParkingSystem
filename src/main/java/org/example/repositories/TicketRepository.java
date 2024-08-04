package org.example.repositories;

import jdk.nashorn.internal.runtime.options.Option;
import org.example.models.Ticket;
import java.util.Map;
import java.util.Optional;
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
    public Optional<Ticket> getTicket(Integer id){
        if(tickets.containsKey(id)){
            return Optional.of(tickets.get(id));
        }
        return Optional.empty();
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
