package Flashcards.src.projeto_flashcards;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Deck myDeck;

    //Fazendo a criação de cartas e de decks no terminal

    public static void printOptions() {
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Criar meu deck");
        System.out.println("2 - Adicionar carta");
        System.out.println("3 - Visualizar Deck");
        System.out.println("4- Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void createDeck() {
        System.out.println("Ok, vamos criar seu deck!");
        System.out.println("Qual sera o nome do Deck?");
        String nomeDeck = scanner.nextLine();
        myDeck = new Deck(nomeDeck);
        System.out.println("Pronto! seu deck chamado " + nomeDeck + " está criado!");
    }

    public static void addCard() {
        if (myDeck == null) {
            System.out.println("Antes de adicionar uma carta, crie o deck primeiro!");
            return;
        }
        System.out.println("Ok, vamos criar sua carta!");
        System.out.println("Qual sera a pergunta?");
        String pergunta = scanner.nextLine();
        System.out.println("E qual será a resposta?");
        String resposta = scanner.nextLine();
        FlashCard novoCard = new FlashCard(pergunta, resposta);
        myDeck.addFlashcard(novoCard);
        System.out.println("Carta adicionada ao deck!");
    }

    public static void viewDeck() {
        if (myDeck == null) {
            System.out.println("Deck nao criado");
            return;
        } else if (myDeck.getFlashCards().isEmpty()) {
            System.out.println("Deck Vazio");
            return;
        }
        System.out.println(myDeck.getFlashCards());

    }

    public static void main(String[] args) {
        System.out.println("BEM VINDO!");
        printOptions();

        while (true) {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    createDeck();
                    printOptions();
                    break;
                case 2:
                    addCard();
                    break;
                case 3:
                    viewDeck();
                    break;
                case 4:
                    System.out.println("Saindo");
                    return;
            }
        }

    }
}
