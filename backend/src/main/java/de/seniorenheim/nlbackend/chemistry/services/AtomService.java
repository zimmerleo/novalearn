package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.AtomDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.Appearance;
import de.seniorenheim.nlbackend.chemistry.database.entities.Atom;
import de.seniorenheim.nlbackend.chemistry.database.repositories.AtomRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtomService {

    private final AtomRepo atomRepo;
    private final AggregateStateService aggregateStateService;
    private final AppearanceService appearanceService;
    private final GroupService groupService;

    public AtomService(AtomRepo atomRepo, AggregateStateService aggregateStateService, AppearanceService appearanceService, GroupService groupService) {
        this.atomRepo = atomRepo;
        this.aggregateStateService = aggregateStateService;
        this.appearanceService = appearanceService;
        this.groupService = groupService;
    }

    @Transactional
    public Atom save(AtomDTO atomDTO) {

        for (Atom atom : findAll()) {
            if (atom.getSymbol().equalsIgnoreCase(atomDTO.getSymbol())) {
                return atom;
            }
        }

        Atom atom = Atom.builder()
                .atomicNumber(atomDTO.getAtomicNumber())
                .name(atomDTO.getName())
                .symbol(atomDTO.getSymbol())
                .atomicMass(atomDTO.getAtomicMass())
                .aggregateState(aggregateStateService.save(atomDTO.getAggregateState()))
                .appearance(appearanceService.save(atomDTO.getAppearance()))
                .group(groupService.save(atomDTO.getGroup()))
                .build();

        return atomRepo.save(atom);
    }

    public List<Atom> findAll() {
        return atomRepo.findAll();
    }

    public Atom findByAtomicNumber(Long atomicNumber) {
        return atomRepo.findById(atomicNumber).orElse(null);
    }

    public Atom findByName(String name) {
        return atomRepo.findByName(name);
    }

    public Atom findBySymbol(String symbol) {
        return atomRepo.findBySymbol(symbol);
    }

    public void delete(long atomicNumber) {
        atomRepo.delete(findByAtomicNumber(atomicNumber));
    }

    public List<Integer> getAtomShells(long atomicNumber) {
        return getAtomShells(findByAtomicNumber(atomicNumber));
    }

    public List<Integer> getAtomShells(String symbol) {
        return getAtomShells(findBySymbol(symbol));
    }

    private List<Integer> getAtomShells(Atom atom) {
        int atomicNumber = (int) atom.getAtomicNumber();
        List<Integer> shells = new ArrayList<>();

        int n = 1;
        while (atomicNumber > 0) {
            int maxElectrons = 2 * (n * n);

            if (atomicNumber < maxElectrons) {
                maxElectrons = atomicNumber;
            }
            shells.add(maxElectrons);
            atomicNumber -= maxElectrons;
            n++;
        }

        return shells;
    }

    public int getValenceShellElectronCount(long atomicNumber) {
        return getAtomShells(findByAtomicNumber(atomicNumber)).getLast();
    }

    public int getValenceShellElectronCount(String symbol) {
        return getAtomShells(findBySymbol(symbol)).getLast();
    }
}
