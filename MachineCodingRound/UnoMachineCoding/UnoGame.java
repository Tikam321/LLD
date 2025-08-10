package MachineCodingRound.UnoMachineCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UnoGame {
    private List<Player> playerList = new ArrayList<>();

    private Deck deck;

    public UnoGame(int playerCount, Deck deck) {
        this.deck = deck;
        createPlayer(playerCount);
        distributeCards();
    }

    public void createPlayer(int playerCount) {
        for(int i=1;i<=playerCount;i++) {
            playerList.add(new Player("player"+i));
        }
    }

    public void distributeCards() {
        int ind = 0;
        while(ind < 52) {
            for(Player player: playerList){
                player.assignCard(deck.getCards().get(ind++));
            }
        }
    }

    public void startGame(){
        Card previousCard = null;
        Player winner = null;
        boolean isGameEnded = false;

            while(!isGameEnded) {
                for (Player player : playerList) {
                    if (player.getCards().isEmpty()) {
                        isGameEnded = true;
                        winner = player;
                        break;
                    }
                    Card card = player.getCards().get(0);
                    if (previousCard == null) {
                        previousCard = card;
                        player.getCards().remove(card);
                        System.out.println(player.getName() + " plays " + " card with " +
                                card.getCarNumber() + " with Color " + card.getColorType());
                    } else {
                        Card finalPreviousCard = previousCard;
                        Optional<Card> newCards;
                        newCards = player.getCards().stream().filter(newCard -> newCard.getCarNumber() == finalPreviousCard.getCarNumber()).findFirst();
                        if (newCards.isEmpty()) {
                            newCards = player.getCards().stream().filter(newCard -> newCard.getColorType().equals(finalPreviousCard.getColorType())).findFirst();
                        }
                        if (newCards.isEmpty()) {
                            System.out.println(player.getName() + " will go By PASS");
                        } else {
                            System.out.println(player.getName() + " plays " + " card with " +
                                    newCards.get().getCarNumber() + " with Color " + newCards.get().getColorType());
                            previousCard = newCards.get();
                        }
                        newCards.ifPresent(value -> player.getCards().remove(value));
                    }
                }
            }
            System.out.println(winner.getName()+ " has WON  the game.");
    }


}
