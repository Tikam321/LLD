package MachineCodingRound.StackOverflow;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private int reputationPoints;
    private final List<Question> askedQuestions;
    private final  List<Answer> answers;
    private final List<Comment> comments;
    public static final int  POST_QUESTION = 25;
    public static final int  POST_COMMENT = 5;
    public static final int  POST_ANSWER = 15;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.reputationPoints = 0;
        this.askedQuestions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void postQuestion(Question question) {
        askedQuestions.add(question);
        reputationPoints += POST_QUESTION;
    }

    public void postAnswer(Answer answer) {
        answers.add(answer);
        reputationPoints += POST_ANSWER;
    }

    public void postComment(Comment comment) {
        comments.add(comment);
        reputationPoints += POST_COMMENT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReputationPoints() {
        return reputationPoints;
    }

    public void setReputationPoints(int reputationPoints) {
        this.reputationPoints = reputationPoints;
    }

    public List<Question> getAskedQuestions() {
        return askedQuestions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
