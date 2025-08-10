package LLD.SplitwiseDemo.Controller;

import LLD.SplitwiseDemo.Balance.Balance;
import LLD.SplitwiseDemo.Balance.UserExpenseBalanceSheet;
import LLD.SplitwiseDemo.Split;
import LLD.SplitwiseDemo.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    public void updateBalanceSheet(User payer, List<Split> splits, int totalExpense) {
        UserExpenseBalanceSheet paidUserBalanceSheet = payer.getUserExpenseBalanceSheet();

        // adding the expenseAmount to TotalPayment of paid user
        paidUserBalanceSheet.setTotalPayment(paidUserBalanceSheet.getTotalPayment() + totalExpense);

        for(Split split: splits) {
            User personWhoOwes = split.getUser();  // The person who has to pay back
            UserExpenseBalanceSheet owesSheet = personWhoOwes.getUserExpenseBalanceSheet(); //Jo banda paisa dene wala hai, uski balance sheet nikal lo taaki uske records update kar sakein.
            int amountToPay = split.getAmountOwe();  // Kitna paisa dena hai

            if (personWhoOwes.getUserId().equals(payer.getUserId())) {
                paidUserBalanceSheet.setTotalExpense(paidUserBalanceSheet.getTotalExpense() + amountToPay);
            } else {
                // amount to get back by paid user
                paidUserBalanceSheet.setTotalYouGotBack(paidUserBalanceSheet.getTotalYouGotBack() + amountToPay);

//                UserExpenseBalanceSheet owesBalanceSheet = personWhoOwes.getUserExpenseBalanceSheet();
//                owesSheet.getUserVsBalance().computeIfAbsent(payer.getUserId(), k -> new Balance());

                // Store how much this person has to return to payer
                Balance payerBalance = paidUserBalanceSheet.getUserVsBalance()
                        .computeIfAbsent(personWhoOwes.getUserId(), k -> new Balance());
                payerBalance.setAmountGetBack(payerBalance.getAmountGetBack() + amountToPay);

                // Update the balance of the person who owes money (jisne paisa dena hai)
                owesSheet.setAmountToOwe(owesSheet.getAmountToOwe() + amountToPay);
                owesSheet.setTotalExpense(owesSheet.getTotalExpense() + amountToPay);

                // Store how much this person owes to payer (Jis bande ko paisa dena hai (personWhoOwes), uska record update kar rahe hain ki usne payer ko kitna paisa dena hai.)
                Balance owesBalance = owesSheet.getUserVsBalance()
                        .computeIfAbsent(payer.getUserId(), k -> new Balance());
                owesBalance.setAmountOwe(owesBalance.getAmountOwe() + amountToPay);
            }
        }

        // Get balance sheet of the person who paid (jisne paisa diya)
//        UserExpenseBalanceSheet payerSheet = payer.getUserExpenseBalanceSheet();
//        payerSheet.setTotalPayment(payerSheet.getTotalPayment() + totalExpense);
//
//        // Go through each person who needs to pay (jo contribute karega)
//        for (Split split : splits) {
//            User personWhoOwes = split.getUser();  // The person who has to pay back
//            UserExpenseBalanceSheet owesSheet = personWhoOwes.getUserExpenseBalanceSheet(); //Jo banda paisa dene wala hai, uski balance sheet nikal lo taaki uske records update kar sakein.
//            int amountToPay = split.getAmountOwe();  // Kitna paisa dena hai
//
//            if (payer.getUserId().equals(personWhoOwes.getUserId())) {
//                // If payer is also involved in expense, update their expense share
//                payerSheet.setTotalExpense(payerSheet.getTotalExpense() + amountToPay);
//            } else {
//                // Payer ka paisa wapas aana chahiye
//                payerSheet.setTotalYouGotBack(payerSheet.getTotalYouGotBack() + amountToPay);
//
//                // Store how much this person has to return to payer
//                Balance payerBalance = payerSheet.getUserVsBalance()
//                        .computeIfAbsent(personWhoOwes.getUserId(), k -> new Balance());
//                payerBalance.setAmountGetBack(payerBalance.getAmountGetBack() + amountToPay);
//
//                // Update the balance of the person who owes money (jisne paisa dena hai)
//                owesSheet.setAmountToOwe(owesSheet.getAmountToOwe() + amountToPay);
//                owesSheet.setTotalExpense(owesSheet.getTotalExpense() + amountToPay);
//
//                // Store how much this person owes to payer (Jis bande ko paisa dena hai (personWhoOwes), uska record update kar rahe hain ki usne payer ko kitna paisa dena hai.)
//                Balance owesBalance = owesSheet.getUserVsBalance()
//                        .computeIfAbsent(payer.getUserId(), k -> new Balance());
//                owesBalance.setAmountOwe(owesBalance.getAmountOwe() + amountToPay);
//            }
//        }

    }

    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGotBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getAmountToOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPayment());
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }
}

