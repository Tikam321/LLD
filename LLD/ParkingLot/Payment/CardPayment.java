package LLD.ParkingLot.Payment;

public class CardPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("process payment of amount "  + amount +" through credeit card");
        // logic for the card payment
    }
}
