package de.seniorenheim.nlbackend.chemistry.database.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtomDTO {

    private long id;
    private String name;
    private String symbol;
    private double atomicMass;

    private AggregateStateDTO aggregateState;

    private AppearanceDTO appearance;

    private GroupDTO group;
    private long period;
}
