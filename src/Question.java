import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private List<Answer> answers;
    private char correctAnswerIndex;

    public Question(String question, char correctAnswerIndex) {
        this.question = question;
        answers = new ArrayList<Answer>();
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public char getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(char correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void removeAnswer(Answer answer) {
        answers.remove(answer);
    }

    public void printAnswers(){
        char[] labels = {'a', 'b', 'c', 'd'};
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(labels[i] + ") " + answers.get(i).getAnswer());
        }
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                ", correctAnswerIndex=" + correctAnswerIndex +
                '}';
    }
}
