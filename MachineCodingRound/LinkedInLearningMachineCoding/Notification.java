package MachineCodingRound.LinkedInLearningMachineCoding;

import java.util.Date;
import java.util.UUID;

public class Notification {
    private String id;
    private String content;
    private NotificationType notificationType;

    private Date timestamp;

    public Notification(NotificationType notificationType, Date timestamp, String content) {
        id = UUID.randomUUID().toString();
        this.notificationType = notificationType;
        this.timestamp = timestamp;
        this.content = content;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
