package creationalPattern;

import java.util.HashMap;
import java.util.Map;

interface GamePlayer extends Cloneable {
    GamePlayer clone();
    void display();
}

class Warrior implements GamePlayer {

    private String weapon;

    public Warrior(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public GamePlayer clone() {
        return new Warrior(weapon);
    }

    @Override
    public void display() {
        System.out.println("The warrior " + this);
    }
}

class Destroyer implements GamePlayer {
    private String weapon;

    public Destroyer(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public GamePlayer clone() {
        return new Destroyer(this.weapon);
    }

    @Override
    public void display() {
        System.out.println("the destroyer " + this);
    }
}


class CharacterRegistry {
    private Map<String, GamePlayer> characterMap = new HashMap<>();

    public void registerCharacter(String type, GamePlayer character) {
        characterMap.put(type, character);
    }

    public GamePlayer getCharacter(String type) {
        return characterMap.get(type).clone();
    }
}


public class ProtoType {
    public static void main(String[] args) {
        Warrior ironMan = new Warrior("suit");
        Warrior captainAmerica = new Warrior("hammer");

        Destroyer hulk = new Destroyer("diamond");

        CharacterRegistry characterRegistry = new CharacterRegistry();
        characterRegistry.registerCharacter("warrior", ironMan);
        characterRegistry.registerCharacter("warrior1", captainAmerica);
        characterRegistry.registerCharacter("hulk", hulk);

        characterRegistry.getCharacter("warrior").display();
        characterRegistry.getCharacter("warrior").display();
        characterRegistry.getCharacter("hulk").display();
        characterRegistry.getCharacter("hulk").display();
    }
}





