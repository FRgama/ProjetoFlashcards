package Flashcards.src.projeto_flashcards;
import java.util.*;
import java.util.ArrayList;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<projeto_flashcards.Deck> decks = new ArrayList<>();

    public static void printOptions() {
        System.out.println("\nO que você deseja fazer?");
        System.out.println("1 - Criar meu deck");
        System.out.println("2 - Adicionar carta");
        System.out.println("3 - Visualizar deck");
        System.out.println("4 - Estudar deck");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void createDeck() {
        System.out.println("Ok, vamos criar seu deck!");
        System.out.print("Qual será o nome do Deck? ");
        String deckName = scanner.nextLine();
        decks.add(new projeto_flashcards.Deck(deckName));
        System.out.println("Pronto! Seu deck chamado \"" + deckName + "\" foi criado!");
    }

    public static void addCard() {
        System.out.print("Digite o nome do deck onde deseja adicionar a carta: ");
        String name = scanner.nextLine();

        for (projeto_flashcards.Deck deck : decks) {
            if (deck.getName().equalsIgnoreCase(name)) {
                while (true) {
                    System.out.print("Digite a pergunta (ou '1' para sair): ");
                    String pergunta = scanner.nextLine();
                    if (pergunta.equals("1")) return;

                    System.out.print("Digite a resposta: ");
                    String resposta = scanner.nextLine();

                    FlashCard novoCard = new FlashCard(pergunta, resposta);
                    deck.addFlashcard(novoCard);
                    System.out.println("Carta adicionada ao deck \"" + deck.getName() + "\"!");
                }
            }
        }
        System.out.println("Deck não encontrado.");
    }

    public static void viewDeck() {
        System.out.print("Digite o nome do deck que deseja visualizar: ");
        String name = scanner.nextLine();

        for (projeto_flashcards.Deck deck : decks) {
            if (deck.getName().equalsIgnoreCase(name)) {
                if (deck.getFlashCards().isEmpty()) {
                    System.out.println("O deck está vazio.");
                } else {
                    System.out.println("Cartas do deck \"" + deck.getName() + "\":");
                    for (FlashCard card : deck.getFlashCards()) {
                        System.out.println("- Pergunta: " + card.getQuestion() + " | Resposta: " + card.getAnswer() + " | Dificuldade: " + card.getDifficulty());
                    }
                }
                return;
            }
        }
        System.out.println("Deck não encontrado.");
    }

    public static void studyDeck() {
        System.out.print("Digite o nome do deck que deseja estudar: ");
        String name = scanner.nextLine();

        for (projeto_flashcards.Deck deck : decks) {
            if (deck.getName().equalsIgnoreCase(name)) {
                if (deck.getFlashCards().isEmpty()) {
                    System.out.println("O deck está vazio.");
                    return;
                }

                System.out.println("Estudando o deck: " + deck.getName());

                List<FlashCard> cardsOrdenados = new ArrayList<>(deck.getFlashCards());
                cardsOrdenados.sort(Comparator.naturalOrder()); // usa compareTo

                for (FlashCard card : cardsOrdenados) {
                    System.out.println("\nPergunta: " + card.getQuestion());
                    System.out.println("Pressione Enter para ver a resposta...");
                    scanner.nextLine();
                    System.out.println("Resposta: " + card.getAnswer());

                    System.out.println("Qual a dificuldade dessa pergunta?");
                    System.out.println("0 - Fácil | 1 - Médio | 2 - Difícil");

                    int dificuldade;
                    while (true) {
                        try {
                            dificuldade = Integer.parseInt(scanner.nextLine());
                            if (dificuldade >= 0 && dificuldade <= 2) break;
                        } catch (NumberFormatException ignored) {}
                        System.out.print("Por favor, insira um número válido (0, 1 ou 2): ");
                    }

                    card.setDifficulty(dificuldade);
                    System.out.println("---");
                }

                System.out.println("Estudo concluído!");
                return;
            }
        }
        System.out.println("Deck não encontrado.");
    }

    public static void main(String[] args) {
        System.out.println("BEM VINDO AO SISTEMA DE FLASHCARDS!");

        while (true) {
            printOptions();
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    createDeck();
                    break;
                case 2:
                    addCard();
                    break;
                case 3:
                    viewDeck();
                    break;
                case 4:
                    studyDeck();
                    break;
                case 5:
                    System.out.println("Saindo... Até mais!");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
