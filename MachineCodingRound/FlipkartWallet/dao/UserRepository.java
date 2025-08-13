package MachineCodingRound.FlipkartWallet.dao;

import MachineCodingRound.FlipkartWallet.model.User;

import java.util.HashMap;

public class UserRepository {
    private final HashMap<String, User> userRegistry;

    public UserRepository() {
        this.userRegistry = new HashMap<>();
    }

    public HashMap<String, User> getUserRegistry() {
        return userRegistry;
    }

}
