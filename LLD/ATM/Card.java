package LLD.ATM;

public class Card {
    private String pin;
    private String cardNumber;

    public Card(String pin, String cardNumber) {
        this.pin = pin;
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
