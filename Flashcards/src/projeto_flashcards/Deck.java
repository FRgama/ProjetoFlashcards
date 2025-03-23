import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private String name;
    private List<FlashCard> flashCards;

    public Deck(String name){
        this.name = name;
        this.flashCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlashCard> getFlashCards() {
        return flashCards;
    }

    public void addFlashcard(FlashCard Card){ //Adiciona nova carta ao deck
        flashCards.add(Card);
    }

    public void removeFlashcard(FlashCard Card){ // Remove carta do deck
        flashCards.remove(Card);
    }

    public void shuffleDeck(){ // Embaralha o deck
        Collections.shuffle(flashCards);
    }
}
