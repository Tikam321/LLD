package MachineCodingRound.FlipkartWallet.comparator;

import MachineCodingRound.FlipkartWallet.model.Transaction;

public interface StrategyComparator {
    public int compare(Transaction o1, Transaction o2);
}
