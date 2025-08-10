package LLD.VendingMachine;

public class VendingMachineDemo {
    public static void main(String[] args)  {
        Inventory inventory = new Inventory();
        Item pepsi = new Item(ItemType.PEPSI, 40);
        Item coke = new Item(ItemType.COKE, 35);
        Item juice = new Item(ItemType.JUICE, 25);
        inventory.addItem(pepsi,5);
        inventory.addItem(coke, 6);
        inventory.addItem(juice, 7);

        VendingMachine vendingMachine = new VendingMachine(inventory);
        VendingState currentState = vendingMachine.getVendingState();


        // press coin insert button
        currentState.PressInsertButton(vendingMachine); // in HasMoneyState

        //insert some Notes
         currentState = vendingMachine.getVendingState();
        currentState.insertCoin(vendingMachine, Note.FIVE);
        currentState.insertCoin(vendingMachine, Note.TEN);
//        currentState.insertCoin(vendingMachine, Note.TWENTY_FIVE);
//        currentState.insertCoin(vendingMachine, Note.FIVE);



        // HasMoneyState to SelectState
        currentState.selectProductButton(vendingMachine);

        currentState = vendingMachine.getVendingState();

        // choose product (Select state to Dispense state)
        try {
            currentState.chooseProduct(vendingMachine, pepsi);
        } catch (Exception e) {
            System.out.println("Insufficient balance");
        }

        currentState = vendingMachine.getVendingState();

        currentState.dispenseProduct(vendingMachine);

        System.out.println(currentState);
    }
}
