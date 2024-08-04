package org.example.strategies.payment;

import org.example.models.PaymentMode;

public class PaymentStrategyFactory {
    public static PaymentStrategy getPaymentStrategy(PaymentMode mode){
        if(mode.equals(PaymentMode.CASH)){
            return new CashPaymentStrategy();
        }
        else if(mode.equals(PaymentMode.CARD)){
            return new CardPaymentStrategy();
        }
        else if(mode.equals(PaymentMode.UPI)){
            return new UPIPaymentStrategy();
        }
        else{
            throw new RuntimeException("Payment Strategy not found");
        }
    }
}
