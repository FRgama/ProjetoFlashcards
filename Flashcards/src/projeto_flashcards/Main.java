package Flashcards.src.projeto_flashcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Deck> decks = new ArrayList<>();

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
        String deckName = scanner.nextLine();
        decks.add(new Deck(deckName));
        System.out.println("Pronto! seu deck chamado " + deckName + " está criado!");
    }

    public static void addCard() {
        System.out.println("Em qual deck você vai adicionar?");
        String name = scanner.nextLine();

        for (int i = 0; i < decks.size(); i++) {
            Deck deck = decks.get(i);
            if (deck.getName().equals(name)) {
                while (true) {
                    System.out.println("Ok, vamos criar sua carta!");
                    System.out.println("Qual sera a pergunta ou digite 1 para sair");
                    String pergunta = scanner.nextLine();
                    if (pergunta.equals("1")) {
                        return;
                    }
                    System.out.println("E qual será a resposta?");
                    String resposta = scanner.nextLine();
                    FlashCard novoCard = new FlashCard(pergunta, resposta);
                    deck.addFlashcard(novoCard);
                    System.out.println("Carta adicionada ao deck!");
                }
            }
        }
        System.out.println("Não foi possível achar");

    }

    public static void viewDeck() {
        System.out.println("Qual Deck você quer visualizar?");
        String name = scanner.nextLine();
        for (int i = 0; i < decks.size(); i++) {
            Deck deck = decks.get(i);
            if (Objects.equals(deck.getName(), name)) {
                System.out.println(deck.getFlashCards());
                return;
            }
        }
        System.out.println("Não foi encontrado");
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
                    printOptions();
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
