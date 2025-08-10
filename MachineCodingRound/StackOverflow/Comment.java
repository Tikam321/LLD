package MachineCodingRound.StackOverflow;

public class Comment {

    private String description;
    private User requestedUser;

    public Comment(String description, User requestedUser) {
        this.description = description;
        this.requestedUser = requestedUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getRequestedUser() {
        return requestedUser;
    }

    public void setRequestedUser(User requestedUser) {
        this.requestedUser = requestedUser;
    }
}
