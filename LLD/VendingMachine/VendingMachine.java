package LLD.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private VendingState vendingState;
    private int totalAmount;
    private Inventory inventory;
    private Item item;

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        this.vendingState = new IdleState();
        totalAmount = 0;
    }

    public void setVendingState(VendingState vendingState) {
        this.vendingState = vendingState;
    }

    public void addCoin(Note note) {
        this.totalAmount += note.getNote();
    }



    public VendingState getVendingState() {
        return this.vendingState;
    }

    public boolean isRefundEligible() {
        return item.getPrice() < totalAmount;
    }

    public int getRefundAmount() {
        int itemPrice = item.getPrice();
            return totalAmount - itemPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void resetAmount() {
        this.totalAmount = 0;
    }
    public int getTotalAmount() {
        return this.totalAmount;
    }
}
