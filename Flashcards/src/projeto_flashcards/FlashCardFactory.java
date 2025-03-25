package projeto_flashcards;

public class FlashCardFactory {
	public static FlashCard criarFlashcard(String pergunta, String resposta) {
        return new FlashCard(pergunta, resposta);
    }
}
