package MachineCodingRound;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// this is correct but but bad readability as all the logic in single file
// there is no separation of concern
public class SnakeLadder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random dice = new Random();

        Map<Integer, Integer> snakeMap = new HashMap<>();
        Map<Integer, Integer> ladderMap = new HashMap<>();

        // Input snakes
        int snakes = scanner.nextInt();

        for (int i = 0; i < snakes; i++) {
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            snakeMap.put(head, tail);
        }

        int ladders = scanner.nextInt();

        for (int i = 0; i < ladders; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            ladderMap.put(start, end);
        }

        int playerCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] players = new String[playerCount];
        Map<String, Integer> playerPositions = new HashMap<>();

        for (int i = 0; i < playerCount; i++) {
            players[i] = scanner.nextLine();
            playerPositions.put(players[i], 1); // Start at position 1
        }

        boolean gameEnded = false;
        while (!gameEnded) {
            for (String player : players) {
                int diceRoll = dice.nextInt(6) + 1;

                int currentPosition = playerPositions.get(player);
                int nextPosition = currentPosition + diceRoll;

                if (nextPosition > 100) {
                    System.out.println(player + " rolled too high to move.");
                } else {
                    if (snakeMap.containsKey(nextPosition)) {
                        System.out.println(player + "rolled "+ diceRoll +" and move from " + nextPosition + " to " + snakeMap.get(nextPosition) + " after snake bite.");
                        nextPosition = snakeMap.get(nextPosition);
                    } else if (ladderMap.containsKey(nextPosition)) {
                        System.out.println(player + "rolled "+ diceRoll + " and move from " + nextPosition + " to " + ladderMap.get(nextPosition) + " after ladder ride.");
                        nextPosition = ladderMap.get(nextPosition);
                    } else  {
                        System.out.println(player + "rolled "+ diceRoll + " and move from " + currentPosition + " to " +  nextPosition);
                    }
                    playerPositions.put(player, nextPosition);

                    if (nextPosition == 100) {
                        System.out.println(player + " has won the game!");
                        gameEnded = true;
                        break;
                    }
                }
            }
        }
        scanner.close();
    }
}
