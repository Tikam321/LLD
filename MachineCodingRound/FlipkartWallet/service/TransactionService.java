package MachineCodingRound.FlipkartWallet.service;

import MachineCodingRound.FlipkartWallet.comparator.AmountBasedComparator;
import MachineCodingRound.FlipkartWallet.comparator.StrategyComparator;
import MachineCodingRound.FlipkartWallet.comparator.TimesBasedComparator;
import MachineCodingRound.FlipkartWallet.dao.TransactionRepository;
import MachineCodingRound.FlipkartWallet.dao.UserRepository;
import MachineCodingRound.FlipkartWallet.dao.WalletRepository;
import MachineCodingRound.FlipkartWallet.enums.TransactionSortType;
import MachineCodingRound.FlipkartWallet.enums.TransactionType;
import MachineCodingRound.FlipkartWallet.exception.InSufficientBalance;
import MachineCodingRound.FlipkartWallet.exception.UserNotFoundException;
import MachineCodingRound.FlipkartWallet.model.Transaction;
import MachineCodingRound.FlipkartWallet.model.User;
import MachineCodingRound.FlipkartWallet.model.Wallet;

import java.util.*;
import java.util.stream.Collectors;

public class TransactionService {
        private UserRepository userRepository;
        private WalletRepository walletRepository;
        private TransactionRepository transactionRepository;

        public TransactionService(UserRepository userRepository, WalletRepository walletRepository, TransactionRepository transactionRepository) {
                this.userRepository = userRepository;
                this.walletRepository = walletRepository;
                this.transactionRepository = transactionRepository;
        }

        public void sendMoney(String sender, String receiver, double amount) throws UserNotFoundException, InSufficientBalance {
                HashMap<String, User> userRegistry = userRepository.getUserRegistry();
                HashMap<String, List<Transaction>> transactionRegistry = transactionRepository.getTransactionRegistry();
                if (userRegistry.containsKey(sender) && userRegistry.containsKey(receiver)) {
                        Wallet receiverWallet = walletRepository.getWalletHashMap().get(receiver);
                        Wallet senderWallet = walletRepository.getWalletHashMap().get(sender);
                        if (amount > 0 && senderWallet.getBalance() > amount) {
                                receiverWallet.addMoney(amount);
                                senderWallet.withdrawMoney(amount);
                               Transaction senderTransaction = new Transaction(receiver, new Date(System.currentTimeMillis()), TransactionType.SEND, amount);
                               Transaction receiverTransaction = new Transaction(sender, new Date(System.currentTimeMillis()), TransactionType.RECEIVE, amount);
                                transactionRegistry.computeIfAbsent(sender, k -> new ArrayList<>())
                                        .add(senderTransaction);
                                transactionRegistry.computeIfAbsent(receiver, k -> new ArrayList<>())
                                        .add(receiverTransaction);
                                System.out.println(sender + " send money to " + receiver + "successfully.");
                        }
                         else {
                              throw new InSufficientBalance(sender + "does not have sufficient account balance to transfer " + amount);
                        }
                } else {
                        throw  new UserNotFoundException("either sender or receiver not exist");
                }
        }

        public  void getTransactions(String user, TransactionType transactionType, TransactionSortType transactionSortType) {
                HashMap<String, User> userRegistry = userRepository.getUserRegistry();
                List<Transaction> transactionList = new ArrayList<>();
                if (userRegistry.containsKey(user)) {
                        if (transactionSortType.equals(TransactionSortType.AMOUNT)) {
                                transactionList = getSortedTransaction(user,transactionType, new AmountBasedComparator());
                        } else {
                                transactionList = getSortedTransaction(user,transactionType, new TimesBasedComparator());
                        }
                }
                if (transactionList.size() > 0) {
                        if (transactionType == TransactionType.SEND) {
                                transactionList.forEach(transaction -> System.out.println(user + " -> " + transaction.getUserName()
                                        + " amount: " + transaction.getAmount()));
                        } else {
                                transactionList.forEach(transaction -> System.out.println(transaction.getUserName() + " -> " + user
                                        + " amount: " + transaction.getAmount()));
                        }
                } else {
                        System.out.println("there is not transaction list exist");
                }
        }

        private List<Transaction> getSortedTransaction(String user, TransactionType transactionType, StrategyComparator strategyComparator) {
                List<Transaction> transactionList = transactionRepository.getTransactionRegistry().get(user);
                return transactionList.stream().
                        filter(transaction -> transaction.getTransactionType().equals(transactionType)).
                        sorted((Comparator<? super Transaction>) strategyComparator).collect(Collectors.toList());


        }
}
