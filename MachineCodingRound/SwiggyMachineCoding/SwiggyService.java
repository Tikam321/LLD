package MachineCodingRound.SwiggyMachineCoding;

import MachineCodingRound.SwiggyMachineCoding.Notification.Notification;
import MachineCodingRound.SwiggyMachineCoding.PaymentService.*;

import java.util.*;

public class SwiggyService {
    private Map<String, Customer> registeredCustomer;
    private Map<String, Order> orderHistory;
    private Map<String, DeliveryAgent> deliveryAgents;

    private Map<String, Restaurant> restaurants;

    private Map<String, Notification> notificationMap;

    public static SwiggyService instance = null;

    private SwiggyService() {
        this.registeredCustomer = new HashMap<>();
        this.orderHistory = new HashMap<>();
        this.deliveryAgents = new HashMap<>();
        this.restaurants = new HashMap<>();
        this.notificationMap = new HashMap<>();
    }

    public static synchronized SwiggyService getInstance() {
        if (instance != null) {
            return instance;
        } else {
        return instance = new SwiggyService();
        }
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public synchronized Order placeOrder(String customerId, Restaurant restaurant, Item item, PaymentType paymentType) {
        Order order = new Order(item, registeredCustomer.get(customerId), restaurant);
        PaymentProcess paymentProcess = paymentProcess(paymentType);
        Customer customer = registeredCustomer.get(customerId);
        System.out.println(paymentProcess);
        if (paymentProcess != null) {
            paymentProcess.payment(item.getPrice());
            Notification notification = new Notification("payment of " + item.getPrice() + "is paid by" + customer.getName(),
                    new Date(System.currentTimeMillis()));
            restaurant.addNotification(notification);
            notificationMap.put(notification.getId(), notification);
        } else {
            System.out.println("payment is failed and order is canceled");
            order.updateOrderStatus(OrderStatus.CANCELLED);
            return order;
        }
        // order state change to pickup
        order.updateOrderStatus(OrderStatus.PICKED);

        if (registeredCustomer.containsKey(customerId)) {
            orderHistory.put(order.getOrderId(), order);
            DeliveryAgent deliveryAgent = getAvailableDeliveryAgent();
            assignDeliveryAgent(order, deliveryAgent, customer);
        }
        return order;
    }

    public void assignDeliveryAgent(Order order, DeliveryAgent deliveryAgent, Customer customer) {
        String customerId = customer.getCustomerId();
        if (deliveryAgent != null) {
            System.out.println("delivery agent " + deliveryAgent.getName() + " is assigned");
            deliveryAgent.assignedOrder(order);
            Notification notification = new Notification("the order id " + order.getOrderId() + "is assigned to " +
                    deliveryAgent.getName(), new Date(System.currentTimeMillis()));
            deliveryAgent.addNotification(notification);
            notificationMap.put(notification.getId(), notification);

            // order state change to pickup
            order.updateOrderStatus(OrderStatus.ASSIGNED_DELIVERY_AGENT);

            // order state change to pickup
            System.out.println("the status of order is changed to " + order.getOrderStatus());
            order.updateOrderStatus(OrderStatus.DELIVERED);
            if (order.getOrderStatus() == OrderStatus.DELIVERED) {
                customer.addNotification(new Notification("the order id " + order.getOrderId() + "is delivered"
                        ,new Date(System.currentTimeMillis())));
                deliveryAgent.setAvailable(true);
                System.out.println("Order Id" + order.getOrderId() + "  is successFully delivered.");
            }
            orderHistory.put(customerId, order);
        } else {
            System.out.println("please wait all the delivery agents are busy");
        }
    }

    private DeliveryAgent getAvailableDeliveryAgent() {
        return deliveryAgents.values().stream().filter(DeliveryAgent::isAvailable).findFirst().orElse(null);
    }

    private PaymentProcess paymentProcess(PaymentType paymentType) {
        PaymentProcess paymentProcess = null;
        switch (paymentType) {
            case CASH -> paymentProcess = new CashPayment();
            case DEBIT_CARD ->  paymentProcess = new DebitCardPayment();
            case UPI ->  paymentProcess = new UpiPayment();
            default -> throw new RuntimeException("wrong payment method");
        }
        return paymentProcess;
    }

    public void addCustomer(Customer customer) {
        this.registeredCustomer.put(customer.getCustomerId(), customer);
    }

    public void addDeliveryAgent(DeliveryAgent deliveryAgent) {
        this.deliveryAgents.put(deliveryAgent.getId(), deliveryAgent);
    }

    public void cancelOrder(String orderId) {
        if (orderHistory.containsKey(orderId)) {
           Order order = orderHistory.get(orderId);
           order.updateOrderStatus(OrderStatus.CANCELLED);
           Notification notification = new Notification("the order id " + order.getOrderId() + "is cancelled",
                   new Date(System.currentTimeMillis()));
           order.getCustomer().addNotification(notification);
           notificationMap.put(notification.getId(), notification);
        } else {
            throw  new RuntimeException("the order id is not exist");
        }
    }
}
