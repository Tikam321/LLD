package MachineCodingRound.Trello.Model;

import MachineCodingRound.Trello.Enums.ProjectStatus;

import java.util.Date;

public class Ticket {
    private String TicketId;
    private String title;
    private String description;
    private User Assignee;
    private User CreatedBy;
    private Date dueDate;
    private ProjectStatus status;

    public Ticket(String ticketId, String title, String description, User createdBy, Date dueDate) {
        TicketId = ticketId;
        this.title = title;
        this.description = description;
        CreatedBy = createdBy;
        this.dueDate = dueDate;
        this.status = ProjectStatus.TODO;
        this.Assignee = null;
    }

    public String getTicketId() {
        return TicketId;
    }

    public void setTicketId(String ticketId) {
        TicketId = ticketId;
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

    public User getAssignee() {
        return Assignee;
    }

    public void setAssignee(User assignee) {
        Assignee = assignee;
    }

    public User getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(User createdBy) {
        CreatedBy = createdBy;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
