package MachineCodingRound.StackOverflow;

public class Tag {
    private String id;
    private String name;

    public Tag(String name) {
        this.name = name;
        id = generateId();
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() % Integer.MAX_VALUE);
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
