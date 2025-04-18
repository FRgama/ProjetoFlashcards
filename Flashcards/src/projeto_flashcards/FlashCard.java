package Flashcards.src.projeto_flashcards;

public class FlashCard implements Comparable<FlashCard> {
    private String question;
    private String answer;
    private int difficulty; // 0 = fácil, 1 = médio, 2 = difícil

    public FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.difficulty = 0; // padrão: fácil
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(FlashCard other) {
        return Integer.compare(other.difficulty, this.difficulty);
    }

    @Override
    public String toString() {
        return "Pergunta: " + question + " | Resposta: " + answer + " | Dificuldade: " + difficulty;
    }
}
