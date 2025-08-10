package LLD.SplitwiseDemo;

import LLD.SplitwiseDemo.ExpenseSplitStrategy.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    private String expenseId;
    private String description;
    private User paidUser;
    private ExpenseSplitType expenseSplitType;
    private List<Split> splitDetails = new ArrayList<>();

    private int expenseAmount;

    public Expense(String expenseId, String description, User paidUser, ExpenseSplitType expenseSplitType, List<Split> splitDetails, int expenseAmount) {
        this.expenseId = expenseId;
        this.description = description;
        this.paidUser = paidUser;
        this.expenseSplitType = expenseSplitType;
        this.splitDetails.addAll(splitDetails);
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(User paidUser) {
        this.paidUser = paidUser;
    }

    public ExpenseSplitType getExpenseSplitType() {
        return expenseSplitType;
    }

    public void setExpenseSplitType(ExpenseSplitType expenseSplitType) {
        this.expenseSplitType = expenseSplitType;
    }

    public List<Split> getSplitDetails() {
        return splitDetails;
    }

    public void setSplitDetails(List<Split> splitDetails) {
        this.splitDetails = splitDetails;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}
