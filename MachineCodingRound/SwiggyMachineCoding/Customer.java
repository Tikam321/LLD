package MachineCodingRound.SwiggyMachineCoding;

import MachineCodingRound.SwiggyMachineCoding.Notification.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {
    String customerId;
    private String name;
    private String email;

    private List<Notification> notifications;

    public Customer(String name, String email) {
        this.customerId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        notifications = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}
