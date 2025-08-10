package LLD.SplitwiseDemo.ExpenseSplitStrategy;

import LLD.SplitwiseDemo.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplitStrategy{
    @Override
    public void validateExpense(List<Split> splitList, int amountPaid) {
        int amountShouldBePresent = amountPaid / splitList.size();
        for (Split split : splitList) {
            if (split.getAmountOwe() != amountShouldBePresent) {
                throw new IllegalArgumentException("Each person should have an equal split");
            }
        }
    }
}
