package at.spengergasse._2xhif.domain.content;

public class QuizContent extends Content {

    public QuizContent(Long id, String name, String description) {
        super(id, name, description);
    }

    @Override
    public void present() {
        System.out.println("Presenting the quiz!");
    }
}
