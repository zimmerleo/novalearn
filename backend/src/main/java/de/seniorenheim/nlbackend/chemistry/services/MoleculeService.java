package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.AtomDTO;
import de.seniorenheim.nlbackend.chemistry.database.dtos.MoleculeDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.Atom;
import de.seniorenheim.nlbackend.chemistry.database.entities.Molecule;
import de.seniorenheim.nlbackend.chemistry.database.entities.MoleculeAtomContainment;
import de.seniorenheim.nlbackend.chemistry.database.repositories.MoleculeRepo;
import de.seniorenheim.nlbackend.utils.DTOConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MoleculeService {

    private final MoleculeRepo moleculeRepo;
    private final MoleculeAtomContainmentService moleculeAtomContainmentService;
    private final DTOConverter dtoConverter;

    public MoleculeService(MoleculeRepo moleculeRepo, MoleculeAtomContainmentService moleculeAtomContainmentService, DTOConverter dtoConverter) {
        this.moleculeRepo = moleculeRepo;
        this.moleculeAtomContainmentService = moleculeAtomContainmentService;
        this.dtoConverter = dtoConverter;
    }

    @Transactional
    public Molecule save(MoleculeDTO moleculeDTO) {

        for (Molecule mol : findAll()) {
            if (mol.getName().equalsIgnoreCase(moleculeDTO.getName())) {
                return mol;
            }
        }

        Molecule molecule = Molecule.builder()
                .name(moleculeDTO.getName())
                .build();

        molecule = moleculeRepo.save(molecule);

        for (Map.Entry<AtomDTO, Integer> entry : moleculeDTO.getAtoms().entrySet()) {
            moleculeAtomContainmentService.save(
                    MoleculeAtomContainment.builder()
                        .molecule(molecule)
                        .atom(dtoConverter.convertToEntity(entry.getKey()))
                        .amount(entry.getValue())
                    .build()
            );
        }

        molecule.setMolecularMass(calculateMolecularMass(molecule));
        molecule.setChemicalFormula(createChemicalFormula(molecule));

        return moleculeRepo.save(molecule);
    }

    public List<Molecule> findAll() {
        return moleculeRepo.findAll();
    }

    public Molecule findById(long id) {
        return moleculeRepo.findById(id).orElse(null);
    }

    public Molecule findByName(String name) {
        return moleculeRepo.findByName(name);
    }

    public Molecule findByChemicalFormula(String chemicalFormula) {
        return moleculeRepo.findByChemicalFormula(chemicalFormula);
    }

    private double calculateMolecularMass(Molecule molecule) {
        Map<Atom, Integer> map = moleculeAtomContainmentService.findByMolecule(molecule);

        double result = 0.0;
        for (Map.Entry<Atom, Integer> entry : map.entrySet()) {
            result += entry.getValue() * entry.getKey().getAtomicMass();
        }
        return result;
    }

    private String createChemicalFormula(Molecule molecule) {
        Map<Atom, Integer> map = moleculeAtomContainmentService.findByMoleculeOrderedByAtomSymbolASC(molecule);

        String result = "";
        for (Map.Entry<Atom, Integer> entry : map.entrySet()) {
            result += entry.getKey().getSymbol() + (entry.getValue() >= 2 ? entry.getValue() : "") + "_";
        }
        return result.substring(0, result.length() - 1);
    }

    public void delete(long id) {
        moleculeRepo.deleteById(id);
    }
}