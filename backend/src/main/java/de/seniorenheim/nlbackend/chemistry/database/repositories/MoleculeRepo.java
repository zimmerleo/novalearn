package de.seniorenheim.nlbackend.chemistry.database.repositories;

import de.seniorenheim.nlbackend.chemistry.database.entities.Molecule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoleculeRepo extends JpaRepository<Molecule, Long> {

    public Molecule findById(long id);
    public Molecule findByName(String name);
}
