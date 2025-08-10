package LLD.ParkingLot.Payment;

public class UPIPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("payment from UPI of amount "+ amount);
        // logic for the upi payment
    }
}
