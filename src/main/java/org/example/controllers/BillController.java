package org.example.controllers;

import org.example.dtos.BillRequestDTO;
import org.example.dtos.BillResponseDTO;
import org.example.dtos.ResponseStatus;
import org.example.models.Bill;
import org.example.services.BillService;
import org.example.services.TicketServices;

public class BillController {
    public BillResponseDTO generateBill(BillRequestDTO billRequestDTO){
      BillResponseDTO responseDTO=new BillResponseDTO();
      BillService billService= new BillService();
      try {
          Bill bill = billService.generateBill(billRequestDTO.getTicketId(),billRequestDTO.getExitGateNo());
          responseDTO.setAmount(bill.getAmount());
          responseDTO.setGateNumber(bill.getGate().getGateNumber());
          responseDTO.setResponseStatus(ResponseStatus.SUCCESS);


      }catch (Exception e){
          responseDTO.setResponseStatus(ResponseStatus.FAIL);
      }
      return responseDTO;

    }
}
