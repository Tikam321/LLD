package MachineCodingRound.DistributedQueue;

public class DistributedQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Controller controller = new Controller();
        Producer producer1 = new Producer("1","producer1");
        Producer producer2 = new Producer("2","producer2");

        Consumer consumer1 = new Consumer("Consumer1","Consumer1");
        Consumer consumer2 = new Consumer("Consumer2","Consumer2");
        Consumer consumer3 = new Consumer("Consumer3","Consumer3");
        Consumer consumer4 = new Consumer("Consumer4","Consumer4");
        Consumer consumer5 = new Consumer("Consumer5","Consumer5");

        Topic topic1 = new Topic("topic1","topic123");
        Topic topic2 = new Topic("topic2","topic234");

        topic1.addConsumer(consumer1);
        topic1.addConsumer(consumer2);
        topic1.addConsumer(consumer3);
        topic1.addConsumer(consumer4);
        topic1.addConsumer(consumer5);

        topic2.addConsumer(consumer1);
        topic2.addConsumer(consumer3);
        topic2.addConsumer(consumer5);


        producer1.produceMessage("message1",topic1);
        System.out.println("----------");
        producer1.produceMessage("message2",topic1);
        System.out.println("----------");
        producer2.produceMessage("message3",topic1);
        System.out.println("----------");
        producer1.produceMessage("message4",topic2);
        System.out.println("----------");
        producer2.produceMessage("message5",topic2);

//        controller.processMessage();




    }
}
