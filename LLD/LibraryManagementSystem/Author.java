package LLD.LibraryManagementSystem;

public class Author {
    private String authorName;
    private String description;

    public Author(String authorName, String description) {
        this.authorName = authorName;
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
