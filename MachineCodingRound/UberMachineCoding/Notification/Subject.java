package MachineCodingRound.UberMachineCoding.Notification;

public interface Subject {

    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);

    void notifyAllObservers(String message);
}
