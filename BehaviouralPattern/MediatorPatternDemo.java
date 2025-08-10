package BehaviouralPattern;


import java.util.ArrayList;
import java.util.List;

interface Colleague {
    void placeBid(int bidAmount);
    void bidNotification(int bidAmount);

}

class Bidder implements Colleague {
    private AuctionMediator auctionMediator;
    private String name;

    public Bidder(AuctionMediator auctionMediator,String name) {
        this.auctionMediator = auctionMediator;
        auctionMediator.addBidder(this);
        this.name = name;
    }

    @Override
    public void placeBid(int amount) {
        this.auctionMediator.bid(amount, this);

    }

    @Override
    public void bidNotification(int amount) {
        System.out.println("bidder " + this.name + "got the notification that someone put bid of  " + amount);
    }

    public AuctionMediator getAuctionMediator() {
        return auctionMediator;
    }

    public void setAuctionMediator(AuctionMediator auctionMediator) {
        this.auctionMediator = auctionMediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface AuctionMediator {
    void bid(int amount, Bidder colleague);


    void addBidder(Bidder colleague);
}

class Auction implements AuctionMediator {
    private List<Bidder> bidder;

    public Auction() {
        bidder = new ArrayList<>();
    }

    @Override
    public void bid(int amount, Bidder colleague) {
        for(Bidder bidders: bidder) {
            if (!colleague.equals(bidders)) {
                bidders.bidNotification(amount);
            }
        }
    }

    @Override
    public void addBidder(Bidder colleague) {
        bidder.add(colleague);
    }
}

public class MediatorPatternDemo {
    public static void main(String[] args) {
        AuctionMediator auctionMediator = new Auction();
        Bidder bidder1 = new Bidder(auctionMediator, "rohit");
        Bidder bidder2 = new Bidder(auctionMediator, "virat");
        Bidder bidder3 = new Bidder(auctionMediator, "tikam");

        bidder1.placeBid(500);
        bidder2.placeBid(5000);
        bidder3.placeBid(15000);
    }
}
