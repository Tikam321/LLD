package MachineCodingRound.SwiggyMachineCoding;

import MachineCodingRound.SwiggyMachineCoding.PaymentService.PaymentType;

import java.util.Arrays;
import java.util.List;

public class SwiggyDemo {
    public static void main(String[] args) {
        SwiggyService swiggyService = SwiggyService.getInstance();

        //customers
        Customer customer1 = new Customer("tikam","tikam4213@gmail.com");
        Customer customer2 = new Customer("customer2","customer24213@gmail.com");

        //Items
        Item noodels = new Item("noodels",123,4);
        Item dalMakhani = new Item("dalMakahani", 245,5);
        Item sandwitch = new Item("sandwitch", 200,5);

        Item jiraRice = new Item("jeeraRice", 546,3);
        Menu menu = new Menu("menu1");
        menu.addItems(noodels);
        menu.addItems(dalMakhani);

        Menu menu1 = new Menu("menu1");
        menu1.addItems(jiraRice);
        menu1.addItems(sandwitch);

        Restaurant restaurant1 = new Restaurant("delux", menu,true);
        Restaurant restaurant2 = new Restaurant("xyzDelux", menu1 ,true);

        swiggyService.addRestaurant(restaurant1);
        swiggyService.addRestaurant(restaurant2);

        swiggyService.addCustomer(customer1);
        swiggyService.addCustomer(customer2);

        // adding the delivery agent
        DeliveryAgent deliveryAgent1 = new DeliveryAgent("123","agent1", 4);
        DeliveryAgent deliveryAgent2 = new DeliveryAgent("123","agent2", 4);
        DeliveryAgent deliveryAgent3 = new DeliveryAgent("123","agent3", 4);

        swiggyService.addDeliveryAgent(deliveryAgent1);
        swiggyService.addDeliveryAgent(deliveryAgent2);
        swiggyService.addDeliveryAgent(deliveryAgent3);

        // order for customer 1
       Order order =  swiggyService.placeOrder(customer1.getCustomerId(), restaurant1, dalMakhani, PaymentType.DEBIT_CARD);


       swiggyService.cancelOrder(order.getOrderId());




    }
}
