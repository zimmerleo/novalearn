package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.MoleculeAtomContainmentDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.Molecule;
import de.seniorenheim.nlbackend.chemistry.database.entities.MoleculeAtomContainment;
import de.seniorenheim.nlbackend.chemistry.database.repositories.AtomRepo;
import de.seniorenheim.nlbackend.chemistry.database.repositories.MoleculeAtomContainmentRepo;
import de.seniorenheim.nlbackend.chemistry.database.repositories.MoleculeRepo;
import de.seniorenheim.nlbackend.utils.DTOConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MoleculeAtomContainmentService {

    private final MoleculeAtomContainmentRepo moleculeAtomContainmentRepo;
    private final DTOConverter dtoConverter;
    private final MoleculeRepo moleculeRepo;
    private final AtomRepo atomRepo;

    public MoleculeAtomContainmentService(MoleculeAtomContainmentRepo moleculeAtomContainmentRepo, DTOConverter dtoConverter, MoleculeRepo moleculeRepo, AtomRepo atomRepo, AtomRepo atomRepo1) {
        this.moleculeAtomContainmentRepo = moleculeAtomContainmentRepo;
        this.dtoConverter = dtoConverter;
        this.moleculeRepo = moleculeRepo;
        this.atomRepo = atomRepo;
    }

    @Transactional
    public MoleculeAtomContainmentDTO save(MoleculeAtomContainmentDTO moleculeAtomContainmentDTO) {
        MoleculeAtomContainment moleculeAtomContainment = MoleculeAtomContainment.builder()
                .amount(moleculeAtomContainmentDTO.getAmount())
                .build();

        return dtoConverter.convertToDTO(moleculeAtomContainmentRepo.save(moleculeAtomContainment));
    }

    @Transactional
    public MoleculeAtomContainmentDTO update(long id, int amount) {
        MoleculeAtomContainment moleculeAtomContainment = moleculeAtomContainmentRepo.findById(id);
        if (moleculeAtomContainment == null) {
            return null;
        }
        moleculeAtomContainment.setAmount(amount);
        return dtoConverter.convertToDTO(moleculeAtomContainmentRepo.save(moleculeAtomContainment));
    }

    @Transactional
    public void delete(long id) {
        moleculeAtomContainmentRepo.delete(moleculeAtomContainmentRepo.findById(id));
    }

    public List<MoleculeAtomContainmentDTO> findAll() {
        return dtoConverter.convertList(moleculeAtomContainmentRepo.findAll(), dtoConverter::convertToDTO);
    }

    public MoleculeAtomContainmentDTO findById(long id) {
        return dtoConverter.convertToDTO(moleculeAtomContainmentRepo.findById(id));
    }

    public Map<String, Integer> findByAtomOrderByMoleculeASC(long atomId) {
        Map<String, Integer> map = new HashMap<>();
        for (MoleculeAtomContainment moleculeAtomContainment : moleculeAtomContainmentRepo.findByAtomOrderByMoleculeASC(atomRepo.findById(atomId))) {
            map.put(moleculeAtomContainment.getMolecule().getChemicalFormula(), moleculeAtomContainment.getAmount());
        }
        return map;
    }

    public Map<String, Integer> findByMoleculeIdOrderedByAtomSymbolASC(long moleculeId) {
        Map<String, Integer> map = new HashMap<>();
        List<MoleculeAtomContainment> containments = moleculeAtomContainmentRepo.findByMoleculeOrderedByAtomSymbolASC(moleculeRepo.findById(moleculeId));
        for (MoleculeAtomContainment moleculeAtomContainment : containments) {
            map.put(moleculeAtomContainment.getAtom().getSymbol(), moleculeAtomContainment.getAmount());
        }
        return map;
    }

    public Map<String, Integer> findByMoleculeOrderedByAtomSymbolASC(Molecule molecule) {
        Map<String, Integer> map = new HashMap<>();
        for (MoleculeAtomContainment moleculeAtomContainment : moleculeAtomContainmentRepo.findByMoleculeOrderedByAtomSymbolASC(molecule)) {
            map.put(moleculeAtomContainment.getAtom().getSymbol(), moleculeAtomContainment.getAmount());
        }
        return map;
    }
}
