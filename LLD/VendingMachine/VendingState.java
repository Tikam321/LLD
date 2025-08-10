package LLD.VendingMachine;

public abstract class VendingState {
    public abstract void PressInsertButton(VendingMachine vendingMachine);
    public abstract void insertCoin(VendingMachine vendingMachine, Note note);
    public abstract void selectProductButton(VendingMachine vendingMachine);
    public abstract void chooseProduct(VendingMachine vendingMachine, Item item) throws Exception;
    public abstract void dispenseProduct(VendingMachine vendingMachine);
    public abstract void cancelPayment(VendingMachine vendingMachine);
    public abstract void refundMoney(VendingMachine vendingMachine);

}
