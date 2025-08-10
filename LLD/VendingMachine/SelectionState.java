package LLD.VendingMachine;

public class SelectionState extends VendingState{
    @Override
    public void PressInsertButton(VendingMachine vendingMachine) {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Note note) {

    }

    @Override
    public void selectProductButton(VendingMachine vendingMachine) {

    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, Item item) throws Exception {
        if (checkPayment(vendingMachine, item)) {
            vendingMachine.setItem(item);
            System.out.println("Item " + item.getItemType() + " is selected");
            System.out.println("the state is changed to Dispense state");
            vendingMachine.setVendingState(new DispenseState());
        } else {
            refundFullMoney(vendingMachine);
            throw new Exception("insufficient Balance.");
        }
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

    public boolean checkPayment(VendingMachine vendingMachine, Item item) {
        return vendingMachine.getTotalAmount() >= item.getPrice();
    }
    public void refundFullMoney(VendingMachine vendingMachine) {
        vendingMachine.setVendingState(new IdleState());
        System.out.println("Returned the Full amount in Dispense tray " + vendingMachine.getTotalAmount());
        vendingMachine.resetAmount();
    }
}
