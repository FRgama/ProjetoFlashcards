package projeto_flashcards;

import Flashcards.src.projeto_flashcards.FlashCard;

import java.util.PriorityQueue;

public class Deck {

    private String name;
    private PriorityQueue<FlashCard> flashCards;

    public Deck(String name) {
        this.name = name;
        this.flashCards = new PriorityQueue<>();
    }

    public String getName() {
        return name;
    }

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
