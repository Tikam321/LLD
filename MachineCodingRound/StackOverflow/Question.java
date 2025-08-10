package MachineCodingRound.StackOverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Question {
    private String title;
    private String description;
    private final  List<Answer> answersToQuestion;
    private final  List<Comment> commentsToQuestion;
    private int votes ;
    private final List<Tag> tags;
    private ReentrantLock lock = new ReentrantLock();

    public Question(String title, String description, List<Tag> tags) {
        this.title = title;
        this.description = description;
        answersToQuestion = new ArrayList<>();
        commentsToQuestion = new ArrayList<>();
        votes = 0;
        this.tags = tags;
    }

    public void upVote(User user) {
        lock.lock();
        try{
            if (user.getReputationPoints() > 25) {
                votes += 1;
                System.out.println(user.getName() + " has up voted the question " + title);
            } else {
                System.out.println("User " + user.getId() + " must have reputationPoints more than 25 to cast up Vote");
            }
        } finally {
            lock.unlock();
        }

    }

    public void downVote(User user) {
        lock.lock();
        try {
            if (user.getReputationPoints() > 25) {
                votes -= 1;
                System.out.println(user.getName() + " has down voted the question " + title);

            } else {
                System.out.println("User " + user.getId() + " must have reputationPoints more than 25 to cast down Vote");
            }
        } finally {
            lock.unlock();
        }
    }
    public void postAnswer(Answer answer) {
        lock.lock();
        try {
            answersToQuestion.add(answer);
        } finally {
            lock.unlock();
        }
    }

    public void postComment(Comment comment) {
        lock.lock();
        try {
            commentsToQuestion.add(comment);
        } finally {
            lock.unlock();
        }
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswersToQuestion() {
        return answersToQuestion;
    }

    public List<Comment> getCommentsToQuestion() {
        return commentsToQuestion;
    }

    public List<Tag> getTags() {
        return tags;
    }
}
