package net.emt.asciitarot.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@Column(name = "id", updatable = false, nullable = false)
    private int id; // id can contain reference to big/small arcana and suit
    private String name;
    @Lob
    private String uprightMeaning;
    @Lob
    private String reversedMeaning;
    private String filepath;
    private String suit;
    //@PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "card")
    private MinorArcana minorArcana;

    public Card() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUprightMeaning() {
        return uprightMeaning;
    }

    public void setUprightMeaning(String uprightMeaning) {
        this.uprightMeaning = uprightMeaning;
    }

    public String getReversedMeaning() {
        return reversedMeaning;
    }

    public void setReversedMeaning(String reversedMeaning) {
        this.reversedMeaning = reversedMeaning;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public MinorArcana getMinorArcana() {
        return minorArcana;
    }

    public void setMinorArcana(MinorArcana minorArcana) {
        this.minorArcana = minorArcana;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
