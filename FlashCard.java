public class FlashCard {

    private String questions;
    private String answers;
    private int dificulty;

    public FlashCard(String quetions, String answers){
        this.questions = quetions;
        this.answers = answers;
        this.dificulty = 0;
    }

    public String getQuestions() {return questions;}
    public String getAnswers() {return answers;}
    public int getDificulty() {return dificulty;}
}
