package LLD.VendingMachine;

import java.sql.SQLOutput;

public class DispenseState extends VendingState{
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
    public void chooseProduct(VendingMachine vendingMachine, Item item) {

    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        Inventory inventory = vendingMachine.getInventory();
        Item item = vendingMachine.getItem();
        System.out.println(item);
        vendingMachine.getInventory().product.put(item, inventory.product.get(item) - 1);
        System.out.println("Product is " + item.getItemType() + "Dispensed");
        if (vendingMachine.isRefundEligible()) {
            System.out.println("Please collect the refund amount " + vendingMachine.getRefundAmount());
        }
        System.out.println("the state is changed to idle state");
        vendingMachine.setItem(null);
        vendingMachine.setVendingState(new IdleState());

    }

    @Override
    public void cancelPayment(VendingMachine vendingMachine) {

    }

    @Override
    public void refundMoney(VendingMachine vendingMachine) {

    }
}
