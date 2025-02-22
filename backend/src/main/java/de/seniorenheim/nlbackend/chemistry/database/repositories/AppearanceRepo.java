package de.seniorenheim.nlbackend.chemistry.database.repositories;

import de.seniorenheim.nlbackend.chemistry.database.entities.Appearance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppearanceRepo extends JpaRepository<Appearance, Long> {
    Appearance findById(long id);
    Appearance findByName(String name);
}
