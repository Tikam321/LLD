package MachineCodingRound.LinkedInLearningMachineCoding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private Profile profile;
    private List<Message> addToInbox;
    private List<Message> addToSentMessages;
    private List<Notification> notifications;
    private List<Connection> myNetwork;
    private List<Connection> connectionRequests;

    public User(String name, String email, String password, Profile profile) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.myNetwork = new ArrayList<>();
        this.addToInbox = new ArrayList<>();
        this.addToSentMessages = new ArrayList<>();
        this.connectionRequests = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public void addConnectionRequest(Connection connection) {
        this.connectionRequests.add(connection);
    }

    public void addConnectionToMyNetwork(Connection connection) {
        this.myNetwork.add(connection);
    }

    public void viewMyConnections() {
        System.out.println(name + "connections list is shown below");
        myNetwork.forEach(connection -> System.out.println(connection.getRequestedUser().name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMessageToInbox(Message message) {
        this.addToInbox.add(message);
    }

    public void addToSentMessages(Message message) {
        this.addToSentMessages.add(message);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void sendNotification(Notification notification) {
        System.out.println("you have receive notification about " + notification.getNotificationType());
        notifications.add(notification);
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Connection> getMyNetwork() {
        return myNetwork;
    }

    public void setMyNetwork(List<Connection> myNetwork) {
        this.myNetwork = myNetwork;
    }

    public List<Connection> getConnectionRequests() {
        return connectionRequests;
    }

    public void setConnectionRequests(List<Connection> connectionRequests) {
        this.connectionRequests = connectionRequests;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Message> getAddToInbox() {
        return addToInbox;
    }

    public void setAddToInbox(List<Message> addToInbox) {
        this.addToInbox = addToInbox;
    }

    public List<Message> getAddToSentMessages() {
        return addToSentMessages;
    }

    public void setAddToSentMessages(List<Message> addToSentMessages) {
        this.addToSentMessages = addToSentMessages;
    }
}
