package de.seniorenheim.nlbackend.chemistry.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chemistry_molecule_atom_containment")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoleculeAtomContainment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private Molecule molecule;

    @ManyToOne
    @JoinColumn
    private Atom atom;

    private int amount;
}
