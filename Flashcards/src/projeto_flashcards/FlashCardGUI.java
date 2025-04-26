package Flashcards.src.projeto_flashcards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class FlashCardGUI {
    private JFrame frame;
    private JTextField perguntaField;
    private JTextField respostaField;
    private JTextArea deckArea;
    private projeto_flashcards.Deck deck;

    public FlashCardGUI() {
        deck = new projeto_flashcards.Deck("Deck Inicial");

        frame = new JFrame("Flashcards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Criar Flashcard", criarPainelCriar());
        tabbedPane.addTab("Ver Flashcards", criarPainelVer());
        tabbedPane.addTab("Estudar", criarPainelEstudo());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private JPanel criarPainelCriar() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JLabel perguntaLabel = new JLabel("Pergunta:");
        perguntaField = new JTextField(30);

        JLabel respostaLabel = new JLabel("Resposta:");
        respostaField = new JTextField(30);

        JButton addButton = new JButton("Adicionar Flashcard");

        addButton.addActionListener(e -> {
            String pergunta = perguntaField.getText();
            String resposta = respostaField.getText();
            if (!pergunta.isEmpty() && !resposta.isEmpty()) {
                FlashCard novoCard = new FlashCard(pergunta, resposta);
                deck.addFlashcard(novoCard);
                perguntaField.setText("");
                respostaField.setText("");
                JOptionPane.showMessageDialog(frame, "Flashcard adicionado com sucesso!");
                atualizarDeck();
            } else {
                JOptionPane.showMessageDialog(frame, "Preencha ambos os campos!");
            }
        });

        painel.add(perguntaLabel);
        painel.add(perguntaField);
        painel.add(respostaLabel);
        painel.add(respostaField);
        painel.add(addButton);

        return painel;
    }

    private JPanel criarPainelVer() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        deckArea = new JTextArea(20, 40);
        deckArea.setEditable(false);

        JButton refreshButton = new JButton("Atualizar Lista");

        refreshButton.addActionListener(e -> atualizarDeck());

        painel.add(new JScrollPane(deckArea));
        painel.add(refreshButton);

        return painel;
    }

    private JPanel criarPainelEstudo() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JButton startStudyButton = new JButton("Começar Estudo");

        startStudyButton.addActionListener(e -> estudarDeck());

        painel.add(startStudyButton);

        return painel;
    }

    private void atualizarDeck() {
        deckArea.setText("");  // Limpa a área antes de atualizar
        for (FlashCard card : deck.getFlashCards()) {
            deckArea.append("Pergunta: " + card.getQuestion() + "\n");
            deckArea.append("Resposta: " + card.getAnswer() + "\n");
            deckArea.append("------------------------------------\n");
        }
    }

    private void estudarDeck() {
        List<FlashCard> cardsParaEstudo = new ArrayList<>(deck.getFlashCards());

        if (cardsParaEstudo.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "O deck está vazio. Adicione flashcards primeiro!");
            return;
        }

        for (FlashCard card : cardsParaEstudo) {
            String pergunta = card.getQuestion();
            String resposta = card.getAnswer();

            JOptionPane.showMessageDialog(frame, "Pergunta: " + pergunta);

            JOptionPane.showMessageDialog(frame, "Resposta: " + resposta);

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlashCardGUI());
    }
}
