package de.seniorenheim.nlbackend.utils;

import de.seniorenheim.nlbackend.chemistry.database.dtos.*;
import de.seniorenheim.nlbackend.chemistry.database.entities.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class DTOConverter {

    public MoleculeDTO convertToDTO(Molecule molecule) {
        if (molecule == null) { return null; }
        Map<String, Integer> atomMap = new HashMap<>();
        for (MoleculeAtomContainment containment : molecule.getMoleculeAtomContainments()) {
            AtomDTO atomDTO = convertToDTO(containment.getAtom());
            atomMap.put(atomDTO.getSymbol(), containment.getAmount());
        }
        return new MoleculeDTO(
                molecule.getId(),
                molecule.getName(),
                molecule.getChemicalFormula(),
                molecule.getMolecularMass(),
                atomMap
                );
    }

    public AtomDTO convertToDTO(Atom atom) {
        if (atom == null) { return null; }
        return new AtomDTO(
                atom.getId(),
                atom.getName(), atom.getSymbol(),
                atom.getAtomicMass(),
                convertToDTO(atom.getAggregateState()),
                convertToDTO(atom.getAppearance()),
                convertToDTO(atom.getGroup()),
                atom.getPeriod());
    }

    public MoleculeAtomContainmentDTO convertToDTO(MoleculeAtomContainment moleculeAtomContainment) {
        if (moleculeAtomContainment == null) { return null; }
        return new MoleculeAtomContainmentDTO(convertToDTO(moleculeAtomContainment.getAtom()), convertToDTO(moleculeAtomContainment.getMolecule()), moleculeAtomContainment.getAmount());
    }

    public GroupDTO convertToDTO(Group group) {
        if (group == null) { return null; }
        return new GroupDTO(group.getId(), group.getName(), group.isMainGroup());
    }

    public AppearanceDTO convertToDTO(Appearance appearance) {
        if (appearance == null) { return null; }
        return new AppearanceDTO(appearance.getId(), appearance.getName());
    }

    public AggregateStateDTO convertToDTO(AggregateState aggregateState) {
        if (aggregateState == null) { return null; }
        return new AggregateStateDTO(aggregateState.getId(), aggregateState.getName());
    }

    public <T, R> List<R> convertList(List<T> entityList, Function<T, R> converter) {
        List<R> dtoList = new ArrayList<>();
        for (T entity : entityList) {
            dtoList.add(converter.apply(entity));
        }
        return dtoList;
    }
}
