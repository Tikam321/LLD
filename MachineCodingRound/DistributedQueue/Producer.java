package MachineCodingRound.DistributedQueue;

public class Producer {
    private String id;
    private String name;

    public Producer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void produceMessage(String message, Topic topic) throws InterruptedException {
        topic.publishMessage(message);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
