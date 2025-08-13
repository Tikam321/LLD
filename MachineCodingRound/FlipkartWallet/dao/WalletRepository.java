package MachineCodingRound.FlipkartWallet.dao;

import MachineCodingRound.FlipkartWallet.model.Wallet;

import java.util.HashMap;

public class WalletRepository {
    private final HashMap<String, Wallet> walletHashMap;

    public WalletRepository() {
        this.walletHashMap = new HashMap<>();
    }

    public HashMap<String, Wallet> getWalletHashMap() {
        return walletHashMap;
    }
}
