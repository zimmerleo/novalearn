package de.seniorenheim.nlbackend.chemistry.controllers;

import de.seniorenheim.nlbackend.chemistry.database.dtos.AtomDTO;
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
    public List<AtomDTO> findAtoms() {
        return atomService.findAll();
    }
    
    @GetMapping("/aggregatestate/{id}")
    public List<AtomDTO> findAtomsByAggregateStateId(@PathVariable long id) {
        return atomService.findAllByAggregateStateId(id);
    }

    @GetMapping("/appearance/{id}")
    public List<AtomDTO> findAtomsByAppearanceId(@PathVariable long id) {
        return atomService.findAllByAppearanceId(id);
    }

    @GetMapping("/group/{id}")
    public List<AtomDTO> findAtomsByGroupId(@PathVariable long id) {
        return atomService.findAllByGroupId(id);
    }

    @GetMapping("/period/{id}")
    public List<AtomDTO> findAtomsByPeriod(@PathVariable long id) {
        return atomService.findAllByPeriod(id);
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
    public AtomDTO findAtomById(@PathVariable long id) {
        return atomService.findById(id);
    }

    @GetMapping("/symbol/{symbol}")
    public AtomDTO findAtomBySymbol(@PathVariable String symbol) {
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
    public Map<String, Integer> findMoleculesByAtomId(@PathVariable long id) {
        return moleculeAtomContainmentService.findByAtomOrderByMoleculeASC(id);
    }
}
