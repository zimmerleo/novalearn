package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.GroupDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.Group;
import de.seniorenheim.nlbackend.chemistry.database.repositories.GroupRepo;
import de.seniorenheim.nlbackend.utils.DTOConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepo groupRepo;
    private final DTOConverter dtoConverter;

    public GroupService(GroupRepo groupRepo, DTOConverter dtoConverter) {
        this.groupRepo = groupRepo;
        this.dtoConverter = dtoConverter;
    }

    @Transactional
    public GroupDTO save(GroupDTO groupDTO) {
        Group group = Group.builder()
                .name(groupDTO.getName())
                .mainGroup(groupDTO.isMainGroup())
                .build();
        return dtoConverter.convertToDTO(groupRepo.save(group));
    }

    @Transactional
    public GroupDTO update(long id, GroupDTO groupDTO) {
        Group group = groupRepo.findById(id);
        if (group == null) {
            return null;
        }
        group.setName(groupDTO.getName());
        group.setMainGroup(groupDTO.isMainGroup());
        return dtoConverter.convertToDTO(groupRepo.save(group));
    }

    @Transactional
    public void delete(long id) {
        groupRepo.deleteById(id);
    }

    public List<GroupDTO> findAll() {
        return dtoConverter.convertList(groupRepo.findAll(), dtoConverter::convertToDTO);
    }

    public GroupDTO findById(long id) {
        return dtoConverter.convertToDTO(groupRepo.findById(id));
    }

    public GroupDTO findByName(String name) {
        return dtoConverter.convertToDTO(groupRepo.findByName(name));
    }
}
