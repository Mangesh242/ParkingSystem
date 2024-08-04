package org.example.strategies.payment;

public class UPIPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean makePayment(Float amount) {
        System.out.println(amount+"/- Amount accepted using UPI");
        return true;
    }
}
