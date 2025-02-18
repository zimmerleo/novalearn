package de.seniorenheim.nlbackend.chemistry.controllers;

import de.seniorenheim.nlbackend.chemistry.database.dtos.*;
import de.seniorenheim.nlbackend.chemistry.services.AtomService;
import de.seniorenheim.nlbackend.chemistry.services.MoleculeAtomContainmentService;
import de.seniorenheim.nlbackend.utils.DTOConverter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/atoms")
public class AtomController {

    private final AtomService atomService;
    private final MoleculeAtomContainmentService moleculeAtomContainmentService;
    private final DTOConverter dtoConverter;

    public AtomController(AtomService atomService, MoleculeAtomContainmentService moleculeAtomContainmentService, DTOConverter dtoConverter) {
        this.atomService = atomService;
        this.moleculeAtomContainmentService = moleculeAtomContainmentService;
        this.dtoConverter = dtoConverter;
    }

    @GetMapping
    public List<AtomDTO> getAtoms() {
        return dtoConverter.convertList(atomService.findAll(), dtoConverter::convertToDTO);
    }

    @PostMapping
    public AtomDTO saveAtom(@RequestBody AtomDTO atomDTO) {
        return dtoConverter.convertToDTO(atomService.save(atomDTO));
    }

    @GetMapping("/atomicNumber/{atomicNumber}")
    public AtomDTO getAtomByAtomicNumber(@PathVariable long atomicNumber) {
        return dtoConverter.convertToDTO(atomService.findByAtomicNumber(atomicNumber));
    }

    @GetMapping("/symbol/{symbol}")
    public AtomDTO getAtomBySymbol(@PathVariable String symbol) {
        return dtoConverter.convertToDTO(atomService.findBySymbol(symbol));
    }

    @GetMapping("/atomicNumber/{atomicNumber}/shells")
    public List<Integer> getAtomShellsByAtomicNumber(@PathVariable long atomicNumber) {
        return atomService.getAtomShells(atomicNumber);
    }

    @GetMapping("/symbol/{symbol}/shells")
    public List<Integer> getAtomShellsBySymbol(@PathVariable String symbol) {
        return atomService.getAtomShells(symbol);
    }

    @GetMapping("/atomicNumber/{atomicNumber}/valenceShellElectronCount")
    public int getValenceShellElectronCount(@PathVariable long atomicNumber) {
        return atomService.getValenceShellElectronCount(atomicNumber);
    }

    @GetMapping("/symbol/{symbol}/valenceShellElectronCount")
    public int getValenceShellElectronCount(@PathVariable String symbol) {
        return atomService.getValenceShellElectronCount(symbol);
    }

    @GetMapping("/atomicNumber/{atomicNumber}/molecules")
    public Map<MoleculeDTO, Integer> getMoleculesByAtomId(@PathVariable long atomicNumber) {
        //TODO Map lässt sich schlecht in Json darstellen, vllt wechseln - gilt ebenfalls für den MoleculeController
        return dtoConverter.convertMap(moleculeAtomContainmentService.findByAtom(atomService.findByAtomicNumber(atomicNumber)), dtoConverter::convertToDTO);
    }
}
