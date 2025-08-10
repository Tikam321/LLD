package LLD.VendingMachine;

public class IdleState extends VendingState{
    @Override
    public void PressInsertButton(VendingMachine vendingMachine) {
        System.out.println("insert Coin button is pressed");
        vendingMachine.setVendingState(new HasMoneyState());
        System.out.println("the state changed from idle to HasMoney state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Note note) {
        System.out.println("press insert button before coin insert.");
    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) {

    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, Item item) {

    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {

    }

    @Override
    public void cancelPayment(VendingMachine vendingMachine) {

    }

    @Override
    public void refundMoney(VendingMachine vendingMachine) {

    }
}
