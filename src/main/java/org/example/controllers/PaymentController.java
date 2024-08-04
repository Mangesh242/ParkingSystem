package org.example.controllers;

import org.example.dtos.PaymentRequestDTO;
import org.example.dtos.PaymentResponseDTO;
import org.example.dtos.ResponseStatus;
import org.example.models.Payment;
import org.example.repositories.PaymentRepository;
import org.example.services.PaymentService;

import java.util.ArrayList;
import java.util.List;

public class PaymentController {
    PaymentRepository paymentRepository;
    public PaymentController(){
        paymentRepository=PaymentRepository.getInstance();
    }

    public PaymentResponseDTO makePayment(PaymentRequestDTO paymentRequestDTO){
        PaymentService paymentService=new PaymentService();
        paymentService.makePayment(paymentRequestDTO.getBillId(),
                paymentRequestDTO.getPaymentMode(),
                paymentRequestDTO.getAmount());
        //if payment successful return true
        PaymentResponseDTO responseDTO=new PaymentResponseDTO();
        responseDTO.setAmount(paymentRequestDTO.getAmount());
        responseDTO.setPaymentMode(paymentRequestDTO.getPaymentMode());
        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        return responseDTO;
        //Otherwise you can return false
    }

    public List<PaymentResponseDTO> getPayments(PaymentRequestDTO paymentRequestDTO){
        //get payments list from payment repository
        List<Payment> payments=paymentRepository.getPaymentsByBillId(paymentRequestDTO.getBillId());
        List<PaymentResponseDTO> paymentResponseDTOS=new ArrayList<>();
        if(payments.size()==0){
            System.out.println("No Payments found...");
        }
        for(Payment payment:payments){
            PaymentResponseDTO paymentResponseDTO=new PaymentResponseDTO();
            paymentResponseDTO.setPaymentMode(payment.getPaymentMode());
            paymentResponseDTO.setAmount(payment.getAmount());
            paymentResponseDTOS.add(paymentResponseDTO);
        }
        return paymentResponseDTOS;
    }
}
