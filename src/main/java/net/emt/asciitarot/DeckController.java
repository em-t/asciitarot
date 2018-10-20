package net.emt.asciitarot;

import net.emt.asciitarot.entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deck")
public class DeckController {
    private CardRepository deck;

    @Autowired
    public DeckController(CardRepository deck) {
        this.deck = deck;
    }

    @GetMapping
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping("/cards")
    public String listAllCards(Model model) {
        Iterable<Card> cards = deck.findAll();
        model.addAttribute("cards", cards);
        return "deck";
    }
}
