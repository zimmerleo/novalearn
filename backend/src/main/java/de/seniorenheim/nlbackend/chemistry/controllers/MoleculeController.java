package de.seniorenheim.nlbackend.chemistry.controllers;

import de.seniorenheim.nlbackend.chemistry.database.dtos.MoleculeDTO;
import de.seniorenheim.nlbackend.chemistry.services.MoleculeAtomContainmentService;
import de.seniorenheim.nlbackend.chemistry.services.MoleculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/molecules")
public class MoleculeController {

    private final MoleculeService moleculeService;
    private final MoleculeAtomContainmentService moleculeAtomContainmentService;

    public MoleculeController(MoleculeService moleculeService, MoleculeAtomContainmentService moleculeAtomContainmentService) {
        this.moleculeService = moleculeService;
        this.moleculeAtomContainmentService = moleculeAtomContainmentService;
    }

    @PostMapping
    public MoleculeDTO save(@RequestBody MoleculeDTO moleculeDTO) {
        return moleculeService.save(moleculeDTO);
    }

    @PutMapping("/id/{id}")
    public MoleculeDTO update(@PathVariable long id, @RequestBody MoleculeDTO moleculeDTO) {
        return moleculeService.update(id, moleculeDTO);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable long id) {
        moleculeService.delete(id);
    }

    @GetMapping
    public List<MoleculeDTO> findAll() {
        return moleculeService.findAll();
    }

    @GetMapping("/id/{id}")
    public MoleculeDTO findById(@PathVariable long id) {
        return moleculeService.findById(id);
    }

    @GetMapping("/name/{name}")
    public MoleculeDTO findById(@PathVariable String name) {
        return moleculeService.findByName(name);
    }

    @GetMapping("/id/{id}/atoms")
    public Map<String, Integer> getAtomsByMoleculeId(@PathVariable long id) {
        return moleculeAtomContainmentService.findByMoleculeIdOrderedByAtomSymbolASC(id);
    }
}
