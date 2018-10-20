package net.emt.asciitarot;

import net.emt.asciitarot.CardRepository;
import net.emt.asciitarot.entities.Card;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class DeckService {
    private CardRepository repo;

    public DeckService(CardRepository repo) {
        this.repo = repo;
    }

    public Iterable<Card> list() {
        return repo.findAll();
    }

//    public Iterable<Card> save(List<Card> deck) {
//        return repo.save(deck);
//    }
}
