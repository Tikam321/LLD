package MachineCodingRound.LinkedInLearningMachineCoding;

import java.util.Date;

public class Connection {
    private User requestedUser;
    private Date timeStamp;

    public Connection(User requestedUser, Date timeStamp) {
        this.requestedUser = requestedUser;
        this.timeStamp = timeStamp;
    }

    public User getRequestedUser() {
        return requestedUser;
    }

    public void setRequestedUser(User requestedUser) {
        this.requestedUser = requestedUser;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
