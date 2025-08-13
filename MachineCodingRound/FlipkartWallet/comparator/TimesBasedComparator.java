package MachineCodingRound.FlipkartWallet.comparator;

import MachineCodingRound.FlipkartWallet.model.Transaction;

import java.util.Comparator;

public class TimesBasedComparator implements Comparator<Transaction>, StrategyComparator {
    @Override
    public int compare(Transaction o1, Transaction o2) {
        return o1.getTimeStamp().compareTo(o2.getTimeStamp());
    }

}
