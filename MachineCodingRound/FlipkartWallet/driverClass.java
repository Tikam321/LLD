package MachineCodingRound.FlipkartWallet;

import MachineCodingRound.DistributedQueue.Controller;
import MachineCodingRound.FlipkartWallet.controller.FlipkartController;
import MachineCodingRound.FlipkartWallet.dao.TransactionRepository;
import MachineCodingRound.FlipkartWallet.dao.UserRepository;
import MachineCodingRound.FlipkartWallet.dao.WalletRepository;
import MachineCodingRound.FlipkartWallet.enums.PaymentType;
import MachineCodingRound.FlipkartWallet.enums.TransactionSortType;
import MachineCodingRound.FlipkartWallet.enums.TransactionType;
import MachineCodingRound.FlipkartWallet.exception.InSufficientBalance;
import MachineCodingRound.FlipkartWallet.exception.UserNotFoundException;
import MachineCodingRound.FlipkartWallet.service.TransactionService;
import MachineCodingRound.FlipkartWallet.service.WalletService;

public class driverClass {
    public static void main(String[] args) throws UserNotFoundException, InSufficientBalance {
        UserRepository userRepository = new UserRepository();
        TransactionRepository transactionRepository = new TransactionRepository();
        WalletRepository  walletRepository = new WalletRepository();

        TransactionService transactionService = new TransactionService(userRepository, walletRepository,transactionRepository);
        WalletService walletService = new WalletService(userRepository, walletRepository);

        FlipkartController flipkartController = new FlipkartController(transactionService, walletService);

        flipkartController.registerUser("Bob");
        flipkartController.topUpWallet("Bob", PaymentType.CC, 1000);
        flipkartController.topUpWallet("Bob", PaymentType.UPI, 100);
        flipkartController.fetchBalance("Bob");

        flipkartController.registerUser("Alice");
        flipkartController.topUpWallet("Alice", PaymentType.CC, 100);

        flipkartController.fetchBalance("Alice");
        flipkartController.fetchBalance("Bob");
        try {
            flipkartController.sendMoney("Bob", "Alice", 550);
        } catch (InSufficientBalance e) {
            System.out.println(e.getMessage());
        }
        flipkartController.sendMoney("Bob", "Alice", 250);
        flipkartController.sendMoney("Alice","Bob", 50);

        flipkartController.fetchBalance("Bob");
        flipkartController.fetchBalance("Alice");

        flipkartController.getTransaction("Bob", TransactionType.SEND, TransactionSortType.AMOUNT);
        flipkartController.getTransaction("Bob", TransactionType.RECEIVE, TransactionSortType.TIME);


    }
}

