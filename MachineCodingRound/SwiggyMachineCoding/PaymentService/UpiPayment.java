package MachineCodingRound.SwiggyMachineCoding.PaymentService;

public class UpiPayment implements PaymentProcess{
    @Override
    public void payment(double amount) {
        System.out.println("payment of " + amount + "through UPI has successfully paid.");
    }
}
