package org.example.repositories;

import org.example.models.Gate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GateRepository {
    private List<Gate> gates;
    private static GateRepository instance;
    private GateRepository(){}
    public static GateRepository getInstance() {
        if(instance==null)
            instance = new GateRepository();
        return instance;
    }
    public boolean save(Gate gate) {
        if(gates == null) {
            gates = new ArrayList<>();
        }
        for(Gate g : gates) {
            if(g.getId() == gate.getId()) {
                return false;
            }
        }
        gates.add(gate);
        return true;
    }
    public Optional<Gate> findGateById(int gateId){
        for (Gate gate : gates) {
            if(gate.getId() == gateId){
                return Optional.of(gate);
            }
        }
        return Optional.empty();
    }
}

//findGateById
// 'select * from gates where id = '5'
//date -> Object : ORM
//Heavy lifting  to convert and map to object attributes

