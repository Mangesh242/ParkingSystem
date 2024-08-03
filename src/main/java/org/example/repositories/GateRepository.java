package org.example.repositories;

import org.example.models.Gate;

import java.util.*;

public class GateRepository {
    private Map<Integer,Gate> gates=new TreeMap<>();

    private static GateRepository instance;
    private GateRepository(){}
    public static GateRepository getInstance() {
        if(instance==null)
            instance = new GateRepository();
        return instance;
    }
    public boolean save(Gate gate) {
        if(gates.containsKey(gate.getId())){
            return false;
        }
        gates.put(gate.getId(), gate);
        return  true;
    }
    public Optional<Gate> findGateById(int gateId){
        if(gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }
}

//findGateById
// 'select * from gates where id = '5'
//date -> Object : ORM
//Heavy lifting  to convert and map to object attributes

