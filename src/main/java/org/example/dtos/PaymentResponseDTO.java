package org.example.dtos;

import org.example.models.PaymentMode;

public class PaymentResponseDTO {
    private PaymentMode paymentMode;
    private Float amount;

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
