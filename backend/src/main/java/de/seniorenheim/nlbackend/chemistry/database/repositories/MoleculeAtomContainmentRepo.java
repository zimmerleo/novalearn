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

    public List<MoleculeAtomContainment> findByAtom(Atom atom);
    public List<MoleculeAtomContainment> findByMolecule(Molecule molecule);

    @Query(value = "FROM MoleculeAtomContainment m WHERE m.molecule = ?1 ORDER BY m.atom.symbol")
    public List<MoleculeAtomContainment> findByMoleculeOrderedByAtomSymbolASC(Molecule molecule);
}
