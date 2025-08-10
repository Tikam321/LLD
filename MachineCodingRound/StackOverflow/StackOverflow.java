package MachineCodingRound.StackOverflow;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

public class StackOverflow {
    private final HashMap<String, HashSet<Question>> userQuestionHashMap;
    private final ReentrantLock lock = new ReentrantLock();

    private StackOverflow() {
        userQuestionHashMap = new HashMap<>();
    }

    public static StackOverflow instance;

    public static synchronized StackOverflow getInstance() {
        if (instance == null) {
            return instance = new StackOverflow();
        }
        return instance;
    }

    public void postQuestion(User user, Question question) {
        if (user == null || question == null) {
            throw new IllegalArgumentException("user, question cannot be null");
        }
        lock.lock();
        try {
            userQuestionHashMap.computeIfAbsent(user.getId(), (k) -> new HashSet<>()).add(question);
            user.postQuestion(question);
        } finally {
            lock.unlock();
        }
    }

    public void postAnswer(User user, Question question, Answer answer) {
        if (user == null || question == null || answer == null) {
            throw new IllegalArgumentException("user, question or answer cannot be null");
        }
        lock.lock();
        try {
            question.postAnswer(answer);
            user.postAnswer(answer);
        } finally {
            lock.unlock();
        }
    }

    public void searchByKeyword(String keyword) {
        if (keyword == null || !keyword.isBlank()) {
            userQuestionHashMap.values().stream().flatMap(Collection::stream).
                    forEach(x -> System.out.println(x.getTitle()));
        } else {
            throw new IllegalArgumentException("the keyword cannot be empty.");
        }
    }

    public void searchByTags(String tagId) {
        if (tagId == null || !tagId.isBlank()) {
            userQuestionHashMap.values().stream().flatMap(Collection::stream).filter(x ->
                            x.getTags().stream().anyMatch(tags -> tags.getId().equals(tagId))).
                    forEach(x -> System.out.println(x.getTitle()));
        } else {
            throw new IllegalArgumentException("tagId cannot be empty");
        }
    }

    public void searchByUserProfile(String userId) {
        if (userQuestionHashMap.containsKey(userId)) {
            userQuestionHashMap.get(userId).forEach(question -> System.out.println(question.getTitle()));
        } else {
            throw new IllegalArgumentException("the given userId is not found");
        }
    }
}
