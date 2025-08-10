package BehaviouralPattern;


import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Hi " + name + "new videos " + message);
    }
}

class YouTubeChannel {
    private List<Observer> observerList;

    public YouTubeChannel() {
        observerList = new ArrayList<>();
    }

    void addSubscriber(Observer observer) {
        observerList.add(observer);
    }

    void removeObserver(Observer observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        } else {
            System.out.println("the given subscriber is not found");
        }
    }

    void notifyAllSubscriber(String title) {
        for(Observer subscriber: observerList) {
            subscriber.update(title);
        }
    }
}


class ObserverDemo  {
    public static void main(String[] args) {
        Subscriber tikam  = new Subscriber("tikam");
        Subscriber rohit = new Subscriber("Rohit");

        YouTubeChannel youTubeChannel = new YouTubeChannel();
        youTubeChannel.addSubscriber(tikam);
        youTubeChannel.addSubscriber(rohit);

        String title = "Mr. beast parody has arrived, go watch out";
        youTubeChannel.notifyAllSubscriber(title);

        youTubeChannel.removeObserver(tikam);

        System.out.println("tikam has removed from the subscriber list");

        String title1 = "Mr. beast parody has arrived, go watch out";
        youTubeChannel.notifyAllSubscriber(title1);

    }
}