package MachineCodingRound.UnoMachineCoding;

public class Card {
    private int carNumber;
    private ColorType colorType;

    public Card(int carNumber, ColorType colorType) {
        this.carNumber = carNumber;
        this.colorType = colorType;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }
}
