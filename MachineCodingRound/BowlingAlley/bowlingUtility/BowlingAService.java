package MachineCodingRound.BowlingAlley.bowlingUtility;

import MachineCodingRound.BowlingAlley.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlingAService {
    public final static int STRIKE = 10;
    public final static int SPARE = 5;
    public final static int ROUND = 5;


    public static void printFinalOutPut(List<Player> players) {
        System.out.println("ScoreBoard:");
        for (int player = 0; player < players.size(); player++) {
            System.out.println("P" + player + 1 + " - " + players.get(player).getScore() + " points " + (player == 0 ? "(winner)" : ""));
        }
    }

    public static List<Player> getAllPlayers(int playerCount) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player("player" + (i + 1)));
        }
        return players;
    }
    public static  void printScoreBoardPerRound(List<Player> players) {
        System.out.println("ScoreBoard:");
        for (int player = 0; player < players.size(); player++) {
            System.out.println("P" + (player + 1) + ":" + players.get(player).getPreviousScores() + " -> "
                    + players.get(player).getScore());
        }
    }
}
