package LLD.ATM;

public class ATMFactory {
    public ATMState createAtmState(ATMStateType atmStateType) {
        ATMState atmState = new IdleState();
        switch (atmStateType) {
            case IDLE_STATE -> atmState = new IdleState();
            case CARD_READING_STATE -> atmState = new CardReadingState();
            case TRANSACTION_STATE -> atmState = new TransactionState();
        }
        return atmState;
    }
}
