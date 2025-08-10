package MachineCodingRound.BowlingAlley;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static MachineCodingRound.BowlingAlley.bowlingUtility.BowlingAService.SPARE;
import static MachineCodingRound.BowlingAlley.bowlingUtility.BowlingAService.STRIKE;

public class Player {
    private String name;
    private int score;
    private StringBuilder previousScores;

    public Player(String name) {
        this.name = name;
        score = 0;
        previousScores = new StringBuilder();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        this.score += score;
    }

    public StringBuilder getPreviousScores() {
        return previousScores;
    }

    public void setPreviousScores(StringBuilder playerData) {
        this.previousScores.append(playerData);
    }

    public  void printPlayerScoreDetailPerRound( List<Integer> chances) {
        for (int chance = 1; chance < chances.size() + 1; chance++) {
            System.out.println(this.getName() + " Chances " + chance + ": " + chances.get(chance - 1));
            if (chance == 3) {
                System.out.println("Extra chances as all pins are dropped in last round");
            }
        }

    }

    public  void getSpecialRound(Scanner scanner, StringBuilder playerData, List<Integer> chances, int chanceNumber) {
        int score;
        int scorePerRound = 0;

        for (int j = chanceNumber; j <= chanceNumber + 1; j++) {
            System.out.print("Enter score for - " + this.getName() + " chance" + j + ":");
            score = scanner.nextInt();
            chances.add(score);
            scanner.nextLine();
            scorePerRound += score;
            if (score == STRIKE) {
                playerData.append("{X, }");
                scorePerRound += STRIKE;
            } else {
                playerData.append("{").append(score).append(",");
                if (scorePerRound == 10) {
                    scorePerRound += SPARE;
                    playerData.append("/");
                }
                playerData.append("}");
            }
        }
        this.updateScore(scorePerRound);
    }


}
