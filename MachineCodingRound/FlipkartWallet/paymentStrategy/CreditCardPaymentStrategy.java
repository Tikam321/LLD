package MachineCodingRound.FlipkartWallet.paymentStrategy;

public class CreditCardPaymentStrategy implements paymentStrategy{
    @Override
    public void payment(double amount) {
        System.out.println("Topup of amount " + amount + "paid though CC payment method");
        // cc payment gateway logic
    }
}
