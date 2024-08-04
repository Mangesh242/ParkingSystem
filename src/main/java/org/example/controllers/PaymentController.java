package org.example.controllers;

import org.example.dtos.PaymentRequestDTO;
import org.example.dtos.PaymentResponseDTO;
import org.example.models.Payment;
import org.example.repositories.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

public class PaymentController {
    PaymentRepository paymentRepository;
    public PaymentController(){
        paymentRepository=PaymentRepository.getInstance();
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
