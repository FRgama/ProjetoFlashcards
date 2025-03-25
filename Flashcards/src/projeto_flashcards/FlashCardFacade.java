package projeto_flashcards;

public class FlashCardFacade {
	private Deck deck;
	private SistemaNotificacao sistemaNotificacao;
		 
	public FlashCardFacade() {
		this.sistemaNotificacao = new SistemaNotificacao();
	}
		 
	public void criarDeck(String nome) {
		this.deck = new Deck(nome);
		System.out.println("Deck '" + nome + "' criado com sucesso!");
	}
	
	public void adicionarFlashcard(String pergunta, String resposta) {
		if (deck == null) {
			System.out.println("Crie um deck antes de adicionar um flashcard!");
		return;
		}
		
		FlashCard card = FlashCardFactory.criarFlashcard(pergunta, resposta);
		deck.addFlashcard(card);
		sistemaNotificacao.notificar("Nova carta adicionada ao deck!");
	}
		 
	public void visualizarDeck() {
		if (deck == null) {
			System.out.println("Deck não criado.");
			return;
		}
		System.out.println(deck.getFlashCards());
	}
		 
	public void adicionarUsuarioNotificacao(Usuario usuario) {
		sistemaNotificacao.adicionarUsuario(usuario);
	}

}
