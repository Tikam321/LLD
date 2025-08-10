package MachineCodingRound.SwiggyMachineCoding.PaymentService;

public class CashPayment implements PaymentProcess{
    @Override
    public void payment(double amount) {
        System.out.println("payment of " + amount + "through Cash payment has successfully paid.");
    }
}
