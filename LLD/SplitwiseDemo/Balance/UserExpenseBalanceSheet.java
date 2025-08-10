package LLD.SplitwiseDemo.Balance;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    private Map<String, Balance> userVsBalance;
    private int totalPayment;
    private int totalExpense;
    private int totalYouGotBack;
    private int amountToOwe;

    public UserExpenseBalanceSheet() {
        this.userVsBalance = new HashMap<>();
        this.totalPayment = 0;
        this.totalExpense = 0;
        this.totalYouGotBack = 0;
        this.amountToOwe = 0;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(int totalExpense) {
        this.totalExpense = totalExpense;
    }

    public int getTotalYouGotBack() {
        return totalYouGotBack;
    }

    public void setTotalYouGotBack(int totalYouGotBack) {
        this.totalYouGotBack = totalYouGotBack;
    }

    public int getAmountToOwe() {
        return amountToOwe;
    }

    public void setAmountToOwe(int amountToOwe) {
        this.amountToOwe = amountToOwe;
    }
}
