package BehaviouralPattern;


import com.sun.tools.javac.Main;

interface HotelRoom {
    void accept(Visitor visitor);
}

class SingleRoom implements HotelRoom {
    public int price;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class DoubleRoom implements HotelRoom {
    public int price;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class DeluxRoom implements HotelRoom {
    public int price;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface  Visitor {
    void visit(SingleRoom hotelRoom);
    void visit(DoubleRoom doubleRoom);
    void visit(DeluxRoom deluxRoom);
}

class PricingVisitor implements Visitor {
    public void visit(SingleRoom singleRoom) {
        singleRoom.price = 999;
        System.out.println("visit -> price for single room "+  singleRoom.price );
    }

    public void visit(DoubleRoom doubleRoom) {
        doubleRoom.price = 1999;
        System.out.println("visit -> price for single room " + doubleRoom.price);
    }

    public void visit(DeluxRoom deluxRoom) {
        deluxRoom.price = 2999;
        System.out.println("visit -> price for single room " + 2999);
    }
}

class MaintenanceVisitor implements Visitor {
    public void visit(SingleRoom singleRoom) {
        System.out.println("Maintenance -> for single room ");
    }

    public void visit(DoubleRoom singleRoom) {
        System.out.println("Maintenance -> for single room ");
    }

    public void visit(DeluxRoom singleRoom) {
        System.out.println("Maintenance -> for single room ");
    }

}


public class VisitorPatternDemo {
    public static void main(String[] args) {
//        SingleRoom singleRoom = new SingleRoom();
//        DoubleRoom doubleRoom = new DoubleRoom();
//        DeluxRoom deluxRoom = new DeluxRoom();
//
//        // pricing logic for all the room types( separate class)
//        PricingVisitor pricingVisitor = new PricingVisitor();
//
//        pricingVisitor.visit(singleRoom);
//        pricingVisitor.visit(doubleRoom);
//        pricingVisitor.visit(deluxRoom);
//
//        System.out.println(singleRoom.price);
//
//        // maintenance logic for all the room types (separate class)
//        MaintenanceVisitor maintenanceVisitor = new MaintenanceVisitor();
//        maintenanceVisitor.visit(singleRoom);
//        maintenanceVisitor.visit(doubleRoom);
//        maintenanceVisitor.visit(deluxRoom);


        // double dispatch happening  here as 1. at Room interface and 2nd at visitor interface
        SingleRoom singleRoom = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        DeluxRoom deluxRoom = new DeluxRoom();

        Visitor pricingVisitor = new PricingVisitor();

        // Use accept (double dispatch)
        singleRoom.accept(pricingVisitor);
        doubleRoom.accept(pricingVisitor);
        deluxRoom.accept(pricingVisitor);

        System.out.println("Single Room Price: " + singleRoom.price);

        Visitor maintenanceVisitor = new MaintenanceVisitor();
        singleRoom.accept(maintenanceVisitor);
        doubleRoom.accept(maintenanceVisitor);
        deluxRoom.accept(maintenanceVisitor);

    }

}