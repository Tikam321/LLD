package MachineCodingRound.SwiggyMachineCoding;

import java.util.UUID;

public class Order {
    private String orderId;
    private OrderStatus orderStatus;
    private Item dish;
    private Customer customer;
    private Restaurant restaurant;
    public boolean IsOrderDelivered = false;

    public Order( Item dish, Customer customer, Restaurant restaurant) {
        this.orderId = UUID.randomUUID().toString();
        this.orderStatus = OrderStatus.PICKED;
        this.dish = dish;
        this.customer = customer;
        this.restaurant = restaurant;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Item getDish() {
        return dish;
    }

    public void setDish(Item dish) {
        this.dish = dish;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void updateOrderStatus(OrderStatus orderStatus) {
        if (orderStatus == OrderStatus.DELIVERED) {
            this.IsOrderDelivered = true;
        }
        this.orderStatus = orderStatus;
    }


}
