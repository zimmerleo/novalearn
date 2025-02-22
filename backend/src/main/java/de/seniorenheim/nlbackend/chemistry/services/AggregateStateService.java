package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.AggregateStateDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.AggregateState;
import de.seniorenheim.nlbackend.chemistry.database.repositories.AggregateStateRepo;
import de.seniorenheim.nlbackend.utils.DTOConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AggregateStateService {

    private final AggregateStateRepo aggregateStateRepo;
    private final DTOConverter dtoConverter;

    public AggregateStateService(AggregateStateRepo aggregateStateRepo, DTOConverter dtoConverter) {
        this.aggregateStateRepo = aggregateStateRepo;
        this.dtoConverter = dtoConverter;
    }

    @Transactional
    public AggregateStateDTO save(AggregateStateDTO aggregateStateDTO) {
        AggregateState aggregateState = AggregateState.builder()
                .name(aggregateStateDTO.getName())
                .build();
        return dtoConverter.convertToDTO(aggregateStateRepo.save(aggregateState));
    }

    @Transactional
    public AggregateStateDTO update(long id, AggregateStateDTO aggregateStateDTO) {
        AggregateState aggregateState = aggregateStateRepo.findById(id);
        if (aggregateState == null) {
            return null;
        }
        aggregateState.setName(aggregateStateDTO.getName());
        return dtoConverter.convertToDTO(aggregateStateRepo.save(aggregateState));
    }

    @Transactional
    public void delete(long id) {
        aggregateStateRepo.deleteById(id);
    }

    public List<AggregateStateDTO> findAll() {
        return dtoConverter.convertList(aggregateStateRepo.findAll(), dtoConverter::convertToDTO);
    }

    public AggregateStateDTO findById(long id) {
        return dtoConverter.convertToDTO(aggregateStateRepo.findById(id));
    }

    public AggregateStateDTO findByName(String name) {
        return dtoConverter.convertToDTO(aggregateStateRepo.findByName(name));
    }
}
