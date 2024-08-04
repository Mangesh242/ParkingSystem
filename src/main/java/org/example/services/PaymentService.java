package org.example.services;

import org.example.models.Bill;
import org.example.models.Payment;
import org.example.models.PaymentMode;
import org.example.repositories.BillRepository;
import org.example.repositories.PaymentRepository;
import org.example.strategies.payment.PaymentStrategyFactory;
import org.example.strategies.payment.PaymentStrategy;

import java.util.Optional;

public class PaymentService {
    PaymentRepository paymentRepository;
    BillRepository billRepository;

    public PaymentService(){
        paymentRepository=PaymentRepository.getInstance();
        billRepository=BillRepository.getInstance();
    }

    public boolean makePayment(Integer billId, PaymentMode paymentMode,
                               Float amount){
        PaymentStrategy paymentStrategy= PaymentStrategyFactory.getPaymentStrategy(paymentMode);
        paymentStrategy.makePayment(amount);
        Payment payment=new Payment();
        payment.setPaymentMode(paymentMode);
        payment.setAmount(amount);
        Optional<Bill> billOptional=billRepository.getBill(billId);
        billOptional.ifPresent(payment::setBill);
        paymentRepository.savePayment(payment);

        return true;
    }
}
/*
  billDivide=price - 10f;
        payment.setPaymentMode(PaymentMode.CASH);

        Payment payment1=new Payment();
        payment1.setAmount(billDivide);
        payment1.setPaymentMode(PaymentMode.UPI);


        payments.add(payment);
        payments.add(payment1);
        bill.setPayment(payments);

 */