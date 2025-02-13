public class FlashCard {

    private String questions;
    private String answers;
    private int difficulty;

    public FlashCard(String questions, String answers){
        this.questions = quetions;
        this.answers = answers;
        this.difficulty = 0;
    }

    //métodos getters
    public String getQuestions() {return questions;}
    public String getAnswers() {return answers;}
    public int getDificulty() {return difficulty;}

    //métodos setters
    public void setQuestion(String question){ this.question = question; }
    public void setAnswer(String answer){ this.answer = answer; }
    public void setDifficulty(int difficulty){ this.difficulty = difficulty; }

    //método para editar o flashcard
    public void editFlashCard(String newQuestion, String newAnswer, int newDifficulty){
        this.question = newQuestion;
        this.answer = newAnswer;
        this.difficulty = newDifficulty;
    }

    //método para mostrar as informações do flashcard.
    //é um protótipo, então faremos de maneira simples.
    public String toString(){
        return "Pergunta: " + question + "\nResposta: " + answer + "\nDificuldade: " + difficulty;
    }

}
