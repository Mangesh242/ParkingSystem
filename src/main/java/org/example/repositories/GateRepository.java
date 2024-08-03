package org.example.repositories;

import org.example.models.Gate;

import java.util.Optional;

public class GateRepository {
    public Optional<Gate> findGateById(int gateId){
        return Optional.empty();
    }
}

//findGateById
// 'select * from gates where id = '5'
//date -> Object : ORM
//Heavy lifting  to convert and map to object attributes

