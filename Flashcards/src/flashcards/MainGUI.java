package Flashcards.src.flashcards;

import Flashcards.src.flashcards.view.FlashCardGUI;

import javax.swing.SwingUtilities;


public class MainGUI {
    public static void main(String[]args){
        SwingUtilities.invokeLater(FlashCardGUI::new);
    }
}
