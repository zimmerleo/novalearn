package de.seniorenheim.nlbackend.chemistry.database.repositories;

import de.seniorenheim.nlbackend.chemistry.database.entities.Atom;
import de.seniorenheim.nlbackend.chemistry.database.entities.Molecule;
import de.seniorenheim.nlbackend.chemistry.database.entities.MoleculeAtomContainment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoleculeAtomContainmentRepo extends JpaRepository<MoleculeAtomContainment, Long> {

    MoleculeAtomContainment findById(long id);

    @Query(value = "FROM MoleculeAtomContainment m WHERE m.atom = ?1 ORDER BY m.molecule.name")
    List<MoleculeAtomContainment> findByAtomOrderByMoleculeASC(Atom atom);

    @Query(value = "FROM MoleculeAtomContainment m WHERE m.molecule = ?1 ORDER BY m.atom.symbol")
    List<MoleculeAtomContainment> findByMoleculeOrderedByAtomSymbolASC(Molecule molecule);
}
