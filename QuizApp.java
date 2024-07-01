import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    private static List<Quiz> quizzes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nQuiz Application");
            System.out.println("1. Create Quiz");
            System.out.println("2. Add Question to Quiz");
            System.out.println("3. Take Quiz");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    createQuiz();
                    break;
                case 2:
                    addQuestionToQuiz();
                    break;
                case 3:
                    takeQuiz();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createQuiz() {
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        quizzes.add(new Quiz(title));
        System.out.println("Quiz created: " + title);
    }

    private static void addQuestionToQuiz() {
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        Quiz quiz = findQuiz(title);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }

        System.out.print("Enter question text: ");
        String questionText = scanner.nextLine();
        List<String> options = new ArrayList<>();
        System.out.println("Enter options (type 'done' to finish):");
        while (true) {
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("done")) {
                break;
            }
            options.add(option);
        }

        System.out.print("Enter the number of the correct option: ");
        int correctAnswerIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline

        quiz.addQuestion(new Question(questionText, options, correctAnswerIndex));
        System.out.println("Question added to quiz: " + title);
    }

    private static void takeQuiz() {
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        Quiz quiz = findQuiz(title);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }

        quiz.takeQuiz();
    }

    private static Quiz findQuiz(String title) {
        for (Quiz quiz : quizzes) {
            if (quiz.getTitle().equalsIgnoreCase(title)) {
                return quiz;
            }
        }
        return null;
    }
}
