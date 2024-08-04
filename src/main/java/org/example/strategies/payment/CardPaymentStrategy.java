package org.example.strategies.payment;

public class CardPaymentStrategy implements PaymentStrategy{

    @Override
    public boolean makePayment(Float amount) {
        System.out.println(amount+"/- Amount accepted using Card");
        return true;
    }
}
