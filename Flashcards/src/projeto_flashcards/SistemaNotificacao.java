package Flashcards.src.projeto_flashcards;
import java.util.*;

//Classe que gerencia notificações (Sujeito/Subject do Observer)
class SistemaNotificacao {
 private List<Observer> usuarios = new ArrayList<>();

 public void adicionarUsuario(Observer usuario) {
     usuarios.add(usuario);
 }

 public void notificar(String mensagem) {
     for (Observer usuario : usuarios) {
         usuario.atualizar(mensagem);
     }
 }
}
