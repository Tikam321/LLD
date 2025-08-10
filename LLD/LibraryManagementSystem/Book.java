package LLD.LibraryManagementSystem;

import java.util.List;

public class Book {
    private List<Author> authors;
    private String isbn;
    private String title;
    private String publisher;

    public Book(List<Author> authors, String isbn, String title, String publisher) {
        this.authors = authors;
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
