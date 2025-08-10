package MachineCodingRound.UnoMachineCoding;

import java.util.Scanner;

public class UnoDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOFPlayer;
        System.out.print("Enter the number of player");
        numberOFPlayer = scanner.nextInt();
        scanner.nextLine();
        Deck deck = new Deck();
//       deck.getCards().stream().forEach(card -> System.out.println("Card number" + card.getCarNumber() + " color " + card.getColorType()));
        UnoGame unoGame = new UnoGame(numberOFPlayer, deck);
        unoGame.startGame();
    }
}
