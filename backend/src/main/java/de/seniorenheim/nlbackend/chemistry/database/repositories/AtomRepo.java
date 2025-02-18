package de.seniorenheim.nlbackend.chemistry.database.repositories;

import de.seniorenheim.nlbackend.chemistry.database.entities.Atom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtomRepo extends JpaRepository<Atom, Long> {
    Atom findByName(String name);
    Atom findBySymbol(String symbol);
}
