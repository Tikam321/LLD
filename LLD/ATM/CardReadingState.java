package LLD.ATM;

public class CardReadingState implements ATMState {
    private final ATMFactory atmFactory = new ATMFactory();
    public CardReadingState() {
        System.out.println("You are now in Card Reading State");
    }

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("card is already inserted, atm is Reading the card info");
    }

    @Override
    public void enterPin(ATM atm, String pin) {
        if (pin.equals(atm.getCard().getPin())) {
            System.out.println("password is successfully matched.");
            atm.setCurrentState(atmFactory.createAtmState(ATMStateType.TRANSACTION_STATE));
        } else {
            System.out.println("Entered pin number is incorrect");
            ejectCard(atm);
            atm.setCurrentState((atmFactory.createAtmState(ATMStateType.IDLE_STATE)));
        }
    }

    @Override
    public void withdrawMoney(ATM atm, int amount) {
        System.out.println("please enter pin n umber first.");
    }

    @Override
    public void dispenseCash(ATM atm) {
        System.out.println("ATM is in reading state");
    }

    @Override
    public void insufficientBalance(ATM atm) {
        System.out.println("ATM is in reading state");

    }

    @Override
    public void cancelOperation(ATM atm) {
        System.out.println("ATM is in reading state");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card is ejected");
        System.out.println("please take out your card and insert again");
        atm.setCurrentState(atmFactory.createAtmState(ATMStateType.IDLE_STATE));
    }
}
