package Flashcards.src.flashcards.controller;

import Flashcards.src.flashcards.model.Deck;
import Flashcards.src.flashcards.model.FlashCard;

public class FlashcardController {

    public void addFlashcard(Deck deck, String question, String answer){
        FlashCard card = new FlashCard(question, answer);
        deck.addFlashCard(card);
    }
}
