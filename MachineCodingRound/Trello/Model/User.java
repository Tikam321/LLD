package MachineCodingRound.Trello.Model;

import MachineCodingRound.Trello.Model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String id;
    private String email;

    private List<Ticket> myIssues;

    public User(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.myIssues = new ArrayList<>();
    }



}
