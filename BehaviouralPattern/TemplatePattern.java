package BehaviouralPattern;



abstract class PaymentProcessor  {
    protected abstract void validate();
    protected abstract void debit();
    protected abstract void calculateFee();
    protected abstract void credit();

    public final void processPayment() {
        // step1
        validate();

        //step2
        debit();

        //step3
        calculateFee();

        //step4
        credit();
    }
}

class CreditCardPaymentProcessor extends PaymentProcessor {

    protected void validate() {
        System.out.println("credit card payment -> logic for validate");
    }

    @Override
    protected void debit() {
        System.out.println("credit card -> debit logic");
    }

    @Override
    protected void calculateFee() {
        System.out.println("credit card -> calculate logic");
    }

    @Override
    protected void credit() {
        System.out.println("credit card -> credit logic");
    }
}

class CashPaymentProcessor extends PaymentProcessor {

    protected void validate() {
        System.out.println("Cash payment -> logic for validate");
    }

    @Override
    protected void debit() {
        System.out.println("Cash card -> debit logic");
    }

    @Override
    protected void calculateFee() {
        System.out.println("Cash card -> calculate logic");
    }

    @Override
    protected void credit() {
        System.out.println("Cash card -> credit logic");
    }

}

public class TemplatePattern {
    public static void main(String[] args) {
        CashPaymentProcessor cashPaymentProcessor = new CashPaymentProcessor();

        // cash payment
        cashPaymentProcessor.processPayment();

        // credit card payment
        CreditCardPaymentProcessor creditCardPaymentProcessor = new CreditCardPaymentProcessor();
        creditCardPaymentProcessor.processPayment();
    }
}


