package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.AtomDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.Atom;
import de.seniorenheim.nlbackend.chemistry.database.repositories.AggregateStateRepo;
import de.seniorenheim.nlbackend.chemistry.database.repositories.AppearanceRepo;
import de.seniorenheim.nlbackend.chemistry.database.repositories.AtomRepo;
import de.seniorenheim.nlbackend.chemistry.database.repositories.GroupRepo;
import de.seniorenheim.nlbackend.utils.DTOConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtomService {

    private final AtomRepo atomRepo;
    private final AggregateStateRepo aggregateStateRepo;
    private final AppearanceRepo appearanceRepo;
    private final GroupRepo groupRepo;
    private final DTOConverter dtoConverter;

    public AtomService(AtomRepo atomRepo, AggregateStateRepo aggregateStateRepo, AppearanceRepo appearanceRepo, GroupRepo groupRepo, DTOConverter dtoConverter) {
        this.atomRepo = atomRepo;
        this.dtoConverter = dtoConverter;
        this.aggregateStateRepo = aggregateStateRepo;
        this.appearanceRepo = appearanceRepo;
        this.groupRepo = groupRepo;
    }

    @Transactional
    public AtomDTO save(AtomDTO atomDTO) {
        Atom atom = Atom.builder()
                .id(atomDTO.getId())
                .name(atomDTO.getName())
                .symbol(atomDTO.getSymbol())
                .atomicMass(atomDTO.getAtomicMass())
                .aggregateState(aggregateStateRepo.findById(atomDTO.getAggregateState().getId()))
                .appearance(appearanceRepo.findById(atomDTO.getAppearance().getId()))
                .group(groupRepo.findById(atomDTO.getGroup().getId()))
                .period(atomDTO.getPeriod())
                .build();

        return dtoConverter.convertToDTO(atomRepo.save(atom));
    }

    @Transactional
    public AtomDTO update(long atomicNumber, AtomDTO atomDTO) {
        Atom atom = atomRepo.findById(atomicNumber);
        if (atom == null) {
            return null;
        }
        atom.setName(atomDTO.getName());
        atom.setSymbol(atomDTO.getSymbol());
        atom.setAggregateState(aggregateStateRepo.findById(atomDTO.getAggregateState().getId()));
        atom.setAppearance(appearanceRepo.findById(atomDTO.getAppearance().getId()));
        atom.setGroup(groupRepo.findById(atomDTO.getGroup().getId()));
        atom.setPeriod(atomDTO.getPeriod());

        return dtoConverter.convertToDTO(atomRepo.save(atom));
    }

    @Transactional
    public void delete(long atomicNumber) {
        atomRepo.delete(atomRepo.findById(atomicNumber));
    }

    public List<AtomDTO> findAll() {
        return dtoConverter.convertList(atomRepo.findAll(), dtoConverter::convertToDTO);
    }

    public AtomDTO findById(Long id) {
        return dtoConverter.convertToDTO(atomRepo.findById(id).orElse(null));
    }

    public AtomDTO findByName(String name) {
        return dtoConverter.convertToDTO(atomRepo.findByName(name));
    }

    public AtomDTO findBySymbol(String symbol) {
        return dtoConverter.convertToDTO(atomRepo.findBySymbol(symbol));
    }

    public List<AtomDTO> findAllByAggregateStateId(long id) {
        List<Atom> atoms = atomRepo.findAllByAggregateState_Id(id);
        return dtoConverter.convertList(atoms, dtoConverter::convertToDTO);
    }

    public List<AtomDTO> findAllByAppearanceId(long id) {
        List<Atom> atoms = atomRepo.findAllByAppearance_Id(id);
        return dtoConverter.convertList(atoms, dtoConverter::convertToDTO);
    }

    public List<AtomDTO> findAllByGroupId(long id) {
        List<Atom> atoms = atomRepo.findAllByGroup_Id(id);
        return dtoConverter.convertList(atoms, dtoConverter::convertToDTO);
    }

    public List<AtomDTO> findAllByPeriod(long period) {
        List<Atom> atoms = atomRepo.findAllByPeriod(period);
        return dtoConverter.convertList(atoms, dtoConverter::convertToDTO);
    }

    public List<Long> getAtomShells(long atomicNumber) {
        return getAtomShells(atomRepo.findById(atomicNumber));
    }

    public List<Long> getAtomShells(String symbol) {
        return getAtomShells(atomRepo.findBySymbol(symbol));
    }

    private List<Long> getAtomShells(Atom atom) {
        long atomicNumber = atom.getId();
        List<Long> shells = new ArrayList<>();

        long n = 1;
        while (atomicNumber > 0) {
            long maxElectrons = 2 * (n * n);

            if (atomicNumber < maxElectrons) {
                maxElectrons = atomicNumber;
            }
            shells.add(maxElectrons);
            atomicNumber -= maxElectrons;
            n++;
        }

        return shells;
    }

    public long getValenceShellElectronCount(long atomicNumber) {
        return getAtomShells(atomRepo.findById(atomicNumber)).getLast();
    }

    public long getValenceShellElectronCount(String symbol) {
        return getAtomShells(atomRepo.findBySymbol(symbol)).getLast();
    }
}
