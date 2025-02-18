package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.entities.Atom;
import de.seniorenheim.nlbackend.chemistry.database.entities.Molecule;
import de.seniorenheim.nlbackend.chemistry.database.entities.MoleculeAtomContainment;
import de.seniorenheim.nlbackend.chemistry.database.repositories.MoleculeAtomContainmentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MoleculeAtomContainmentService {

    private final MoleculeAtomContainmentRepo moleculeAtomContainmentRepo;

    public MoleculeAtomContainmentService(MoleculeAtomContainmentRepo moleculeAtomContainmentRepo) {
        this.moleculeAtomContainmentRepo = moleculeAtomContainmentRepo;
    }

    @Transactional
    public MoleculeAtomContainment save(MoleculeAtomContainment moleculeAtomContainment) {

        for (MoleculeAtomContainment containment : findAll()) {
            if (containment.getMolecule().getName().equalsIgnoreCase(moleculeAtomContainment.getMolecule().getName())
                && containment.getAtom().getName().equalsIgnoreCase(moleculeAtomContainment.getAtom().getName())) {
                return containment;
            }
        }
        return moleculeAtomContainmentRepo.save(moleculeAtomContainment);
    }

    public List<MoleculeAtomContainment> findAll() {
        return moleculeAtomContainmentRepo.findAll();
    }

    public Map<Molecule, Integer> findByAtom(Atom atom) {
        Map<Molecule, Integer> map = new HashMap<>();
        for (MoleculeAtomContainment moleculeAtomContainment : moleculeAtomContainmentRepo.findByAtom(atom)) {
            map.put(moleculeAtomContainment.getMolecule(), moleculeAtomContainment.getAmount());
        }
        return map;
    }

    public Map<Atom, Integer> findByMolecule(Molecule molecule) {
        Map<Atom, Integer> map = new HashMap<>();
        for (MoleculeAtomContainment moleculeAtomContainment : moleculeAtomContainmentRepo.findByMolecule(molecule)) {
            map.put(moleculeAtomContainment.getAtom(), moleculeAtomContainment.getAmount());
        }
        return map;
    }

    public Map<Atom, Integer> findByMoleculeOrderedByAtomSymbolASC(Molecule molecule) {
        Map<Atom, Integer> map = new HashMap<>();
        for (MoleculeAtomContainment moleculeAtomContainment : moleculeAtomContainmentRepo.findByMoleculeOrderedByAtomSymbolASC(molecule)) {
            map.put(moleculeAtomContainment.getAtom(), moleculeAtomContainment.getAmount());
        }
        return map;
    }
}
