package structuralPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
interface Box {
    void unboxItem();
}

class Item implements Box {
    private String item;
    public Item(String item){
        this.item = item;
    }

    @Override
    public void unboxItem() {
        System.out.println(item);
    }
}
 class DeliveryBox implements Box {
    private List<Box> boxList ;

     public DeliveryBox(List<Box> boxList) {
         this.boxList = boxList;
     }

     public void addiItem(Box box) {
         this.boxList.add(box);
     }
     @Override
     public void unboxItem() {
         for( Box boxes: boxList) {
             boxes.unboxItem();
         }
     }
 }

public class Composite {
    public static void main(String[] args) {
        Item item1 = new Item("bat");
        Item item2 = new Item("ipad");
        Item item3 = new Item("dahi");
        Item item4 = new Item("chips");

        List<Box> list = new ArrayList<>();
        list.add(item2);
        list.add(item3);

        List<Box> list1 = new ArrayList<>();
        list1.add(item1);
        list1.add(item4);
        DeliveryBox deliveryBox1 = new DeliveryBox(list1);
        list.add(deliveryBox1);

        DeliveryBox deliveryBox = new DeliveryBox(list);
        deliveryBox.unboxItem();

        // overall structure (tree structure)
        //       deliveryBox
        //       /        \   |_______________________
        //      /          \                         |
        //   ipad (leaf)     dahi(leaf)   deliveryBox1(composite object)
        //                                           |
        //                              |
        //                             bat(item)(leaf)
    }

}