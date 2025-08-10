package MachineCodingRound.StackOverflow;

public class Vote {
    private VoteType voteType;
    private User user;

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public Vote(VoteType voteType, User user) {
        this.voteType = voteType;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
