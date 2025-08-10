package MachineCodingRound.Trello.Model;

import MachineCodingRound.Trello.Enums.Privacy;
import MachineCodingRound.Trello.Enums.ProjectStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private String id;
    private static int counter = 1;
    private String name;
    private Privacy privacy;
    private List<User> members;
    private List<TrelloList> lists;
    private String url;

    public Board(String name, String url) {
        this.id = "Board-Id" + counter++;
        this.name = name;
        this.members = new ArrayList<>();
        this.lists = new ArrayList<>();
        this.url = url;
        this.privacy = Privacy.PUBLIC;
    }

    public void addTrelloList(TrelloList trelloList) {
        lists.add(trelloList);
    }

    public void removeTrelloList(TrelloList trelloList) {
        lists.remove(trelloList);
    }

    public void updateTicketStatus(Ticket ticket, ProjectStatus requestedStatus) {
        ticket.setStatus(requestedStatus);
    }

    public void addMembers(User user) {
        members.add(user);
    }

    public void updateBoardPrivacy(Privacy privacyType) {
        this.privacy = privacyType;
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

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<TrelloList> getLists() {
        return lists;
    }

    public void setLists(List<TrelloList> lists) {
        this.lists = lists;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
