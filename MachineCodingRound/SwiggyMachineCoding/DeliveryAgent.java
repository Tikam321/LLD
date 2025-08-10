package MachineCodingRound.SwiggyMachineCoding;

import MachineCodingRound.SwiggyMachineCoding.Notification.Notification;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAgent {

    private String id;
    private String name;
    private boolean isAvailable;
    private int rating;
    private List<Order> ordersDelivered;
    private List<Notification> notifications;

    public DeliveryAgent(String id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.isAvailable = true;
        this.rating = rating;
        ordersDelivered = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void assignedOrder(Order order) {
        this.isAvailable = false;
        this.ordersDelivered.add(order);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}
