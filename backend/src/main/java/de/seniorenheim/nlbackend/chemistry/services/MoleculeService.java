package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.MoleculeDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.Atom;
import de.seniorenheim.nlbackend.chemistry.database.entities.Molecule;
import de.seniorenheim.nlbackend.chemistry.database.entities.MoleculeAtomContainment;
import de.seniorenheim.nlbackend.chemistry.database.repositories.AtomRepo;
import de.seniorenheim.nlbackend.chemistry.database.repositories.MoleculeAtomContainmentRepo;
import de.seniorenheim.nlbackend.chemistry.database.repositories.MoleculeRepo;
import de.seniorenheim.nlbackend.utils.DTOConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MoleculeService {

    private final MoleculeRepo moleculeRepo;
    private final MoleculeAtomContainmentService moleculeAtomContainmentService;
    private final DTOConverter dtoConverter;
    private final AtomRepo atomRepo;
    private final MoleculeAtomContainmentRepo moleculeAtomContainmentRepo;

    public MoleculeService(MoleculeRepo moleculeRepo, MoleculeAtomContainmentService moleculeAtomContainmentService, DTOConverter dtoConverter, AtomRepo atomRepo, MoleculeAtomContainmentRepo moleculeAtomContainmentRepo) {
        this.moleculeRepo = moleculeRepo;
        this.moleculeAtomContainmentService = moleculeAtomContainmentService;
        this.dtoConverter = dtoConverter;
        this.atomRepo = atomRepo;
        this.moleculeAtomContainmentRepo = moleculeAtomContainmentRepo;
    }

    public MoleculeDTO save(MoleculeDTO moleculeDTO) {
        Molecule molecule = Molecule.builder()
                .name(moleculeDTO.getName())
                .build();

        molecule = moleculeRepo.save(molecule);

        List<MoleculeAtomContainment> containments = extractMoleculeAtomContainments(moleculeDTO, molecule);
        molecule.setMoleculeAtomContainments(containments);
        moleculeAtomContainmentRepo.saveAll(containments);

        molecule.setMolecularMass(calculateMolecularMass(molecule));
        molecule.setChemicalFormula(createChemicalFormula(molecule));

        return dtoConverter.convertToDTO(moleculeRepo.save(molecule));
    }

    @Transactional
    public MoleculeDTO update(long id, MoleculeDTO moleculeDTO) {
        Molecule molecule = moleculeRepo.findById(id);
        if (molecule == null) {
            return null;
        }

        List<MoleculeAtomContainment> containments = extractMoleculeAtomContainments(moleculeDTO, molecule);
        molecule.setMoleculeAtomContainments(containments);
        molecule.setMolecularMass(calculateMolecularMass(molecule));
        molecule.setChemicalFormula(createChemicalFormula(molecule));

        return dtoConverter.convertToDTO(moleculeRepo.save(molecule));
    }

    @Transactional
    public void delete(long id) {
        moleculeRepo.deleteById(id);
    }

    public List<MoleculeDTO> findAll() {
        return dtoConverter.convertList(moleculeRepo.findAll(), dtoConverter::convertToDTO);
    }

    public MoleculeDTO findById(long id) {
        return dtoConverter.convertToDTO(moleculeRepo.findById(id));
    }

    public MoleculeDTO findByName(String name) {
        return dtoConverter.convertToDTO(moleculeRepo.findByName(name));
    }

    private double calculateMolecularMass(Molecule molecule) {
        Map<String, Integer> map = moleculeAtomContainmentService.findByMoleculeOrderedByAtomSymbolASC(molecule);

        double result = 0.0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result += entry.getValue() * atomRepo.findBySymbol(entry.getKey()).getAtomicMass();
        }
        return result;
    }

    private String createChemicalFormula(Molecule molecule) {
        Map<String, Integer> map = moleculeAtomContainmentService.findByMoleculeOrderedByAtomSymbolASC(molecule);

        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result += entry.getKey() + (entry.getValue() >= 2 ? entry.getValue() : "") + "_";
        }
        return result.substring(0, result.length() - 1);
    }

    private List<MoleculeAtomContainment> extractMoleculeAtomContainments(MoleculeDTO moleculeDTO, Molecule molecule) {
        List<MoleculeAtomContainment> containments = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : moleculeDTO.getAtoms().entrySet()) {
            Atom atom = atomRepo.findBySymbol(entry.getKey());
            if (atom != null) {
                containments.add(MoleculeAtomContainment.builder()
                        .molecule(molecule)
                        .atom(atom)
                        .amount(entry.getValue())
                        .build());
            }
        }
        return containments;
    }
}