import java.util.ArrayList;
import java.util.List;

public class Quizes {
    private List<Quiz> quizes;

    public Quizes() {
        quizes = new ArrayList<Quiz>();
    }

    public List<Quiz> getQuizes() {
        return quizes;
    }

    public void addQuiz(Quiz quiz) {
        quizes.add(quiz);
    }

    public void removeQuiz(Quiz quiz) {
        quizes.remove(quiz);
    }

    public void printQuizes() {
        int i=0;
        for (Quiz quiz : quizes) {
            System.out.println((i+1)+"."+quiz.getQuizName());
            i++;
        }
    }

    public Quiz getQuizById(int id){
        for(Quiz quiz : quizes){
            if(quiz.getId() == id ){
                return quiz;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Quizes{" +
                "quizes=" + quizes +
                '}';
    }
}