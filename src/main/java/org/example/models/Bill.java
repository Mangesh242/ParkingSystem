package org.example.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private Date exitDate;
    private Float amount;
    private Gate gate;
    private Operator operator;
    private Ticket ticket;
    private List<Payment> payment;
    //Total Amount= Cash 30, UPI: 20

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }
}

/*
Bill calculation for a vehicle depends upon to two things, time spent in the parking lot and the type of vehicle. Refer the below tables to understand pricing.
For BIKEs: Hours spent Price per hour 0-2 20 2-4 25 4-6 30 6 onwards 40

For CARs: Hours spent Price per hour 0-2 25 2-4 30 4-6 35 6 onwards 45

For TRUCKs: Hours spent Price per hour 0-2 50 2-4 60 4-6 65 6 onwards 80

For eg. If a car spends 5.5 hours in the parking lot then their final bill will be: 2 * 25 (Charge for first 2 hours) + 2 * 30 (Charge for the next two hours i.e hour 3 and hour 4)
+ 2 * 35 (Charge for 5th hour and 6th hour (Note: even tough the vehicle was not in the parking lot for the entire hour, we charged it for the entire hour)) = Rs. 180
Note: This is one way of charging customers, in the future we might change this.

 */
