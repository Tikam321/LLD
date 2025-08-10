package MachineCodingRound.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private Dice dice;
    private List<Player> players;
    private Scanner scanner;
    private static Game instance = null;

    private Game() {
        this.board = new Board();
        this.dice = new Dice(6);
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static Game getInstance() {
        if (instance == null) {
            return instance = new Game();
        }
        return instance;
    }

    public void setUp(){
//        System.out.println("enter the number of snakes you want to add");
        int snakes = scanner.nextInt();
//        System.out.println("enter the number of Ladder do you want to add");


        for(int i=0;i<snakes;i++) {
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            board.setSnakeMap(head,tail);

        }
        int ladders = scanner.nextInt();
        for(int i=0;i<ladders;i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            board.setLadderMap(start,end);
        }

        int player = scanner.nextInt();

        scanner.nextLine();
        for(int i=0;i<player;i++) {
            String name= scanner.nextLine();
            players.add(new Player(name));
        }
        System.out.println("____________________");
        board.getSnakeMap().forEach((key, value) -> System.out.println(key + " value " + value));
        board.getLadderMap().forEach((key, value) -> System.out.println(key + " value " + value));
        System.out.println("____________________");

        System.out.println("set up is completed");

    }

    public void startGame() {
        boolean isGameEnded = false;
        while(!isGameEnded) {
            for(Player player: players) {
                int diceRoll = dice.getRoll();
                int currentPosition = player.getPosition();
                int nextPosition = diceRoll + currentPosition;
                if (nextPosition > 100) {
                    System.out.println("invalid dice number please wait for another turn to win this game");
                } else {
                    if (nextPosition == 100) {
                        System.out.println(player.getName() + " has won");
                        isGameEnded = true;
                        break;
                    } else if (board.getSnakeMap().containsKey(nextPosition)) {
                        int finalPosition = board.getSnakeMap().get(nextPosition);
                        System.out.println(player.getName() + " dice roll " + diceRoll + "move from " + nextPosition + " to " +  finalPosition + " after snake bite.");
                        player.setPosition(finalPosition);
                    } else if (board.getLadderMap().containsKey(nextPosition)) {
                        int finalPosition = board.getLadderMap().get(nextPosition);
                        System.out.println(player.getName() + " dice roll " + diceRoll + "move from " + nextPosition + " to " +  finalPosition + " after go by ladder.");
                        player.setPosition(finalPosition);
                    } else {
                        System.out.println(player.getName() + " dice roll " + diceRoll + "move from " + currentPosition + " to " + nextPosition);
                        player.setPosition(nextPosition);
                    }
                }

            }
        }
    }
}
