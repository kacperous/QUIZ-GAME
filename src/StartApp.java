import java.util.Scanner;

public class StartApp {
    int choose;
    int balance =0;
    Scanner scanner = new Scanner(System.in);

    public void startQuiz() throws InterruptedException {
        Quizes quizGame = new Quizes();
        while (true) {
            choose = scanner.nextInt();
            switch (choose) {
                case 0: //exit game
                    System.out.println("Program ended");
                    System.exit(0);
                case 1: //start play
                    quizGame.printQuizes();
                    System.out.println("Choose quiz to play: ");
                    int quizChoise = scanner.nextInt();
                    if(quizChoise<=quizGame.getQuizes().size()) {
                        Quiz quiz = quizGame.getQuizById(quizChoise);
                        System.out.println(quiz.getQuizName());
                        System.out.println("QUIZ START! ");
                        System.out.println("3");
                        Thread.sleep(500);
                        System.out.println("2");
                        Thread.sleep(500);
                        System.out.println("1");
                        Thread.sleep(500);
                        System.out.println("START");
                        int i=0;
                        for(Question question : quiz.getQuestions()) {
                            System.out.println(i+1+". "+question.getQuestion());
                            question.printAnswers();
                            System.out.print("Your answer: ");
                            char answer = scanner.next().charAt(0);
                            char normalizedAnswer = Character.toLowerCase(answer); //change char to small
                            System.out.println("");
                            if (quiz.checkAnswer(question, normalizedAnswer)) {
                                System.out.println("Right answer!");
                                balance++;
                                System.out.println("Balance: " + balance);
                            } else {
                                System.out.println("Not this time!");
                                balance--;
                                System.out.println("Balance: " + balance);
                            }
                            i++;
                        }
                        System.out.println("QUIZ ENDED. YOUR BALANCE: "+balance);
                    }
                    else System.out.println("Choise out of range");
                    break;
                case 2: //add new quiz
                    addNewQuiz(quizGame);
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
    public void addNewQuiz(Quizes quizGame){
        System.out.println("Quiz name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        Quiz quiz = new Quiz((quizGame.getQuizes().size())+1,name);
        quizGame.addQuiz(quiz);
        System.out.println("How many questions? ");
        int questions = scanner.nextInt();
        String[] ans = new String[4];
        char[] labels = {'a', 'b', 'c', 'd'};
        for(int i = 0; i < questions; i++) {
            System.out.println("Question "+(i+1)+": ");
            scanner.nextLine();
            String question = scanner.nextLine();
            for(int j=0; j<4; j++){
                System.out.println("Answer "+labels[j]+": ");
                String a = scanner.nextLine();
                ans[j] = a;
            }
            System.out.println("Witch one was correct?");
            char answer = scanner.next().charAt(0);
            Question que = new Question(question,answer);
            quiz.addQuestion(que);
            for(int j=0; j<4; j++){
                Answer answ = new Answer(ans[j]);
                que.addAnswer(answ);
            }
        }
    }
}
