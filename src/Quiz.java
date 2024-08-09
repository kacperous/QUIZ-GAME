import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private long id;
    private String quizName;
    private List<Question> questions;

    public Quiz(long id, String quizName) {
        this.id = id;
        this.quizName = quizName;
        questions = new ArrayList<Question>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    public void editQuestion(Question question) {
        int index = questions.indexOf(question);
        questions.set(index, question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public boolean checkAnswer(Question question, char answer) {
        if(answer == question.getCorrectAnswerIndex()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", quizName='" + quizName + '\'' +
                ", questions=" + questions +
                '}';
    }
}