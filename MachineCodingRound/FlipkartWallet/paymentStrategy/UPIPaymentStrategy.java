package MachineCodingRound.FlipkartWallet.paymentStrategy;

public class UPIPaymentStrategy implements paymentStrategy{

    @Override
    public void payment(double amount) {
        System.out.println("Topup of amount " + amount + "paid though UPI payment method");
        // upi payment gateway logic
    }
}
