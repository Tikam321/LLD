package MachineCodingRound.BowlingAlley;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static MachineCodingRound.BowlingAlley.bowlingUtility.BowlingAService.*;
import static MachineCodingRound.BowlingAlley.bowlingUtility.BowlingAService.printFinalOutPut;

public class BowlingAlley {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of Players ");
        int playerCount = scanner.nextInt();
        scanner.nextLine();
        BowlingAlleyDemo bowlingAlleyDemo = new BowlingAlleyDemo();
        bowlingAlleyDemo.startGame(scanner,playerCount);
    }
}

//    public void startGame(Scanner scanner,int playerCount) {
//        List<Player> players = getAllPlayers(playerCount);
//        boolean specialRoundEligible = false;
//        int numberOfchances = 3;
//
//        for (int round = 1; round <= ROUND; round++) {
//            System.out.println("Round " + round + ": ");
//            int score;
//            for (Player player : players) {
//                StringBuilder playerData = new StringBuilder();
//                int scorePerRound = 0;
//                playerData.append("{");
//                List<Integer> chances = new ArrayList<>();
//
//                for (int j = 1; j <= 2; j++) {
//                    int chance1;
//                    System.out.print("Enter score for - " + player.getName() + " chance" + j + ":");
//                    score = scanner.nextInt();
//
//                    chances.add(score);
//                    scanner.nextLine();
//                    scorePerRound += score;
//                    if (score == STRIKE) {
//                        if (round == 3) {
//                            specialRoundEligible = true;
//                            numberOfchances = 2;
//                        }
//                        playerData.append("X, }");
//                        scorePerRound += STRIKE;
//                        break;
//                    } else {
//                        playerData.append(score);
//                        if (j == 2) {
//                            if (scorePerRound == 10) {
//                                if (round == 3) {
//                                    specialRoundEligible = true;
//                                    numberOfchances = 3;
//                                }
//                                scorePerRound += SPARE;
//                                playerData.append("/");
//
//                            }
//                        } else {
//                            playerData.append(",");
//                        }
//                    }
//                }
//                playerData.append("}");
//                if (round == ROUND && specialRoundEligible) {
//                    player.getSpecialRound(scanner, playerData, chances, numberOfchances);
//                    specialRoundEligible = false;
//                }
//                player.setPreviousScores(playerData);
//                player.printPlayerScoreDetailPerRound(chances);
//                player.updateScore(scorePerRound);
//                printScoreBoardPerRound(players);
//            }
//        }
//        printFinalOutPut(players);
//    }