package MachineCodingRound.SwiggyMachineCoding.Notification;

import java.util.Date;
import java.util.UUID;

public class Notification {
    private String id;
    private String content;
    private Date timestamp;


    public Notification(String content, Date timestamp) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
