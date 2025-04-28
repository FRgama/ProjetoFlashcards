package Flashcards.src.flashcards.controller;

import Flashcards.src.flashcards.model.Deck;
import java.util.ArrayList;
import java.util.List;

public class DeckController {
    private final List<Deck> decks = new ArrayList<>();

    public void createDeck(String name){
        decks.add(new Deck(name));
    }

    public Deck findDeckByName(String name){
        return decks.stream()
                .filter(deck -> deck.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Deck> getDecks(){
        return decks;
    }
}
