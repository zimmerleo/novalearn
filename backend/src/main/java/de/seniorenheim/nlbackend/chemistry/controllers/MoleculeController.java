package de.seniorenheim.nlbackend.chemistry.controllers;

import de.seniorenheim.nlbackend.chemistry.database.dtos.AtomDTO;
import de.seniorenheim.nlbackend.chemistry.database.dtos.MoleculeDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.Molecule;
import de.seniorenheim.nlbackend.chemistry.services.MoleculeAtomContainmentService;
import de.seniorenheim.nlbackend.chemistry.services.MoleculeService;
import de.seniorenheim.nlbackend.utils.DTOConverter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/molecules")
public class MoleculeController {

    private final MoleculeService moleculeService;
    private final MoleculeAtomContainmentService moleculeAtomContainmentService;
    private final DTOConverter dtoConverter;

    public MoleculeController(MoleculeService moleculeService, MoleculeAtomContainmentService moleculeAtomContainmentService, DTOConverter dtoConverter) {
        this.moleculeService = moleculeService;
        this.moleculeAtomContainmentService = moleculeAtomContainmentService;
        this.dtoConverter = dtoConverter;
    }

    @GetMapping
    public List<MoleculeDTO> getMolecules() {
        return dtoConverter.convertList(moleculeService.findAll(), dtoConverter::convertToDTO);
    }

    @PostMapping
    public MoleculeDTO save(@RequestBody MoleculeDTO moleculeDTO) {
        return dtoConverter.convertToDTO(moleculeService.save(moleculeDTO));
    }

    @GetMapping("/id/{id}")
    public MoleculeDTO getMoleculeById(@PathVariable long id) {
        Molecule molecule = moleculeService.findById(id);
        return dtoConverter.convertToDTO(molecule);
    }

    @GetMapping("/id/{id}/atoms")
    public Map<String, Integer> getAtomsByMoleculeId(@PathVariable long id) {
        return dtoConverter.toJsonString(dtoConverter.convertMap(moleculeAtomContainmentService.findByMolecule(moleculeService.findById(id)), dtoConverter::convertToDTO));
    }
}
