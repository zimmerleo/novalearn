package de.seniorenheim.nlbackend.chemistry.database.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoleculeAtomContainmentDTO {

    private AtomDTO atom;
    private MoleculeDTO molecule;
    private int amount;
}
