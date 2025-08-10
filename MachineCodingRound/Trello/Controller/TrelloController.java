package MachineCodingRound.Trello.Controller;

import MachineCodingRound.Trello.Model.Board;
import MachineCodingRound.Trello.Model.Ticket;
import MachineCodingRound.Trello.Model.TrelloList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrelloController {
   private List<Board> boardList;
   private static TrelloController instance;

    private TrelloController() {
        boardList = new ArrayList<>();
    }

    public static TrelloController getInstance() {
        if (instance == null) {
            return instance = new TrelloController();
        }
        return instance;
    }

    public void addBoard(Board board) {
        boardList.add(board);
    }

    public void removeBoard(Board boardToBeDelete) {
       boardList.remove(boardToBeDelete);
    }

    public void updateCardStatus(String boardId, String from, String to, Ticket ticket) {
        Board targetBoard = getBoardById(boardId).orElseThrow(() -> new IllegalArgumentException("invalid board Id " + boardId));
            TrelloList fromList = getTrelloListById(from, targetBoard).orElseThrow(() -> new IllegalArgumentException("invalid list id " + from));
            TrelloList toList = getTrelloListById(to, targetBoard).orElseThrow(() -> new IllegalArgumentException("invalid list id " + to));;
        if (fromList.getCards().remove(ticket)) {
            toList.getCards().add(ticket);
        } else {
            throw new IllegalArgumentException("Ticket not found in from-list");
        }

    }

    private static Optional<TrelloList> getTrelloListById(String from, Board targetBoard) {
        return targetBoard.getLists().stream().filter(l -> l.getId().equals(from)).findFirst();
    }

    private Optional<Board>  getBoardById(String boardId) {
        return boardList.stream().filter(board -> board.getId().equals(boardId)).findFirst();
    }

    public void displayAllBoard() {
        for(Board board:boardList) {
           for(TrelloList lists: board.getLists()) {
               System.out.println("The " + lists.getName() + " showing all the tickets");
               for(Ticket card: lists.getCards()) {
                   System.out.println("    Card: " + card.getTicketId() + " - " + card.getTitle() + " (" + card.getStatus() + ")");
               }
           }
        }
    }

}
