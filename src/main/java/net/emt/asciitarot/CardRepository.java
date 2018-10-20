package net.emt.asciitarot;

import net.emt.asciitarot.entities.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {
}
