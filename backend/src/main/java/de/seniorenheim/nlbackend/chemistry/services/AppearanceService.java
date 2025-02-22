package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.AppearanceDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.Appearance;
import de.seniorenheim.nlbackend.chemistry.database.repositories.AppearanceRepo;
import de.seniorenheim.nlbackend.utils.DTOConverter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppearanceService {

    private final AppearanceRepo appearanceRepo;
    private final DTOConverter dtoConverter;

    public AppearanceService(AppearanceRepo appearanceRepo, DTOConverter dtoConverter) {
        this.appearanceRepo = appearanceRepo;
        this.dtoConverter = dtoConverter;
    }

    @Transactional
    public AppearanceDTO save(AppearanceDTO appearanceDTO) {
        Appearance appearance = Appearance.builder()
                .name(appearanceDTO.getName())
                .build();
        return dtoConverter.convertToDTO(appearanceRepo.save(appearance));
    }

    @Transactional
    public AppearanceDTO update(long id, AppearanceDTO appearanceDTO) {
        Appearance appearance = appearanceRepo.findById(id);
        if (appearance == null) {
            return null;
        }
        appearance.setName(appearanceDTO.getName());
        return dtoConverter.convertToDTO(appearanceRepo.save(appearance));
    }

    @Transactional
    public void delete(long id) {
        appearanceRepo.deleteById(id);
    }

    public List<AppearanceDTO> findAll() {
        return dtoConverter.convertList(appearanceRepo.findAll(), dtoConverter::convertToDTO);
    }

    public AppearanceDTO findById(long id) {
        return dtoConverter.convertToDTO(appearanceRepo.findById(id));
    }

    public AppearanceDTO findByName(String name) {
        return dtoConverter.convertToDTO(appearanceRepo.findByName(name));
    }
}
