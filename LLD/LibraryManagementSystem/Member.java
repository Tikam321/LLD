package LLD.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

import static LLD.LibraryManagementSystem.LibraryManager.*;

public class Member  implements BookObserver{
    private String name ;
    private String member_id;
    private String contact_info;

    private List<BookLending> borrowHistories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public List<BookLending> getBorrowHistories() {
        return borrowHistories;
    }

    public void setBorrowHistories(List<BookLending> borrowHistories) {
        this.borrowHistories = borrowHistories;
    }

    public Member(String name, String id, String contact_info) {
        this.member_id = id;
        this.contact_info = contact_info;
        this.borrowHistories = new ArrayList<>();
        this.name = name;
    }

    public void borrowBook(BookLending bookLending) {
        BookItem book = bookLending.getBookItem();
        if (borrowHistories.size() > MAX_BOOK_ALLOWED) {
            System.out.println("you cannot allowed to issue new book as the book issue limit exceeded.");
        } else {
            if (book.isAvailable()) {
                book.setAvailable(false);
                borrowHistories.add(bookLending);
                System.out.println("The book " + book.getBook().getTitle() + " is assigned to " + name);
            } else {
                System.out.println("this book " + book.getBook().getTitle() + " is already assigned to the member.");
            }
        }
    }
    public void showBorrowHistory() {
        for(BookLending borrowHistory: borrowHistories) {
            Book book = borrowHistory.getBookItem().getBook();
            System.out.println("Book "+ book.getTitle() +
                    "publisher "+ book.getPublisher());
        }
    }

    public void returnBook(BookItem bookItem, int duration) {
        Book book = bookItem.getBook();
        if (duration > MAX_DAYS_LIMIT) {
            payFine(bookItem,duration);
        } else {
            System.out.println(name + "returning the book " + book.getTitle());
        }
        bookItem.setAvailable(true);
    }

    public void payFine(BookItem bookItem, int duration) {
        int extraDays = (duration - MAX_DAYS_LIMIT) * FINE_PER_DAY;
        System.out.println(name + " you have to pay " + extraDays + "for returning the book");
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    @Override
    public void notify(BookItem bookItem) {
        System.out.println("The new book is arrived in library issue if you likes it " + "book name " + bookItem.getBook().getTitle());
    }
}
