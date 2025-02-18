package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.AggregateStateDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.AggregateState;
import de.seniorenheim.nlbackend.chemistry.database.repositories.AggregateStateRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AggregateStateService {

    private final AggregateStateRepo aggregateStateRepo;

    public AggregateStateService(AggregateStateRepo aggregateStateRepo) {
        this.aggregateStateRepo = aggregateStateRepo;
    }

    @Transactional
    public AggregateState save(AggregateStateDTO aggregateStateDTO) {

        for (AggregateState aggregateState : findAll()) {
            if (aggregateState.getName().equalsIgnoreCase(aggregateStateDTO.getName())) {
                return aggregateState;
            }
        }
        return aggregateStateRepo.save(
                AggregateState.builder()
                .name(aggregateStateDTO.getName())
                .build());
    }

    public List<AggregateState> findAll() {
        return aggregateStateRepo.findAll();
    }

    public AggregateState findById(Long id) {
        return aggregateStateRepo.findById(id).orElse(null);
    }
}
