package MachineCodingRound.LinkedInLearningMachineCoding;

import java.util.Date;
import java.util.concurrent.Executors;

public class LinkedInDemo {
    public static void main(String[] args) {
        LinkedInManager linkedInManager = LinkedInManager.getInstance();

        // users
        Experience experience = new Experience("samsung sds", new Date(),new Date(),"good listner");
        Education education = new Education("iit",new Date(), new Date(), 7.8);
        Profile user1Profile = new Profile("strong java backendDeveloper",
                "team worker", experience, education);

        Profile user2Profile = new Profile("strong java backendDeveloper",
                "hard worker", experience, education);

        User user1 = new User("user1","user1234.com", "password", user1Profile);

        User user2 = new User("user2", "user423.com", "pass123",user2Profile);

        // user1 sending the connection request to user2
        linkedInManager.sendConnectionRequest(user1,user2);

        // adding users to linkedinManager
        linkedInManager.addUsers(user1);
        linkedInManager.addUsers(user2);

        Employer samsung = new Employer("samsung sds");
        Employer meta = new Employer("meta");

        linkedInManager.registerCompany(samsung);
        linkedInManager.registerCompany(meta);

        JobPost jobPost1 = new JobPost("backend developer","java,Spring boot","Backend role", "gurugram",new Date(),samsung);
        JobPost jobPost2 = new JobPost("frontend developer","React, angular, flutter","Backend role", "gurugram",new Date(),meta);

        linkedInManager.postJob(jobPost1);
        linkedInManager.postJob(jobPost2);

        JobPost jobPost = linkedInManager.searchByJobPosting("backend developer");
        if (jobPost != null) {
            System.out.println("here is the job post  description ");
            System.out.println(jobPost.getDescription());
        } else {
            System.out.println("search job post id nt found");
        }

        // accepting the connection Request
       linkedInManager.acceptConnectionRequest(user2, user1);

        // user1 notifications
        for(Notification notification: user2.getNotifications()) {
            System.out.println("Notificaiton Type: " + notification.getNotificationType());
        }

        // print the all the connection of user2 network
        System.out.println("print the connections of user2");
        for(Connection connection: user2.getMyNetwork()) {
            System.out.println(connection.getRequestedUser().getName());
        }

        // user1 sending message to user2
        Message message = new Message(user2, "i want you to follow this page", new Date(System.currentTimeMillis()));
        linkedInManager.sendMessage(user1, user2, message);

        // print all messages for user2
        linkedInManager.showMyMessages(user2.getUserId());

        //print all the notificaitons for user2
        linkedInManager.showMyNotifications(user1.getUserId());
    }
}
