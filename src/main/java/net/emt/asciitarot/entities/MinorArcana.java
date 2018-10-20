package net.emt.asciitarot.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="minor_arcana")
public class MinorArcana {
    @Id
//    @GeneratedValue(generator = "deckGenerator")
//    @GenericGenerator(name = "deckGenerator", strategy = "foreign", parameters = { @Parameter(value = "card", name = "property")})
    private int id;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    //@JoinColumn(name = "minorArcana")
    private Card card;
    private String suit;

    public MinorArcana() {
        super();
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
