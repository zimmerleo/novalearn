package de.seniorenheim.nlbackend.chemistry.database.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class MoleculeDTO {
    private String name;
    private String chemicalFormula;
    private double molecularMass;
    private Map<String, Integer> atoms;
}
