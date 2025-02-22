package de.seniorenheim.nlbackend.chemistry.database.repositories;

import de.seniorenheim.nlbackend.chemistry.database.entities.AggregateState;
import de.seniorenheim.nlbackend.chemistry.database.entities.Appearance;
import de.seniorenheim.nlbackend.chemistry.database.entities.Atom;
import de.seniorenheim.nlbackend.chemistry.database.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtomRepo extends JpaRepository<Atom, Long> {

    Atom findById(long id);
    Atom findByName(String name);
    Atom findBySymbol(String symbol);
    List<Atom> findAllByAggregateState(AggregateState aggregateState);
    List<Atom> findAllByAppearance(Appearance appearance);
    List<Atom> findAllByGroup(Group group);
    List<Atom> findAllByPeriod(long period);
}
