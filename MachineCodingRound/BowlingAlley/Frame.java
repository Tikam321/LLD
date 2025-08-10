package MachineCodingRound.BowlingAlley;

import java.util.List;
import java.util.Scanner;

import static MachineCodingRound.BowlingAlley.bowlingUtility.BowlingAService.SPARE;
import static MachineCodingRound.BowlingAlley.bowlingUtility.BowlingAService.STRIKE;

public class Frame {
    private int chance1;
    private int chance2;

    public Frame(int chance1, int chance2) {
        this.chance1 = chance1;
        this.chance2 = chance2;
    }

    public boolean isStrike() {
        return this.chance1 == STRIKE;
    }

    public boolean isSpare() {
        return !isStrike() && (chance1 + chance2 == 10);
    }


    public int getChance1() {
        return chance1;
    }

    public void setChance1(int chance1) {
        this.chance1 = chance1;
    }

    public int getChance2() {
        return chance2;
    }

    public void setChance2(int chance2) {
        this.chance2 = chance2;
    }

    public void calculatesScore(Player player) {
        StringBuilder playerData = new StringBuilder();
        int score = 0;
        playerData.append("{");
        if (isStrike()) {
            playerData.append("X,");
            score += 20;
        } else if(isSpare()) {
            playerData.append(chance1);
            playerData.append(",");
            playerData.append("/");
            score += chance1 + chance2 + 5;
        } else {
            playerData.append(chance1);
            playerData.append(",");
            playerData.append(chance2);
            score += chance1 + chance2;

        }
        playerData.append("}");
        player.setPreviousScores(playerData);
        player.updateScore(score);
        }

    public  void getSpecialRound(Player player,Scanner scanner) {
        int chanceNumber = isStrike() ? 2 : 3;
        StringBuilder playerData = new StringBuilder();

        int chance1;
        int totalScore = 0;
        int chance2;
            System.out.print("Enter score for - " +player.getName() + " chance" + chanceNumber + ":");
            chance1 = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter score for - " +player.getName() + " chance" + (chanceNumber +1) + ":");
            chance2 = scanner.nextInt();
            scanner.nextLine();
            if (chance1 == STRIKE) {
                playerData.append("{X,}");
                totalScore += 20;
            } else {
                if (chance2 == 10) {
                    playerData.append("{X,}");
                    totalScore += 20;
                } else if(chance2 + chance1 == 10) {
                    playerData.append("{").append(chance1).append("/").append("}");
                    totalScore += 15;
                } else {
                    totalScore += chance1 + chance2;
                    playerData.append("{").append(chance1).append(",").append(chance2).append("}");
                }
           }
            player.updateScore(totalScore);
            }







}
