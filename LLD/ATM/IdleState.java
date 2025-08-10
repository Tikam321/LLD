package LLD.ATM;

public class IdleState implements ATMState{

    private ATMFactory atmFactory;
    public IdleState() {
        atmFactory = new ATMFactory();
    }

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("card is inserted..");
        atm.setCurrentState(atmFactory.createAtmState(ATMStateType.CARD_READING_STATE));
    }

    @Override
    public void enterPin(ATM atm, String pin) {
        System.out.println("First insert the card");
    }

    @Override
    public void withdrawMoney(ATM atm, int amount) {
        System.out.println("first insert the card");
    }

    @Override
    public void dispenseCash(ATM atm) {
        System.out.println("first insert the card");
    }

    @Override
    public void insufficientBalance(ATM atm) {
        System.out.println("first insert the card");
    }

    @Override
    public void cancelOperation(ATM atm) {
        System.out.println("first insert the card");

    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card is ejected");
        System.out.println("please take out your card and insert again");
        atm.setCurrentState(atmFactory.createAtmState(ATMStateType.IDLE_STATE));
    }
}
