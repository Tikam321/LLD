package LLD.SplitwiseDemo;

public class Split {

    User user;
    int amountOwe;

    public Split(User user, int amountOwe){
        this.user = user;
        this.amountOwe = amountOwe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(int amountOwe) {
        this.amountOwe = amountOwe;
    }

}