package de.seniorenheim.nlbackend.chemistry.database.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class MoleculeDTO {
    private long id;
    private String name;
    private String chemicalFormula;
    private double molecularMass;
    private Map<String, Integer> atoms;
}
