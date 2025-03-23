import java.util.Scanner;

public class Main {

    //Fazendo a criação de cartas e de decks no terminal

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck meuDeck = null; // Começamos sem um deck criado

        while(true){
            System.out.println("BEM VINDO!");
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Criar meu deck");
        System.out.println("2 - Adicionar carta");
        System.out.println("3 - Visualizar Deck");
        System.out.println("4- Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao){
            case 1:
                System.out.println("Ok, vamos criar seu deck!");
                System.out.println("Qual sera o nome do Deck?");
                String nomeDeck = scanner.nextLine();

                meuDeck = new Deck(nomeDeck);

                System.out.println("Pronto! seu deck chamado " + nomeDeck + " está criado!");
                break;
            case 2:
                if(meuDeck == null){
                    System.out.println("Antes de adicionar uma carta, crie o deck primeiro!");
                    break;
                }

                System.out.println("Ok, vamos criar sua carta!");

                System.out.println("Qual sera a pergunta?");
                String pergunta = scanner.nextLine();

                System.out.println("E qual será a resposta?");
                String resposta = scanner.nextLine();
                
                FlashCard novoCard = new FlashCard(pergunta,resposta);
                meuDeck.addFlashcard(novoCard);

                System.out.println("Carta adicionada ao deck!");
                break;
            case 3:
                if(meuDeck == null){
                    System.out.println("Deck nao criado");
                    break;
                } else if (meuDeck.getFlashCards().isEmpty()) {
                    System.out.println("Deck Vazio");
                    break;
                }
                System.out.println(meuDeck.getFlashCards());
                break;

            case 4:
                System.out.println("Saindo");
                return;
        }
        }

}}
