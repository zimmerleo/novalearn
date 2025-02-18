package de.seniorenheim.nlbackend.chemistry.services;

import de.seniorenheim.nlbackend.chemistry.database.dtos.AppearanceDTO;
import de.seniorenheim.nlbackend.chemistry.database.entities.Appearance;
import de.seniorenheim.nlbackend.chemistry.database.repositories.AppearanceRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppearanceService {

    private final AppearanceRepo appearanceRepo;

    public AppearanceService(AppearanceRepo appearanceRepo) {
        this.appearanceRepo = appearanceRepo;
    }

    @Transactional
    public Appearance save(AppearanceDTO appearanceDTO) {
        for (Appearance appearance : findAll()) {
            if (appearance.getName().equalsIgnoreCase(appearanceDTO.getName())) {
                return appearance;
            }
        }
        return appearanceRepo.save(
                Appearance.builder()
                        .name(appearanceDTO.getName())
                        .build());
    }

    public List<Appearance> findAll() {
        return appearanceRepo.findAll();
    }

    public Appearance findById(Long id) {
        return appearanceRepo.findById(id).orElse(null);
    }
}
