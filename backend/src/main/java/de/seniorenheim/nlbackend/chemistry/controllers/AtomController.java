package de.seniorenheim.nlbackend.chemistry.controllers;

import de.seniorenheim.nlbackend.chemistry.database.dtos.AtomDTO;
import de.seniorenheim.nlbackend.chemistry.database.dtos.MoleculeDTO;
import de.seniorenheim.nlbackend.chemistry.services.AtomService;
import de.seniorenheim.nlbackend.chemistry.services.MoleculeAtomContainmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/atoms")
public class AtomController {

    private final AtomService atomService;
    private final MoleculeAtomContainmentService moleculeAtomContainmentService;

    public AtomController(AtomService atomService, MoleculeAtomContainmentService moleculeAtomContainmentService) {
        this.atomService = atomService;
        this.moleculeAtomContainmentService = moleculeAtomContainmentService;
    }

    @GetMapping
    public List<AtomDTO> getAtoms() {
        return atomService.findAll();
    }

    @PostMapping
    public AtomDTO saveAtom(@RequestBody AtomDTO atomDTO) {
        return atomService.save(atomDTO);
    }

    @PutMapping("/id/{id}")
    public AtomDTO update(@PathVariable long id, @RequestBody AtomDTO atomDTO) {
        return atomService.update(id, atomDTO);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable long id) {
        atomService.delete(id);
    }

    @GetMapping("/id/{id}")
    public AtomDTO getAtomById(@PathVariable long id) {
        return atomService.findById(id);
    }

    @GetMapping("/symbol/{symbol}")
    public AtomDTO getAtomBySymbol(@PathVariable String symbol) {
        return atomService.findBySymbol(symbol);
    }

    @GetMapping("/id/{id}/shells")
    public List<Long> getAtomShellsById(@PathVariable long id) {
        return atomService.getAtomShells(id);
    }

    @GetMapping("/symbol/{symbol}/shells")
    public List<Long> getAtomShellsBySymbol(@PathVariable String symbol) {
        return atomService.getAtomShells(symbol);
    }

    @GetMapping("/id/{id}/valenceShellElectronCount")
    public long getValenceShellElectronCount(@PathVariable long id) {
        return atomService.getValenceShellElectronCount(id);
    }

    @GetMapping("/symbol/{symbol}/valenceShellElectronCount")
    public long getValenceShellElectronCount(@PathVariable String symbol) {
        return atomService.getValenceShellElectronCount(symbol);
    }

    @GetMapping("/id/{id}/molecules")
    public Map<String, Integer> getMoleculesByAtomId(@PathVariable long id) {
        return moleculeAtomContainmentService.findByAtomOrderByMoleculeASC(id);
    }
}
