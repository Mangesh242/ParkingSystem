package org.example.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private Date exitDate;
    private int amount;
    private Gate gate;
    private Operator operator;
    private Ticket ticket;
    private List<Payment> payment;
    //Total Amount= Cash 30, UPI: 20

}
