package MachineCodingRound.FlipkartWallet.dao;

import MachineCodingRound.FlipkartWallet.model.Transaction;

import java.util.HashMap;
import java.util.List;

public class TransactionRepository {
    private final HashMap<String, List<Transaction>> transactionRegistry;

    public TransactionRepository() {
        this.transactionRegistry = new HashMap<>();
    }

    public HashMap<String, List<Transaction>> getTransactionRegistry() {
        return transactionRegistry;
    }
}
