package LLD.ATM;

import LLD.ParkingLot.Vehicle.Car;

public class ATM {
    private int id;
    private ATMState currentState;
    private int balance;
    private final String pin = "1234";

    private Card card = null;

    private int cashToBeWithdraw = 0;

    private ATMFactory atmFactory = new ATMFactory();

    public ATM(int id,int balance) {
        this.currentState = atmFactory.createAtmState(ATMStateType.IDLE_STATE);
        this.balance = balance;
        this.id = id;
    }

    public void insertCard(Card card) {
        this.card = card;
        this.currentState.insertCard(this, card);
    }

    public void enterPin(String pin) {
        this.currentState.enterPin(this,pin);
    }
    void withdrawMoney( int amount) {
        this.currentState.withdrawMoney(this,amount);
    }
    void dispenseCash() {
        this.currentState.dispenseCash(this);
    }
    void insufficientBalance() {
        this.currentState.insufficientBalance(this);
    }
    void cancelOperation() {
        this.currentState.cancelOperation(this);
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public int getCashToBeWithdraw() {
        return cashToBeWithdraw;
    }

    public void setCashToBeWithdraw(int cashToBeWithdraw) {
        this.cashToBeWithdraw = cashToBeWithdraw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
