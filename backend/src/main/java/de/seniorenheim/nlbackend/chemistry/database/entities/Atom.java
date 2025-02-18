package de.seniorenheim.nlbackend.chemistry.database.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chemistry_atoms")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atom {

    @Id
    private long atomicNumber;
    private String name;
    private String symbol;
    private double atomicMass;

    @ManyToOne
    @JoinColumn
    private AggregateState aggregateState;

    @ManyToOne
    @JoinColumn
    private Appearance appearance;

    @ManyToOne
    @JoinColumn
    private Group group;
    private long period;
}
