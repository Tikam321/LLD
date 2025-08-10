package LLD.ParkingLot.Payment;

public class Payment {
    private double amount;
    private PaymentStrategy paymentStrategy;

    public Payment(double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    void processPayment() {
        if (this.amount > 0) {
            paymentStrategy.processPayment(amount);
        } else {
            System.out.println("invalid amount is entered here please check");
        }
    }
}
