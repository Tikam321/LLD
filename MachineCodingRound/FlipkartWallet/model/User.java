package MachineCodingRound.FlipkartWallet.model;

import java.util.UUID;

public class User {
    private String userId;
    private String name;

    public User(String name) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
