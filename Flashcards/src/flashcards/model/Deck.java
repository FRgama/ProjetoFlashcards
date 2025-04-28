package Flashcards.src.flashcards.model;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Deck {
    private String name;
    private PriorityQueue<FlashCard> flashcards;

    public Deck(String name) {
        this.name = name;
        this.flashcards = new PriorityQueue<>();
    }

    public String getName() {
        return name;
    }

    public List<FlashCard> getFlashCards() {
        return new ArrayList<>(flashcards);
    }

    public void addFlashCard(FlashCard card) {
        flashcards.add(card);
    }

    public void removeFlashCard(FlashCard card) {
        flashcards.remove(card);
    }
}
/*
    public void setName(String name) {
        this.name = name;
    }

    public PriorityQueue<FlashCard> getFlashCards() {
        return flashCards;
    }

    public void addFlashcard(FlashCard card) {
        flashCards.add(card);
    }

    public void removeFlashcard(FlashCard card) {
        flashCards.remove(card);
    }

    public void shuffleDeck() {
        System.out.println("Embaralhar não é aplicável com PriorityQueue. A fila já organiza automaticamente pela prioridade.");
    }
}
*/