package org.example.services;

import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.VehicleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BillService {
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private VehicleRepository vehicleRepository;

    public BillService(){
        this.gateRepository=GateRepository.getInstance();
        this.ticketRepository=TicketRepository.getInstance();
        this.vehicleRepository=VehicleRepository.getInstance();
    }

    public Bill generateBill(Integer ticketId,String exitGateNo){
        //Get the Current time
        Date date=new Date();
        Optional<Ticket> ticketOptional=ticketRepository.getTicket(ticketId);
        Ticket ticket;
        if(ticketOptional.isPresent()){
            ticket=ticketOptional.get();
        }else{
            throw new RuntimeException("No ticket found in repository");
        }
        Date entryTime=ticket.getEntryTime();
        Long durationInHr=(date.getTime()-entryTime.getTime())/(60*60*1000);
        Vehicle vehicle=ticket.getVehicle();
        VehicleType vehicleType=ticket.getVehicle().getVehicleType();
        Float price=0.0f;
        if(vehicleType.equals(VehicleType.TWO_WHEELER)) {
            if (durationInHr >= 0 && durationInHr <= 2) {
                if (durationInHr == 0) durationInHr = 1l;
                price += (durationInHr) * 20l;
            }
            else if(durationInHr>2 && durationInHr<=4){
                price += (durationInHr) * 25l;
            }
            else if(durationInHr>4 && durationInHr<=6){
                price+=(durationInHr)*30l;
            }else{
                price+=(durationInHr)*35l;
            }
        }
        else if(vehicleType.equals(VehicleType.FOUR_WHEELER)){
            if (durationInHr >= 0 && durationInHr <= 2) {
                if (durationInHr == 0) durationInHr = 1l;
                price += (durationInHr) * 25l;
            }
            else if(durationInHr>2 && durationInHr<=4){
                price += (durationInHr) * 30l;
            }
            else if(durationInHr>4 && durationInHr<=6){
                price+=(durationInHr)*35l;
            }else{
                price+=(durationInHr)*40l;
            }
        }
//
//        System.out.println(date);
//        System.out.println(price);

        //Get the exit gate object
        Gate exitGate;
        Optional<Gate> exitGateOptional=this.gateRepository.findGateByGateNumber(exitGateNo);
        if(exitGateOptional.isPresent()){
            exitGate=exitGateOptional.get();
        }else{
            throw  new RuntimeException("No exit gate found");
        }
        //Set every attribute of bill
        Bill bill=new Bill();
        bill.setAmount(price);
        bill.setGate(exitGate);
        bill.setExitDate(date);
        bill.setOperator(exitGate.getOperator());
        bill.setTicket(ticket);
        List<Payment> payments=new ArrayList<>();
        Float billDivide=price;
        Payment payment=new Payment();
        payment.setAmount(10f);
        billDivide=price - 10f;
        payment.setPaymentMode(PaymentMode.CASH);
        Payment payment1=new Payment();
        payment1.setAmount(billDivide);
        payment1.setPaymentMode(PaymentMode.UPI);
        payments.add(payment);
        payments.add(payment1);
        bill.setPayment(payments);

        return bill;
        //based on time and vehicleType generate bill.


    }
    //Rule
    /*
    Bill calculation for a vehicle depends upon to two things, time spent in the parking lot and the type of vehicle. Refer the below tables to understand pricing.
     For BIKEs: Hours spent Price per hour 0-2 20
                                           2-4 25
                                           4-6 30
                                           6 onwards 40

For CARs: Hours spent Price per hour 0-2 25
                                     2-4 30
                                     4-6 35
                                     6 onwards 45

For TRUCKs: Hours spent Price per hour 0-2 50 2-4 60 4-6 65 6 onwards 80

For eg. If a car spends 5.5 hours in the parking lot then their
        final bill will be: 2 * 25 (Charge for first 2 hours) + 2 * 30 (Charge for the next two hours i.e hour 3 and hour 4) + 2 * 35 (Charge for 5th hour and 6th hour
        (Note: even tough the vehicle was not in the parking lot for the entire hour,
 we charged it for the entire hour)) = Rs. 180 Note: This is one way of charging customers, in the future we might change this.
     */

}
