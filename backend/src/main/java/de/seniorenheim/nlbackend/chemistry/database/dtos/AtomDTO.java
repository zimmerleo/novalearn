package de.seniorenheim.nlbackend.chemistry.database.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AtomDTO {

    private long atomicNumber;
    private String name;
    private String symbol;
    private double atomicMass;

    private AggregateStateDTO aggregateState;

    private AppearanceDTO appearance;

    private GroupDTO group;
    private long period;
}
