package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.GroupDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.Group;
import de.seniorenheim.nlbackend.chemistry.database.repositories.GroupRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepo groupRepo;

    public GroupService(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    @Transactional
    public Group save(GroupDTO groupDTO) {
        for (Group group : findAll()) {
            if (group.getName().equalsIgnoreCase(groupDTO.getName())) {
                return group;
            }
        }
        return groupRepo.save(
                Group.builder()
                        .name(groupDTO.getName())
                        .mainGroup(groupDTO.isMainGroup())
                        .build());
    }

    public List<Group> findAll() {
        return groupRepo.findAll();
    }

    public Group findById(Long id) {
        return groupRepo.findById(id).orElse(null);
    }
}
