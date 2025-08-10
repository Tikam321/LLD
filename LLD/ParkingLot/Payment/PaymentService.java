package LLD.ParkingLot.Payment;

import java.util.Scanner;

public class PaymentService {
    private Scanner scanner;

    public PaymentService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processPayment(double fee) {
        // user interface
        choosePayment(fee);
    }

    private void choosePayment(double fee) {
        System.out.println("Total bill is " + fee);
        System.out.println("choose payment method");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. UPI");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> new Payment(fee, new CashPayment()).processPayment();
            case 2 -> new Payment(fee, new CardPayment()).processPayment();
            case 3 -> new Payment(fee, new UPIPayment()).processPayment();
            default -> {
                System.out.println("invalid payment method defaulting to cash payment");
                new Payment(fee, new CardPayment()).processPayment();
            }
        }
    }
}
