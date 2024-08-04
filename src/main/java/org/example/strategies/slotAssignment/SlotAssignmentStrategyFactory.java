package org.example.strategies.slotAssignment;

import org.example.models.SlotAssignmentStrategyType;

import java.util.Optional;

public class SlotAssignmentStrategyFactory {

    public static Optional<SlotAssignMentStrategy> getSlotAssignmentStrategy(SlotAssignmentStrategyType type){
        if(type == SlotAssignmentStrategyType.RANDOM){
            return Optional.of(new RandomSlotAssignmentStrategy());
        }
        return Optional.empty();
    }
}
