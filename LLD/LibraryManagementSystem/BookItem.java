package LLD.LibraryManagementSystem;

public class BookItem {
    private Book book;
    private boolean isAvailable = true;
    private int barCode;

    private Shelf shelf;

    public BookItem(Book book, int barCode, Shelf shelf) {
        this.book = book;
        this.barCode = barCode;
        this.shelf = shelf;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }
}
