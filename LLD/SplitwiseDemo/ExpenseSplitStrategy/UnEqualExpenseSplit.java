package LLD.SplitwiseDemo.ExpenseSplitStrategy;

import LLD.SplitwiseDemo.Split;

import java.util.List;

public class UnEqualExpenseSplit implements ExpenseSplitStrategy{
    @Override
    public void validateExpense(List<Split> splitList, int totalAmount) {
        double sum = 0;
        for (Split split : splitList) {
            sum += split.getAmountOwe();
        }
        if (sum != totalAmount) {
            throw new IllegalArgumentException("Split amounts do not match the total amount");
        }
    }
}
