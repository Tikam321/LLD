package MachineCodingRound.Trello;

import MachineCodingRound.Trello.Controller.TrelloController;
import MachineCodingRound.Trello.Enums.ProjectStatus;
import MachineCodingRound.Trello.Model.Board;
import MachineCodingRound.Trello.Model.Ticket;
import MachineCodingRound.Trello.Model.TrelloList;
import MachineCodingRound.Trello.Model.User;

import java.util.Date;

public class TrelloDemo {
    public static void main(String[] args) {
        TrelloController trelloController = TrelloController.getInstance();
        Board board = new Board("Brity Messenger","trello/brityMessenger/");
        trelloController.addBoard(board);
        User tikam = new User("tikam","723","xyz333@gmail.com");
        User rohit = new User("rohit", "1345","sdasdasd342@gmail.com");

        // adding members to board
        board.addMembers(tikam);
        board.addMembers(rohit);

        // creating Trello lists
        TrelloList todo = new TrelloList(ProjectStatus.TODO);
        TrelloList inProgress = new TrelloList(ProjectStatus.IN_PROGRESS);

        board.addTrelloList(todo);
        board.addTrelloList(inProgress);

        // creating the jira task
        Ticket ticket1 = new Ticket("1233","fix url issue","getting wrong url which is giving error",tikam,new Date());
        Ticket ticket2 = new Ticket("865","fix css issue in blacklist page","css is provided already",rohit,new Date());
        Ticket ticket3 = new Ticket("4534","roting is failed in announcement page","screenshot is attached",tikam,new Date());

        todo.addCard(ticket1);
        todo.addCard(ticket2);
        todo.addCard(ticket3);

        //removing trelloList
//        board.removeTrelloList(inProgress);


        // changing the status for ticket
//        trelloController.updateCardStatus(board.getId(), todo.getId(), inProgress.getId(), ticket1);

        trelloController.displayAllBoard();
    }
}
