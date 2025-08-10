package BehaviouralPattern;



interface Payment  {
    void pay(int amount);
}

class CreditCardPayment implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println("Credit Card payment " + amount);
    }
}

class UpiCardPayment implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println("Upi Card payment " + amount);
    }
}

class PaymentProcess {
    private Payment payment;
    public PaymentProcess(Payment payment) {
        this.payment = payment;
    }

    void setPayment(Payment payment) {
        this.payment = payment;
    }

    void payment(int amount) {
        payment.pay(amount);
    }

}

public class StrategyPattern {
    public static void main(String[] args) {

        // Credit Card payment
        Payment creditCard = new CreditCardPayment();
        PaymentProcess paymentProcess = new PaymentProcess(creditCard);
        paymentProcess.payment(500);

        // cash payment
        Payment upiPayment = new UpiCardPayment();
        paymentProcess.setPayment(upiPayment); // changing the payment object at runtime
        paymentProcess.payment(450);

    }
}