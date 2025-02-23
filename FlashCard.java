public class FlashCard {

    private String question;
    private String answer;
    private int difficulty; // 0 = Fácil, 1 = Médio, 2 = Difícil

    public FlashCard(String question, String answer){
        this.question = question;
        this.answer = answer;
        this.difficulty = 0;
    }

    //métodos getters
    public String getQuestion() {return question;}
    public String getAnswer() {return answer;}
    public int getDifficulty() {return difficulty;}

    //métodos setters
    public void setQuestion(String question){ this.question = question; }
    public void setAnswer(String answer){ this.answer = answer; }
    
    public void setDifficulty(int difficulty)
        { if (difficulty >= 0 && difficulty <= 2){
            this.difficulty = difficulty;
        } else{
            System.out.println("Dificuldade inválida! Use 0 (Fácil), 1 (Médio) ou 2 (Difícil).");
        }
             }

    //método para editar o flashcard
    public void editFlashCard(String newQuestion, String newAnswer, int newDifficulty){
        this.question = newQuestion;
        this.answer = newAnswer;
        setDifficulty(newDifficulty);
    }

    //método para mostrar as informações do flashcard.
    @Override
    public String toString(){
        String dificuldade = switch(difficulty){
            case 0 -> "Fácil";
            case 1 -> "Médio";
            case 2 -> "Difícil";
            default -> "Desconhecido";
        };
            return "Pergunta: " + question + "\nResposta: " + answer + "\nDificuldade: " + dificuldade;
        
    }

    //é um protótipo, então faremos de maneira simples.

}
