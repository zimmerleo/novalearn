package de.seniorenheim.nlbackend.chemistry.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "chemistry_atoms")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atom {

    @Id
    private long id;
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

    @OneToMany(mappedBy = "atom")
    private List<MoleculeAtomContainment> moleculeAtomContainments;
}
