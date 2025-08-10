package MachineCodingRound.StackOverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Answer {
    private String description;
    private final List<Comment> comments;
    private int votes;
    private ReentrantLock lock = new ReentrantLock();


    public Answer(String description) {
        this.description = description;
        comments = new ArrayList<>();
        this.votes = 0;
    }

    public void upVote(User user) {
        lock.lock();
        try{
            if (user.getReputationPoints() > 25) {
                votes += 1;
                System.out.println(user.getName() + " has up voted the Answer " + description);
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
                System.out.println(user.getName() + " has down voted the question " + description);

            } else {
                System.out.println("User " + user.getId() + " must have reputationPoints more than 25 to cast down Vote");
            }
        } finally {
            lock.unlock();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<Comment> getComments() {
        return comments;
    }
}
