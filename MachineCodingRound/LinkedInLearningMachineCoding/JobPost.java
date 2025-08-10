package MachineCodingRound.LinkedInLearningMachineCoding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class JobPost {

    private String id;
    private String title;
    private String description;
    private String requirement;
    private String location;

    private Date timestamp;
    private Employer employer;

    private final List<User> appliedUsers;
    public JobPost(String title, String description, String requirement, String location, Date timestamp, Employer employer) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.requirement = requirement;
        this.location = location;
        this.timestamp = timestamp;
        appliedUsers = new ArrayList<>();
        this.employer = employer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void applyForJob(User user ) {
        appliedUsers.add(user);
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
