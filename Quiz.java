import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String title;
    private List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        int score = 0;
        int total = questions.size();
        
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.getQuestionText());
            for (int j = 0; j < q.getOptions().size(); j++) {
                System.out.println((j + 1) + ". " + q.getOptions().get(j));
            }
            System.out.print("Your answer: ");
            int answer = new java.util.Scanner(System.in).nextInt();
            if (q.isCorrect(answer - 1)) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect. The correct answer is: " + (q.getCorrectAnswerIndex() + 1) + ". " + q.getOptions().get(q.getCorrectAnswerIndex()) + "\n");
            }
        }
        
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + total);
    }
}
