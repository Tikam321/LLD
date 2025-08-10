package MachineCodingRound.DistributedQueue;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Controller {
    public static ConcurrentLinkedDeque<Pair<String, Topic>> distributedQueue;

    public Controller() {
        distributedQueue = new ConcurrentLinkedDeque<>();
    }

    public void pushMessage(Pair<String, Topic> message) {
        distributedQueue.push(message);
    }

    public void processMessage() throws InterruptedException {
        while(!distributedQueue.isEmpty()) {
            Pair<String,Topic> getMessage = distributedQueue.getLast();
            System.out.println("----------");
            getMessage.getValue().publishMessage(getMessage.getKey());
            System.out.println("----------");

            distributedQueue.pollLast();
        }
    }

}
