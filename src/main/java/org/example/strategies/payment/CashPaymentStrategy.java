package org.example.strategies.payment;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean makePayment(Float amount) {
        System.out.println(amount+"/- Amount accepted using Cash");
        return true;
    }
}
