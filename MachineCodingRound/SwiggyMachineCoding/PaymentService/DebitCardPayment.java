package MachineCodingRound.SwiggyMachineCoding.PaymentService;

public class DebitCardPayment implements PaymentProcess{
    @Override
    public void payment(double amount) {
        System.out.println("payment of " + amount + "through Debit card has successfully paid.");
    }
}
