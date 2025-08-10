package LLD.SplitwiseDemo.ExpenseSplitStrategy;

import LLD.SplitwiseDemo.Split;

import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplitStrategy{
    @Override
    public void validateExpense(List<Split> splitList, int totalAmount) {
        double totalPercentage = 0;
        for (Split split : splitList) {
            totalPercentage += split.getAmountOwe();
        }
        if (totalPercentage != totalAmount) {
            throw new IllegalArgumentException("Total percentage must sum up to 100%");
        }

    }
}
