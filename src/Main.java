import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StartApp startApp = new StartApp();
        try {
            startApp.startQuiz();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}