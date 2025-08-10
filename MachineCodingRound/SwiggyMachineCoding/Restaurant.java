package MachineCodingRound.SwiggyMachineCoding;

import MachineCodingRound.SwiggyMachineCoding.Notification.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Restaurant {
    private String id;

    private String name;

    private Menu menu;
    private boolean isAvailable;
    private List<Notification> notifications;

    public Restaurant( String name, Menu menu, boolean isAvailable) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.menu = menu;
        this.isAvailable = isAvailable;
        this.notifications = new ArrayList<>();
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}
