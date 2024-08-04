package org.example.repositories;

import org.example.models.Bill;
import org.example.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BillRepository {
    private static BillRepository instance;
    private BillRepository(){

    }
    public static BillRepository getInstance(){
        if(instance==null){
            instance=new BillRepository();
        }
        return instance;
    }

    Map<Integer, Bill> billRepository=new TreeMap<>();
    private static int id=111;

    public boolean saveBill(Bill bill){
        id++;
        bill.setId(id);
        billRepository.put(id,bill);
        return true;
    }
    public Optional<Bill> getBill(Integer billId){
        if(billRepository.containsKey(billId)){
            return Optional.of(billRepository.get(billId));
        }
        return Optional.empty();
    }
}
