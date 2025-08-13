package MachineCodingRound.FlipkartWallet.service;

import MachineCodingRound.FlipkartWallet.enums.PaymentType;
import MachineCodingRound.FlipkartWallet.paymentStrategy.CreditCardPaymentStrategy;
import MachineCodingRound.FlipkartWallet.paymentStrategy.DebitCardPaymentStrategy;
import MachineCodingRound.FlipkartWallet.paymentStrategy.UPIPaymentStrategy;
import MachineCodingRound.FlipkartWallet.paymentStrategy.paymentStrategy;

public class PaymentService {
    public paymentStrategy paymentProcess(PaymentType paymentType) {
        paymentStrategy paymentStrategy = null;
        switch (paymentType) {
            case CC -> paymentStrategy = new CreditCardPaymentStrategy();
            case UPI -> paymentStrategy = new UPIPaymentStrategy();
            case DC -> paymentStrategy = new DebitCardPaymentStrategy();
        }
        return paymentStrategy;
    }
}
