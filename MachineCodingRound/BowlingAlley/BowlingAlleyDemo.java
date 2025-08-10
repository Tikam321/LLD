package MachineCodingRound.BowlingAlley;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static MachineCodingRound.BowlingAlley.bowlingUtility.BowlingAService.*;

public class BowlingAlleyDemo {

    public void startGame(Scanner scanner, int playerCount) {
        List<Player> players = getAllPlayers(playerCount);

        for (int round = 1; round <= ROUND; round++) {
            System.out.println("Round " + round + ": ");
            int score;
            for (Player player : players) {
                StringBuilder playerData = new StringBuilder();
                int scorePerRound = 0;
                List<Integer> chances = new ArrayList<>();
                    int chance1;
                    int chance2 = 0;
                    System.out.print("Enter score for - " + player.getName() + " chance" + 1 + ":");
                    chance1 = scanner.nextInt();
                    scanner.nextLine();
                    if (chance1 != STRIKE) {
                        System.out.print("Enter score for - " + player.getName() + " chance" + 2 + ":");
                        chance2 = scanner.nextInt();
                    }
                    Frame frame = new Frame(chance1, chance2);
                    frame.calculatesScore(player);
                    if (round == ROUND && (frame.isSpare() || frame.isStrike())) {
                        frame.getSpecialRound(player, scanner);
                    }
                    player.setPreviousScores(playerData);
                    player.printPlayerScoreDetailPerRound(chances);
                    player.updateScore(scorePerRound);
                    printScoreBoardPerRound(players);
                }

            printFinalOutPut(players);
        }

    }
}

