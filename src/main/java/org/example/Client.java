package org.example;

import org.example.controllers.BillController;
import org.example.controllers.PaymentController;
import org.example.controllers.TicketController;
import org.example.dtos.*;
import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.services.TicketServices;
import org.example.utils.Util;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) {
        //Save all metadata to objects
        Gate entryGate=new Gate();
        Operator operator=new Operator();
        operator.setOperatorName("Sukh");
        operator.setId(1001);
        entryGate.setOperator(operator);
        entryGate.setId(1);
        entryGate.setGateNumber("1");
        entryGate.setGateType(GateType.ENTRY);
        entryGate.setGateStatus(GateStatus.OPEN);


        Gate exitGate=new Gate();
        Operator operatorExit=new Operator();
        operatorExit.setOperatorName("Dukh");
        operatorExit.setId(1002);
        exitGate.setOperator(operatorExit);
        exitGate.setId(2);
        exitGate.setGateNumber("2");
        exitGate.setGateType(GateType.EXIT);
        exitGate.setGateStatus(GateStatus.OPEN);

        ParkingLot parkingLot=new ParkingLot();
        parkingLot.setName("Danger");
        parkingLot.setFloors(1);
        parkingLot.setId(10001);
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setSlotAssignmentStrategyType(SlotAssignmentStrategyType.RANDOM);

        //Set parking floors
        List<ParkingFloor> parkingFloors=new ArrayList<>();

        ParkingFloor parkingFloor=new ParkingFloor();
        parkingFloor.setFloorNumber("D01");
        //Set parking Slot
        List<ParkingSlot> parkingSlotsList=new ArrayList<>();
        ParkingSlot parkingSlot=new ParkingSlot();
        parkingSlot.setSlotNumber("1");
        parkingSlot.setParkingSlotsStatus(ParkingSlotStatus.AVAILABLE);
        SupportedVehicleType vehicleType=new SupportedVehicleType();
        vehicleType.setVehicleType(VehicleType.TWO_WHEELER);
        parkingSlot.setVehicleTypes(vehicleType);
        parkingSlotsList.add(parkingSlot);

        parkingFloor.setParkingSlots(parkingSlotsList);
        parkingFloor.setParkingFloorStatus(ParkingFloorStatus.OPEN);
        List<SupportedVehicleType> vehicleTypes=new ArrayList<>();
        vehicleTypes.add(vehicleType);
        parkingFloor.setVehicleTypes(vehicleTypes);

        parkingFloors.add(parkingFloor);

        parkingLot.setParking_floors(parkingFloors);
        List<Gate> entryGates=new ArrayList<>();
        entryGates.add(entryGate);
        List<Gate> exitGates=new ArrayList<>();
        exitGates.add(exitGate);
        parkingLot.setEntryGates(entryGates);
        parkingLot.setExitGates(exitGates);
        parkingLot.setVehicleTypes(vehicleTypes);

        entryGate.setParkingLot(parkingLot);
        exitGate.setParkingLot(parkingLot);
        //Save all data to repo's
        Util.addGate(entryGate);
        Util.addGate(exitGate);
        Util.addParkingLot(parkingLot);

        TicketController ticketCtrl=new TicketController(new TicketServices());
        IssueTicketRequestDTO req=new IssueTicketRequestDTO();
        req.setGateID(1);
        req.setOwnerName("Mangesh");
        req.setVehicleNumber("MH16CQ6604");
        req.setVehicleType(VehicleType.TWO_WHEELER);


        IssueTicketResponseDTO responseDTOTicket=ticketCtrl.issueTicket(req);
        System.out.println("*** Akash Parking System ***");
        if(responseDTOTicket.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println("-------------------------------------");
            System.out.println("Ticket : ");
            System.out.println("Ticket Id: "+responseDTOTicket.getTicketId());
            System.out.println("Entry Time: "+responseDTOTicket.getEntryTime());
            System.out.println("Parking Slot: "+responseDTOTicket.getSlotNumber());
            System.out.println("-------------------------------------");

        }else{
            System.out.println("Not able to create Ticket :"+responseDTOTicket.getFailureMessage());
        }

        //Generate Bill
        int ticketId=responseDTOTicket.getTicketId();

        BillRequestDTO billRequestDTO=new BillRequestDTO();
        billRequestDTO.setTicketId(ticketId);
        billRequestDTO.setExitGateNo("2");
        BillController billCtrl=new BillController();
        BillResponseDTO  responseDTO=billCtrl.generateBill(billRequestDTO);
        if(responseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)) {
            System.out.println("\n\n\n******Parking Bill:******");
            System.out.println("1.Gate No : " + responseDTO.getGateNumber());
            System.out.println("2.Amount : " + responseDTO.getAmount());
            System.out.println("3.Vehicle Number : " + responseDTO.getVehicleNumber());
            System.out.println("********* Payment ***********");
            //User will have to make payment,
            //He will ask i would like to pay in 2 modes, 1.Cash : 10Rs 2.UPI :10Rs
            Float billAmount=responseDTO.getAmount();
            List<PaymentResponseDTO> paymentsDTO=new ArrayList<>();
            PaymentController paymentController=new PaymentController();
            PaymentRequestDTO paymentRequestDTO=new PaymentRequestDTO();
            paymentRequestDTO.setBillId(responseDTO.getBill().getId());
            paymentRequestDTO.setPaymentMode(PaymentMode.CASH);
            paymentRequestDTO.setAmount(10f);
            billAmount=billAmount-10f;

            PaymentResponseDTO paymentResponse=paymentController.makePayment(paymentRequestDTO);
            PaymentRequestDTO paymentRequestDTO1=new PaymentRequestDTO();
            paymentRequestDTO1.setAmount(billAmount);
            paymentRequestDTO1.setPaymentMode(PaymentMode.UPI);
            paymentRequestDTO1.setBillId(responseDTO.getBill().getId());

            paymentsDTO.add(paymentResponse);
            paymentsDTO.add(paymentController.makePayment(paymentRequestDTO1));

            System.out.println("Amount received from customer is : ");
            System.out.println("-------------------------------------");
            for(PaymentResponseDTO payment:paymentsDTO){
                System.out.println(payment.getPaymentMode()+" : "+payment.getAmount()+"/-");
            }
            System.out.println("-------------------------------------");
            System.out.println("Total Receipt : "+responseDTO.getAmount()+"/-");
        }
        else
        {
            System.out.println("Fail to Generate the bill.");
        }









    }
}

//Creation of ticket : CRUD : ticket
//TicketController

//Major crud operation will be happening on Ticket so we can name the thing
//as TicketController
