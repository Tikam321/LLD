package LLD.LibraryManagementSystem;

public class notification {
    private int id;
    private int content;

    public notification(int id, int content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }
}
