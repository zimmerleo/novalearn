package de.seniorenheim.nlbackend.chemistry.database.repositories;

import de.seniorenheim.nlbackend.chemistry.database.entities.Atom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtomRepo extends JpaRepository<Atom, Long> {

    Atom findById(long id);
    Atom findByName(String name);
    Atom findBySymbol(String symbol);

    List<Atom> findAllByAggregateState_Id(long aggregateStateId);
    List<Atom> findAllByAppearance_Id(long id);
    List<Atom> findAllByGroup_Id(long id);
    List<Atom> findAllByPeriod(long period);
}
