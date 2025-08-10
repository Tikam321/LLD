package MachineCodingRound.UnoMachineCoding;

import LLD.ParkingLot.Vehicle.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        createCards();
    }

    public void createCards() {
        List<ColorType> colors = Arrays.asList(ColorType.BLUE,
                ColorType.GREEN, ColorType.RED, ColorType.YELLOW);
       for(ColorType color: colors) {
           for(int cardNumber =1;cardNumber<=13;cardNumber++) {
               this.cards.add(new Card(cardNumber, color));
           }
        }
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
