package MachineCodingRound.LinkedInLearningMachineCoding;

import java.util.*;

public class LinkedInManager {

    private Map<String, User> users;
    private Map<String, JobPost> jobs;
    private Map<String,Employer> companies;
    public static LinkedInManager instance;


    private LinkedInManager() {
        users = new HashMap<>();
        jobs = new HashMap<>();
        companies = new HashMap<>();
    }

    public static  synchronized LinkedInManager getInstance() {
        if (instance == null) {
            return instance = new LinkedInManager();
        } else {
            return instance;
        }
    }

    public User searchByUser(String userName) {
        return users.values().stream()
                .filter(user -> user.getName().equals(userName))
                .findFirst()
                .orElse(null);
    }

    public Employer searchByCompany(String companyName) {
        return companies.values().stream()
                .filter(company -> company.getName().equals(companyName))
                .findFirst()
                .orElse(null);

    }

    public JobPost searchByJobPosting(String jobTitle) {
        return jobs.values().stream()
                .filter(job -> job.getTitle().contains(jobTitle))
                .findFirst()
                .orElse(null);
    }

    public void postJob(JobPost jobPost) {
        jobs.put(jobPost.getId(), jobPost);
        users.values().forEach(user -> sendNotification(user,
                "Got job alert from " + jobPost.getEmployer() , NotificationType.JOB_ALERT));
    }

    public void sendConnectionRequest(User sender, User receiver) {
        Connection connection = new Connection(sender, new Date(System.currentTimeMillis()));
        receiver.addConnectionRequest(connection);
        sendNotification(receiver, sender.getName() +
                " Send connection request", NotificationType.SEND_CONNECTION_REQUEST);
    }

    public void acceptConnectionRequest(User user, User connectionUser) {
        for(Connection connection: user.getConnectionRequests()) {
            if (connection.getRequestedUser().equals(connectionUser)) {
                sendNotification(connectionUser, user.getName() +
                        " Accepted Connection Request", NotificationType.ACCEPT_CONNECTION_REQUEST);
                user.addConnectionToMyNetwork(connection);
            }
        }
    }

    public void sendMessage(User sender, User receiver, Message message) {
        sender.addToSentMessages(message);
        receiver.addMessageToInbox(message);
        sendNotification(receiver, "Got message from " +
                sender.getName(), NotificationType.MESSAGE_ALERT);
    }

    public void addUsers(User user) {
        users.put(user.getUserId(), user);
    }

    public void registerCompany(Employer employer) {
        companies.put(employer.getEmployerid(), employer);
    }

    public void sendNotification(User receiver, String content, NotificationType notificationType) {
        Notification notification = new Notification(notificationType, new Date(System.currentTimeMillis()), content);
        receiver.sendNotification(notification);
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, JobPost> getJobs() {
        return jobs;
    }

    public Map<String, Employer> getCompanies() {
        return companies;
    }
    public void showMyMessages(String userId) {
        if (users.containsKey(userId)) {
            users.get(userId).getAddToInbox().forEach(message -> System.out.println(message.getMessage()));
        } else {
            System.out.println("the given userid is not exist");
        }
    }

    public void showMyNotifications(String userId) {
        if (users.containsKey(userId)) {
            users.get(userId).getNotifications().forEach(noti ->
                    System.out.println("Notification type" + noti.getNotificationType() +
                            "message " + noti.getContent()));
        } else {
            System.out.println("the given userid is not exist.");
        }
    }
}
