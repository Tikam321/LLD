package MachineCodingRound.DistributedQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Topic {
    private String name;
    private String id;
    private final List<Consumer> consumers;
    private final BlockingQueue<String> messageQueue;
    private final HashMap<String, Thread> consumerThreadMap;

    public Topic(String name, String id) {
        this.name = name;
        this.id = id;
        this.consumers = new ArrayList<>();
        messageQueue = new LinkedBlockingQueue<>();
        consumerThreadMap = new HashMap<>();
    }

    public void addConsumer(Consumer consumer) {
        consumers.add(consumer);
        Thread consumerThread = new Thread(() -> {
            while(true) {
                try {
                    String message = messageQueue.take();
                    consumer.getNotification(message);
                }
                catch (InterruptedException e) {
                    break;
                }
        }});
        consumerThread.start();
        consumerThreadMap.put(consumer.getId(), consumerThread);
    }

    public void removeConsumer(Consumer consumer) {
        consumers.remove(consumer);
        Thread consumerThread = consumerThreadMap.get(consumer.getId());
        consumerThread.interrupt();
        consumerThreadMap.remove(consumer.getId());
    }
    public void publishMessage(String message) {
        messageQueue.add(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }
}
