package net.emt.asciitarot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.emt.asciitarot.entities.Card;
import net.emt.asciitarot.entities.MinorArcana;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class AsciitarotApplication {
    public Resource loadCards() {
        return new ClassPathResource("/descriptions.txt");
    }

    public Resource loadCardsFromJSON() {
        return new ClassPathResource("/descriptions.json");
    }

    public static void main(String[] args) {
        SpringApplication.run(AsciitarotApplication.class, args);

    }

    @Bean
    public CommandLineRunner initiateDeck(CardRepository deck) {
        return (args) -> {
            File file = loadCards().getFile();

            // hox repo.save osaa tallentaa listan - paitsi että minulla ei osaa
            // trying example from: https://therealdanvega.com/blog/2017/07/05/read-json-data-spring-boot-write-database
            // === alla oleva toimii silloin, kun json-data ei sisällä tietoa minor arcanasta
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Card>> typeReference = new TypeReference<List<Card>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/descriptions.json");
            try {
                List<Card> cards = mapper.readValue(inputStream,typeReference);
                for (Card card : cards) {
                    deck.save(card);
                }
                System.out.println("Cards Saved!");
            } catch (IOException e){
                System.out.println("Unable to save cards: " + e.getMessage());
            }

            // =============

            // === alla oleva toimi sekä .txt että .json datan lukemiseen rivi riviltä
            /*try (FileReader fr = new FileReader(file);
                 BufferedReader reader = new BufferedReader(fr)) {
                String row;
                System.out.println("rows:");
                while((row = reader.readLine()) != null) {
                    System.out.println(row);
                }
                System.out.println("end");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

            // === alla oleva toimi yhden kortin manuaaliseen lisäämiseen ===
            /*Card card = new Card();
            card.setName("I - Ace of Cups");
            card.setUprightMeaning("Upright: love, new relationships, compassion, creativity");
            card.setReversedMeaning("Reversed: self-love, intuition, repressed emotions");
            card.setFilepath("/gfx/meme.jpg");
            // this part doesn't work
            *//*MinorArcana ma = new MinorArcana();
            //ma.setCard(card);
            ma.setSuit("cups");
            card.setMinorArcana(ma);*//*
            deck.save(card);*/
        };
    }
}
