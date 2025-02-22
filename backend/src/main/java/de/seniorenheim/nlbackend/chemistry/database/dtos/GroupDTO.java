package de.seniorenheim.nlbackend.chemistry.database.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupDTO {
    private long id;
    private String name;
    private boolean mainGroup;
}
