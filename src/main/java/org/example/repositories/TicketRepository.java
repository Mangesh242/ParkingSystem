package org.example.repositories;

public class TicketRepository {
    private static TicketRepository instance;
    private TicketRepository() {

    }
    public static TicketRepository getInstance() {
        if (instance == null) {
            instance = new TicketRepository();
        }
        return instance;
    }
}
