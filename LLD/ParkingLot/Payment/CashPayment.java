package LLD.ParkingLot.Payment;

public class CashPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("processing the cash payment of " + amount);
        // logic for the cash payment.
    }
}
