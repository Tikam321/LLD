package MachineCodingRound.SnakeAndLadder;

import java.util.Random;

public class Dice {
    private int diceNumber;
    private Random random;
    Dice(int diceNumber) {
        this.diceNumber = diceNumber;
        random = new Random();
    }

    int getRoll() {
        return random.nextInt(diceNumber) +1;
    }

}
