package de.seniorenheim.nlbackend.chemistry.database.repositories;

import de.seniorenheim.nlbackend.chemistry.database.entities.Molecule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoleculeRepo extends JpaRepository<Molecule, Long> {

    public Molecule findByName(String name);
    public Molecule findByChemicalFormula(String chemicalFormula);
}
