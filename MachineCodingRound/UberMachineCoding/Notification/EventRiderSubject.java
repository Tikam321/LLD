package MachineCodingRound.UberMachineCoding.Notification;

import java.util.ArrayList;
import java.util.List;

public class EventRiderSubject implements Subject {

    private List<Observer> observerList;

    public EventRiderSubject() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers(String message) {
        observerList.stream().forEach(observer -> observer.update(message));
    }
}
