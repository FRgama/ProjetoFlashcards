package Flashcards.src.projeto_flashcards;

public interface Observer {
	
		 void atualizar(String mensagem);
		}
		class Usuario implements Observer {
		 private String nome;
		 
		 public Usuario(String nome) {
		 this.nome = nome;
		 }
		 
		 @Override
		 public void atualizar(String mensagem) {
		 System.out.println(nome + " recebeu notificação: " + mensagem);
		 }
}
		
