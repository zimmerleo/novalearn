package de.seniorenheim.nlbackend.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.seniorenheim.nlbackend.chemistry.database.dtos.*;
import de.seniorenheim.nlbackend.chemistry.database.entities.*;
import de.seniorenheim.nlbackend.chemistry.services.MoleculeAtomContainmentService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class DTOConverter {

    private final MoleculeAtomContainmentService moleculeAtomContainmentService;

    public DTOConverter(MoleculeAtomContainmentService moleculeAtomContainmentService) {
        this.moleculeAtomContainmentService = moleculeAtomContainmentService;
    }

    public MoleculeDTO convertToDTO(Molecule molecule) {
        return new MoleculeDTO(
                molecule.getName(),
                molecule.getChemicalFormula(),
                molecule.getMolecularMass(),
                toJsonString(convertMap(moleculeAtomContainmentService.findByMolecule(molecule), this::convertToDTO)));
    }

    public Molecule convertToEntity(MoleculeDTO moleculeDTO) {
        return Molecule.builder()
                .name(moleculeDTO.getName())
                .chemicalFormula(moleculeDTO.getChemicalFormula())
                .molecularMass(moleculeDTO.getMolecularMass())
                .build();
    }

    public AtomDTO convertToDTO(Atom atom) {
        return new AtomDTO(
                atom.getAtomicNumber(),
                atom.getName(), atom.getSymbol(),
                atom.getAtomicMass(),
                convertToDTO(atom.getAggregateState()),
                convertToDTO(atom.getAppearance()),
                convertToDTO(atom.getGroup()),
                atom.getPeriod());
    }

    public Atom convertToEntity(AtomDTO atomDTO) {
        return Atom.builder()
                .atomicNumber(atomDTO.getAtomicNumber())
                .name(atomDTO.getName())
                .symbol(atomDTO.getSymbol())
                .atomicMass(atomDTO.getAtomicMass())
                .aggregateState(convertToEntity(atomDTO.getAggregateState()))
                .appearance(convertToEntity(atomDTO.getAppearance()))
                .group(convertToEntity(atomDTO.getGroup()))
                .build();
    }

    public GroupDTO convertToDTO(Group group) {
        return new GroupDTO(
                group.getName(),
                group.isMainGroup());
    }

    public Group convertToEntity(GroupDTO groupDTO) {
        return Group.builder()
                .name(groupDTO.getName())
                .mainGroup(groupDTO.isMainGroup())
                .build();
    }

    public AppearanceDTO convertToDTO(Appearance appearance) {
        return new AppearanceDTO(appearance.getName());
    }

    public Appearance convertToEntity(AppearanceDTO appearanceDTO) {
        return Appearance.builder()
                .name(appearanceDTO.getName())
                .build();
    }

    public AggregateStateDTO convertToDTO(AggregateState aggregateState) {
        return new AggregateStateDTO(aggregateState.getName());
    }

    public AggregateState convertToEntity(AggregateStateDTO aggregateStateDTO) {
        return AggregateState.builder()
                .name(aggregateStateDTO.getName())
                .build();
    }

    public <T, R> List<R> convertList(List<T> entityList, Function<T, R> converter) {
        List<R> dtoList = new ArrayList<>();
        for (T entity : entityList) {
            dtoList.add(converter.apply(entity));
        }
        return dtoList;
    }

    public <T, D, R> Map<R, D> convertMap(Map<T, D> entityMap, Function<T, R> converter) {
        Map<R, D> dtoMap = new HashMap<>();
        for (Map.Entry<T, D> entry : entityMap.entrySet()) {
            dtoMap.put(converter.apply(entry.getKey()), entry.getValue());
        }
        return dtoMap;
    }

    public <T, D> Map<String, D> toJsonString(Map<T, D> map) {
        Map<String, D> jsonMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for (Map.Entry<T, D> entry : map.entrySet()) {
                jsonMap.put(objectMapper.writeValueAsString(entry.getKey()), entry.getValue());
            }
            return jsonMap;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonMap;
    }
}
