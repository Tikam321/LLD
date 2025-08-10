package LLD.ATM;

public class TransactionState implements ATMState{
    private final ATMFactory atmFactory = new ATMFactory();

    public TransactionState() {
        System.out.println("ATM is in Transaction state");
    }

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("user is already inserted the card");

    }

    @Override
    public void enterPin(ATM atm, String pin) {
        System.out.println("user is already entered the pin number");
    }

    @Override
    public void withdrawMoney(ATM atm, int amount) {
        if (amount <= atm.getBalance()) {
            int remainBalance = atm.getBalance() - amount;
            atm.setBalance(remainBalance);
            System.out.println("User has successfully dispatch the " + amount + " Rupees");
            System.out.println("Account balance is " + remainBalance);
        } else {
            insufficientBalance(atm);
        }
        atm.setCurrentState(atmFactory.createAtmState(ATMStateType.IDLE_STATE));
    }

    @Override
    public void dispenseCash(ATM atm) {
        System.out.println("please first enter the amount that you want to dispense the cash.");
    }

    @Override
    public void insufficientBalance(ATM atm) {
        System.out.println("insufficient balance");
        System.out.println("please take out your card");

    }

    @Override
    public void cancelOperation(ATM atm) {
        System.out.println("Operation is canceled.");
        ejectCard(atm);
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card is ejected");
        System.out.println("please take out your card and insert again");
        atm.setCurrentState(atmFactory.createAtmState(ATMStateType.IDLE_STATE));
    }
}
