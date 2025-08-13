package MachineCodingRound.FlipkartWallet.controller;

import MachineCodingRound.FlipkartWallet.enums.PaymentType;
import MachineCodingRound.FlipkartWallet.enums.TransactionSortType;
import MachineCodingRound.FlipkartWallet.enums.TransactionType;
import MachineCodingRound.FlipkartWallet.exception.InSufficientBalance;
import MachineCodingRound.FlipkartWallet.exception.UserNotFoundException;
import MachineCodingRound.FlipkartWallet.service.TransactionService;
import MachineCodingRound.FlipkartWallet.service.WalletService;

public class FlipkartController {

    private  final TransactionService transactionService;
    private final WalletService walletService;

    public FlipkartController(TransactionService transactionService, WalletService walletService) {
        this.transactionService = transactionService;
        this.walletService = walletService;
    }

    public void registerUser(String user ) {
        walletService.registerUser(user);
    }

    public void topUpWallet(String userName, PaymentType paymentType, double amount) {
        walletService.topUpWallet(userName,paymentType, amount);
    }

    public void fetchBalance(String userName) throws UserNotFoundException {
          walletService.fetchBalance(userName);
    }

    public void sendMoney(String sender, String receiver, double amount)
            throws UserNotFoundException, InSufficientBalance {
        transactionService.sendMoney(sender, receiver, amount);
    }

    public void getTransaction(String userName, TransactionType transactionType, TransactionSortType transactionSortType) {
        transactionService.getTransactions(userName, transactionType, transactionSortType);
    }
}
