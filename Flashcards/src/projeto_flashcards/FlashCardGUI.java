package Flashcards.src.projeto_flashcards;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class FlashCardGUI {
    private JFrame frame;
    private JTextField perguntaField;
    private JTextField respostaField;
    private JTextField nomeDeckField;
    private JTextArea deckArea;
    private JComboBox<String> deckSelector;
    private List<projeto_flashcards.Deck> decks = new ArrayList<>();

    public FlashCardGUI() {
        FlatDarkLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());  // Mude para o tema escuro
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        frame = new JFrame("Sistema de Flashcards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // Criar deck inicial
        projeto_flashcards.Deck deckInicial = new projeto_flashcards.Deck("Deck Inicial");
        decks.add(deckInicial);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Criar Flashcard", criarPainelCriar());
        tabbedPane.addTab("Ver Decks", criarPainelVer());
        tabbedPane.addTab("Estudar", criarPainelEstudo());
        tabbedPane.addTab("Gerenciar Decks", criarPainelGerenciar());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private JPanel criarPainelCriar() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel deckLabel = new JLabel("Escolha o Deck:");
        deckSelector = new JComboBox<>();
        atualizarDeckSelector();

        JLabel perguntaLabel = new JLabel("Pergunta:");
        perguntaField = new JTextField(30);

        JLabel respostaLabel = new JLabel("Resposta:");
        respostaField = new JTextField(30);

        JButton addButton = new JButton("Adicionar Flashcard");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(new Color(34, 123, 242));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addButton.addActionListener(e -> {
            String pergunta = perguntaField.getText();
            String resposta = respostaField.getText();
            int selectedIndex = deckSelector.getSelectedIndex();
            if (selectedIndex >= 0 && !pergunta.isEmpty() && !resposta.isEmpty()) {
                projeto_flashcards.Deck deckSelecionado = decks.get(selectedIndex);
                FlashCard novoCard = new FlashCard(pergunta, resposta);
                deckSelecionado.addFlashcard(novoCard);
                perguntaField.setText("");
                respostaField.setText("");
                JOptionPane.showMessageDialog(frame, "Flashcard adicionado ao deck " + deckSelecionado.getName() + "!");
                atualizarDeck();  // Atualizando a interface após adicionar o flashcard
            } else {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
            }
        });

        painel.add(deckLabel);
        painel.add(deckSelector);
        painel.add(perguntaLabel);
        painel.add(perguntaField);
        painel.add(respostaLabel);
        painel.add(respostaField);
        painel.add(addButton);

        return painel;
    }

    private JPanel criarPainelVer() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout()); // Usando BorderLayout para organizar os elementos principais.

        // Painel para os flashcards
        JPanel painelFlashcards = new JPanel();
        painelFlashcards.setLayout(new GridLayout(0, 3, 10, 10)); // Organizando os flashcards em 3 colunas, com 10px de espaçamento.

        // Atualizando os flashcards na interface
        atualizarDeck(painelFlashcards);

        // Botão de Atualizar
        JButton refreshButton = new JButton("Atualizar Lista");
        refreshButton.setFont(new Font("Arial", Font.BOLD, 14));
        refreshButton.setBackground(new Color(34, 123, 242));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setFocusPainted(false);
        refreshButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        refreshButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refreshButton.addActionListener(e -> atualizarDeck(painelFlashcards));

        // Adicionando os elementos ao painel principal
        painel.add(new JScrollPane(painelFlashcards), BorderLayout.CENTER);
        painel.add(refreshButton, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarPainelEstudo() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JButton startStudyButton = new JButton("Começar Estudo");
        startStudyButton.setFont(new Font("Arial", Font.BOLD, 14));
        startStudyButton.setBackground(new Color(34, 123, 242));
        startStudyButton.setForeground(Color.WHITE);
        startStudyButton.setFocusPainted(false);
        startStudyButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        startStudyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        startStudyButton.addActionListener(e -> estudarDeck());

        painel.add(startStudyButton);

        return painel;
    }

    private JPanel criarPainelGerenciar() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel nomeLabel = new JLabel("Nome do novo Deck:");
        nomeDeckField = new JTextField(20);

        JButton criarButton = new JButton("Criar Deck");
        criarButton.setFont(new Font("Arial", Font.BOLD, 14));
        criarButton.setBackground(new Color(34, 123, 242));
        criarButton.setForeground(Color.WHITE);
        criarButton.setFocusPainted(false);
        criarButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        criarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        criarButton.addActionListener(e -> {
            String nome = nomeDeckField.getText();
            if (!nome.isEmpty()) {
                decks.add(new projeto_flashcards.Deck(nome));
                atualizarDeckSelector();
                nomeDeckField.setText("");
                JOptionPane.showMessageDialog(frame, "Novo deck \"" + nome + "\" criado!");
            } else {
                JOptionPane.showMessageDialog(frame, "Digite um nome para o deck!");
            }
        });

        painel.add(nomeLabel);
        painel.add(nomeDeckField);
        painel.add(criarButton);

        return painel;
    }

    private void atualizarDeckSelector() {
        deckSelector.removeAllItems();
        for (projeto_flashcards.Deck d : decks) {
            deckSelector.addItem(d.getName());
        }
    }

    private void atualizarDeck() {
        // Esse método agora não requer um painel específico
        // Atualizando o combo box de decks
        atualizarDeckSelector();
    }

    private void atualizarDeck(JPanel painelFlashcards) {
        painelFlashcards.removeAll(); // Limpar a grade de flashcards

        for (projeto_flashcards.Deck deck : decks) {
            // Criar um painel para cada deck
            JPanel painelDeck = new JPanel();
            painelDeck.setLayout(new BoxLayout(painelDeck, BoxLayout.Y_AXIS));
            JLabel deckLabel = new JLabel(deck.getName());
            painelDeck.add(deckLabel);

            // Para cada flashcard no deck
            for (FlashCard card : deck.getFlashCards()) {
                JPanel cardPanel = new JPanel();
                cardPanel.setLayout(new BorderLayout());
                cardPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                cardPanel.setBackground(new Color(60, 60, 60));

                // Pergunta e resposta
                JLabel perguntaLabel = new JLabel("<html><b>Pergunta:</b> " + card.getQuestion() + "</html>");
                JLabel respostaLabel = new JLabel("<html><b>Resposta:</b> " + card.getAnswer() + "</html>");

                // Dificuldade
                JLabel dificuldadeLabel = new JLabel("Dificuldade: " + dificuldadeParaTexto(card.getDifficulty()));

                // Adicionando ao painel do card
                cardPanel.add(perguntaLabel, BorderLayout.NORTH);
                cardPanel.add(respostaLabel, BorderLayout.CENTER);
                cardPanel.add(dificuldadeLabel, BorderLayout.SOUTH);

                painelDeck.add(cardPanel); // Adicionando o card ao painel do deck
            }

            painelFlashcards.add(painelDeck); // Adicionando o painel do deck à grade
        }

        painelFlashcards.revalidate(); // Revalidar o painel para atualizar a interface
        painelFlashcards.repaint(); // Repaint para garantir que a interface seja atualizada visualmente
    }

    private void estudarDeck() {
        int selectedIndex = deckSelector.getSelectedIndex();
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(frame, "Nenhum deck selecionado!");
            return;
        }

        projeto_flashcards.Deck deckSelecionado = decks.get(selectedIndex);
        List<FlashCard> cardsParaEstudo = new ArrayList<>(deckSelecionado.getFlashCards());

        if (cardsParaEstudo.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "O deck está vazio.");
            return;
        }

        for (FlashCard card : cardsParaEstudo) {
            JOptionPane.showMessageDialog(frame, "Pergunta: " + card.getQuestion());
            JOptionPane.showMessageDialog(frame, "Resposta: " + card.getAnswer());

            String[] opcoes = {"Fácil", "Médio", "Difícil"};
            int dificuldade = JOptionPane.showOptionDialog(
                    frame,
                    "Qual a dificuldade desta pergunta?",
                    "Dificuldade",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            if (dificuldade >= 0) {
                card.setDifficulty(dificuldade);
            }
        }

        JOptionPane.showMessageDialog(frame, "Estudo concluído!");
    }

    private String dificuldadeParaTexto(int dificuldade) {
        switch (dificuldade) {
            case 0: return "Fácil";
            case 1: return "Médio";
            case 2: return "Difícil";
            default: return "Desconhecida";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlashCardGUI());
    }
}
