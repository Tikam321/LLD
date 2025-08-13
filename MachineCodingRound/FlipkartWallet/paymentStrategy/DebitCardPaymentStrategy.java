package MachineCodingRound.FlipkartWallet.paymentStrategy;

public class DebitCardPaymentStrategy implements paymentStrategy{
    @Override
    public void payment(double amount) {
        System.out.println("Topup of amount " + amount + "paid through DB payment method");
        // Debit card payment gateway logic
    }
}
