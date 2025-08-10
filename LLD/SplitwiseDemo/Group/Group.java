package LLD.SplitwiseDemo.Group;

import LLD.SplitwiseDemo.Controller.ExpenseController;
import LLD.SplitwiseDemo.Expense;
import LLD.SplitwiseDemo.ExpenseSplitStrategy.ExpenseSplitType;
import LLD.SplitwiseDemo.Split;
import LLD.SplitwiseDemo.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;

    List<Expense> expenseList;

    ExpenseController expenseController;

    public Group(){
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    //add member to group
    public void addMember(User member) {
        if (groupMembers.contains(member)) {
            System.out.println("User " + member.getUserName() + " is already a member of the group!");
        } else {
            groupMembers.add(member);
            System.out.println("User " + member.getUserName() + " added to the group.");
        }
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Expense> getExpenses() { // ✅ ADD THIS METHOD
        return expenseList;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }


    public Expense createExpense(String expenseId, String description, int expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {

        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidByUser);
        expenseList.add(expense);
        return expense;
    }


}
