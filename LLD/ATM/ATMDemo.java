package LLD.ATM;

public class ATMDemo {
    public static void main(String[] args) {
        Card debitCard = new Card("3421", "1233 1234 2342 2342");
        ATM atm = new ATM(12,5000);
        atm.insertCard(debitCard);
        atm.enterPin("3421");
        atm.withdrawMoney(450);
    }
}
