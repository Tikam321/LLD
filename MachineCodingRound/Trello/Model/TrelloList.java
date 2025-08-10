package MachineCodingRound.Trello.Model;

import MachineCodingRound.Trello.Enums.ProjectStatus;

import java.util.ArrayList;
import java.util.List;

public class TrelloList {
    private String id;
    private ProjectStatus name;
    private static int counter = 1;
    private List<Ticket> cards;

    public TrelloList(ProjectStatus name) {
        this.id = "List-Id-" + counter++;
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public void addCard(Ticket ticket) {
        cards.add(ticket);
    }

    public void removeCard(Ticket ticket) {
        cards.remove(ticket);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProjectStatus getName() {
        return name;
    }

    public void setName(ProjectStatus name) {
        this.name = name;
    }

    public List<Ticket> getCards() {
        return cards;
    }

    public void setCards(List<Ticket> cards) {
        this.cards = cards;
    }
}
