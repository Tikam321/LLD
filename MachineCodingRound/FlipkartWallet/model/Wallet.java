package MachineCodingRound.FlipkartWallet.model;

public class Wallet {
    private double balance;

    public Wallet(double balance) {
        this.balance = balance;
    }


    public void addMoney(double amount) {
        this.balance += amount;
    }
    public void withdrawMoney(double amount) {
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
