package LLD.VendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    public Map<Item, Integer> product;

    public Inventory() {
        this.product = new ConcurrentHashMap<>();
    }

    public void addItem(Item item, int quantity) {
        product.put(item, quantity);
    }



    public void updateQuantity(Item item, int quantity) {
        product.put(item, quantity);
    }

}
