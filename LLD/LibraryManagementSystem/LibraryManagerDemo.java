package LLD.LibraryManagementSystem;

import java.util.Collections;

public class LibraryManagerDemo {
    public static void main(String[] args) {
        LibraryManager libraryManager = LibraryManager.getInstance();
        Author tikam = new Author("tikam", "best writer");
        Book book1 = new Book(Collections.singletonList(tikam),"the324-2q","moneyMind","nathuram");
        BookItem bookItem = new BookItem(book1, 123423, new Shelf(2,13));

        Member member1 = new Member("rohit", "1231","423920234");

        libraryManager.registerMember(member1);
        libraryManager.addBooks(bookItem);

        BookLending bookLending = new BookLending(1,10, 5,bookItem);
        libraryManager.issueBookToMember(bookLending, member1);

        System.out.println(bookItem.isAvailable());

    }
}
