package de.seniorenheim.nlbackend.chemistry.database.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AggregateStateDTO {
    private long id;
    private String name;
}
