package LLD.LibraryManagementSystem;


public class BookLending {
    private BookItem bookItem;
    private int start_date;
    private int due_date;
    private int return_date;

    public BookLending(int start_date, int due_date, int return_date,
                       BookItem bookItem) {
        this.start_date = start_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.bookItem = bookItem;
    }

    public int getStart_date() {
        return start_date;
    }

    public void setStart_date(int start_date) {
        this.start_date = start_date;
    }

    public int getDue_date() {
        return due_date;
    }

    public void setDue_date(int due_date) {
        this.due_date = due_date;
    }

    public int getReturn_date() {
        return return_date;
    }

    public void setReturn_date(int return_date) {
        this.return_date = return_date;
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    public void setBookItem(BookItem bookItem) {
        this.bookItem = bookItem;
    }
}
