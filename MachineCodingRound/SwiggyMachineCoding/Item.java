package MachineCodingRound.SwiggyMachineCoding;

import java.util.UUID;

public class Item {
    private String dishId;
    private String dishName;
    private double price;
    private int rating;

    public Item(String dishName, double price, int rating ) {
        this.dishId = UUID.randomUUID().toString();
        this.dishName = dishName;
        this.price = price;
        this.rating = rating;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
