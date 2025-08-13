package MachineCodingRound.FlipkartWallet.comparator;

import MachineCodingRound.FlipkartWallet.model.Transaction;

import java.util.Comparator;

public class AmountBasedComparator implements Comparator<Transaction>, StrategyComparator {

    @Override
    public int compare(Transaction o1, Transaction o2) {
        return Double.compare(o1.getAmount(), o2.getAmount());
    }
}
