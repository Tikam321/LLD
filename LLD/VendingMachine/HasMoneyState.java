package LLD.VendingMachine;

public class HasMoneyState extends VendingState{
    @Override
    public void PressInsertButton(VendingMachine vendingMachine) {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Note note) {
        vendingMachine.addCoin(note);
        System.out.println("Rupees " + note.getNote() + " Added successfully.");
    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) {
        System.out.println("product select button is pressed...");
        System.out.println("the state changed to select state");
        vendingMachine.setVendingState(new SelectionState());
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
