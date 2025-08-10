package LLD.SplitwiseDemo.Controller;

import LLD.SplitwiseDemo.Expense;
import LLD.SplitwiseDemo.ExpenseSplitStrategy.*;
import LLD.SplitwiseDemo.Split;
import LLD.SplitwiseDemo.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, int expenseAmount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){

        ExpenseSplitStrategy expenseSplit = switch (splitType) {
            case EQUAL -> new EqualExpenseSplit();
            case UN_EQUAL -> new UnEqualExpenseSplit();
            case PERCENTAGE -> new PercentageExpenseSplit();
            default -> throw new IllegalArgumentException("Invalid split type");
        };

        expenseSplit.validateExpense(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, description, paidByUser, splitType, splitDetails, expenseAmount);

        balanceSheetController.updateBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
    }
}
