package MachineCodingRound.SnakeAndLadder;

import javax.swing.*;
import java.util.HashMap;

public class Board {
    private HashMap<Integer, Integer> snakeMap;
    private HashMap<Integer, Integer> ladderMap;

    public Board() {
        this.snakeMap = new HashMap<>();
        this.ladderMap = new HashMap<>();
    }

    public HashMap<Integer, Integer> getSnakeMap() {
        return snakeMap;
    }

    public void setSnakeMap(int head, int tail) {
        this.snakeMap.put(head,tail);
    }

    public HashMap<Integer, Integer> getLadderMap() {
        return ladderMap;
    }

    public void setLadderMap(int start, int end) {
        this.ladderMap.put(start,end);
    }

    public void updateNextNextPosition(int nextPosition,Player player) {
        if (snakeMap.containsKey(nextPosition)) {
            player.setPosition(snakeMap.get(nextPosition));

        }
    }
}
