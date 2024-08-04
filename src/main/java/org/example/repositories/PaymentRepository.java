package org.example.repositories;
import org.example.models.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PaymentRepository {
    Map<Integer,Payment> paymentRepo=new TreeMap<>();
    private static int id=1111;
    private static PaymentRepository instance;
    private PaymentRepository(){

    }
    public static PaymentRepository getInstance(){
        if(instance==null){
            instance=new PaymentRepository();
        }
        return instance;
    }
    public boolean savePayment(Payment payment){
        id++;
        payment.setId(id);
        paymentRepo.put(id,payment);
        return false;
    }
    public List<Payment> getPaymentsByBillId(Integer billId){
        List<Payment> payments=new ArrayList<>();
        for(Integer key:paymentRepo.keySet())
        {
            if(paymentRepo.get(key).getBill().getId()==billId){
                payments.add(paymentRepo.get(key));
            }
        }
        return payments;
    }
}
