package MachineCodingRound.FlipkartWallet.service;

import MachineCodingRound.FlipkartWallet.dao.UserRepository;
import MachineCodingRound.FlipkartWallet.dao.WalletRepository;
import MachineCodingRound.FlipkartWallet.enums.PaymentType;
import MachineCodingRound.FlipkartWallet.exception.UserNotFoundException;
import MachineCodingRound.FlipkartWallet.model.User;
import MachineCodingRound.FlipkartWallet.model.Wallet;
import MachineCodingRound.FlipkartWallet.paymentStrategy.paymentStrategy;

public class WalletService {
    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final PaymentService paymentService;

    public WalletService(UserRepository userRepository, WalletRepository walletRepository) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.paymentService = new PaymentService();
    }

    public void registerUser(String userName) {
        if (userRepository.getUserRegistry().containsKey(userName)) {
            System.out.println("user with name " + userName + "is already registered");
        } else {
            User user = new User(userName);
            userRepository.getUserRegistry().put(user.getName(), user);
            walletRepository.getWalletHashMap().put(userName, new Wallet(0));
            System.out.println(userName + " is registered with flipkart wallet");
        }
    }

    public void topUpWallet(String userName, PaymentType paymentType, double amount) {
        Wallet wallet = walletRepository.getWalletHashMap().get(userName);
        paymentStrategy paymentStrategy = paymentService.paymentProcess(paymentType);
        paymentStrategy.payment(amount);
        wallet.addMoney(amount);
        System.out.println(userName + "TopUp of " + amount + "is added to wallet for.");
    }

    public void fetchBalance(String userName) throws UserNotFoundException {
        Wallet wallet = walletRepository.getWalletHashMap().get(userName);
        if (wallet != null) {
            System.out.println(userName + " Account balance is " + wallet.getBalance());
        } else {
            throw new UserNotFoundException("User not found");
        }
    }


}
