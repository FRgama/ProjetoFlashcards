/* package Flashcards.src.projeto_flashcards;// Implementacao de Interface Gráfica
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashCardGUI {
    private JFrame frame;
    private JTextField perguntaField;
    private JTextField respostaField;
    private JTextArea deckArea;
    private FlashcardController controller;

    public FlashCardGUI() {
        controller = new FlashcardController();

        frame = new JFrame("Flashcards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel perguntaLabel = new JLabel("Pergunta:");
        perguntaField = new JTextField(20);

        JLabel respostaLabel = new JLabel("Resposta:");
        respostaField = new JTextField(20);

        JButton addButton = new JButton("Adicionar Flashcard");
        deckArea = new JTextArea(10, 30);
        deckArea.setEditable(false);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pergunta = perguntaField.getText();
                String resposta = respostaField.getText();
                controller.adicionarFlashcard(pergunta, resposta);
                atualizarDeck();
            }
        });

        frame.add(perguntaLabel);
        frame.add(perguntaField);
        frame.add(respostaLabel);
        frame.add(respostaField);
        frame.add(addButton);
        frame.add(new JScrollPane(deckArea));

        frame.setVisible(true);
    }

    private void atualizarDeck() {
        deckArea.setText("");  // Limpa a área antes de atualizar
        for (FlashCard card : controller.getDeck().getFlashCards()) {
            deckArea.append(card.toString() + "\n\n");
        }
    }

    public static void main(String[] args) {
        new FlashCardGUI();
    }
}
*/