package MachineCodingRound.LinkedInLearningMachineCoding;

import java.util.Date;

public class Message {
    private User requestedUser;
    private String message;
    private Date timeStamp;

    public Message(User requestedUser, String message, Date timeStamp) {
        this.requestedUser = requestedUser;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public User getRequestedUser() {
        return requestedUser;
    }

    public void setRequestedUser(User requestedUser) {
        this.requestedUser = requestedUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
