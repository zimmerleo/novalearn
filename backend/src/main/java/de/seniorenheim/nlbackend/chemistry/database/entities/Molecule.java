package de.seniorenheim.nlbackend.chemistry.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "chemistry_molecules")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Molecule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private String chemicalFormula;
    private double molecularMass;

    @OneToMany(mappedBy = "molecule", cascade = CascadeType.ALL)
    private List<MoleculeAtomContainment> moleculeAtomContainments;
}
