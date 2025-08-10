package MachineCodingRound.StackOverflow;

import java.util.Arrays;

public class StackOverflowDemo {
    public static void main(String[] args) {
        StackOverflow stackOverflow = StackOverflow.getInstance();

        // creating users
        User tikam = new User("tikam-1","tikam");
        User virat = new User("virat-2","virat");
        User rohit = new User("rohit-134","rohit");

        // creating the Tag Id

        Tag reactTag = new Tag("React");
        Tag javaTag = new Tag("Java");
        Tag oopTag = new Tag("OOP");
        Tag objectTag = new Tag("Object");
        Tag configurationTag = new Tag("Configuration");
        Tag k8sTag = new Tag("k8s");


        // creating and posting the questions on stackOverflow
        Question java = new Question("how to check java object null or not",
                "I am using the dataObj from DB and i want to check for it", Arrays.asList(javaTag, oopTag, objectTag));
        Question react = new Question("React set up configuration ",
                "can anyone help about react setup", Arrays.asList(reactTag, configurationTag));

        Question devOps = new Question("How to create multiple pods in k8s",
                "i have added single pod but not able to add another pod", Arrays.asList(k8sTag, configurationTag));


        Answer javaAnswer = new Answer("Yes we can use Optional object for null check for object");

        // posting questions
        stackOverflow.postQuestion(tikam, java);
        stackOverflow.postQuestion(rohit, react);
        stackOverflow.postQuestion(tikam, devOps);

        // post answers
        stackOverflow.postAnswer(tikam, java, javaAnswer);

        // comment on the questions
        Comment javaComment = new Comment("I also have the same doubt thanks for sharing",tikam);
        java.postComment(javaComment);

        // upvote
//        java.upVote(tikam);

        stackOverflow.searchByTags(configurationTag.getId());
    }
}
