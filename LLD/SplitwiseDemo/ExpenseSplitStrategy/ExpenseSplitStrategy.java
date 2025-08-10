package LLD.SplitwiseDemo.ExpenseSplitStrategy;

import LLD.SplitwiseDemo.Split;

import java.util.List;

public interface ExpenseSplitStrategy {

    void validateExpense(List<Split> splitDetails, int amountPaid);

}
