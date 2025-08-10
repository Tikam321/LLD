package LLD.ATM;

interface  ATMState {
     void insertCard(ATM atm, Card card);
     void enterPin(ATM atm, String pin);
     void withdrawMoney(ATM atm, int amount);
     void dispenseCash(ATM atm);
     void insufficientBalance(ATM atm);
     void cancelOperation(ATM atm);
     void ejectCard(ATM atm);
}
