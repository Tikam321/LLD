package LLD.LibraryManagementSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryManager {
    public static final int MAX_BOOK_ALLOWED = 5;
    public static final int MAX_DAYS_LIMIT = 10;
    public static final int FINE_PER_DAY = 3;

   private Map<String, BookItem> catalog;
   private Map<String, Member> members;
   private static LibraryManager instance;

   private LibraryManager() {
       catalog = new ConcurrentHashMap<>();
       members = new ConcurrentHashMap<>();
   }

   public static synchronized LibraryManager getInstance() {
       if (instance == null) {
           instance = new LibraryManager();
       }
       return instance;
   }

   public void registerMember(Member member) {
       members.put(member.getMember_id(), member);
   }

   public void removeMember(Member member) {
       members.remove(member.getMember_id());
   }

   public void addBooks(BookItem bookItem) {
       catalog.put(bookItem.getBook().getIsbn(), bookItem);
       notifyMember(bookItem);
   }

   public void notifyMember(BookItem bookItem) {
       for(Map.Entry<String,Member> mp: members.entrySet()) {
           mp.getValue().notify(bookItem);
       }
   }

   public void issueBookToMember(BookLending bookLending, Member member) {
       member.borrowBook(bookLending);
   }

   public void searchBookByTitle(String byTitle) {
       // implement code
   }

   // you can follow this logic for user can borrow book concurrently.

//    public synchronized void borrowBook(String memberId, String isbn) {
//        Member member = getMember(memberId);
//        Book book = getBook(isbn);
//
//        if (member != null && book != null && book.isAvailable()) {
//            if (member.getBorrowedBooks().size() < MAX_BOOKS_PER_MEMBER) {
//                member.borrowBook(book);
//                book.setAvailable(false);
//                System.out.println("Book borrowed: " + book.getTitle() + " by " + member.getName());
//            } else {
//                System.out.println("Member " + member.getName() + " has reached the maximum number of borrowed books.");
//            }
//        } else {
//            System.out.println("Book or member not found, or book is not available.");
//        }
//    }
//
//    public synchronized void returnBook(String memberId, String isbn) {
//        Member member = getMember(memberId);
//        Book book = getBook(isbn);
//
//        if (member != null && book != null) {
//            member.returnBook(book);
//            book.setAvailable(true);
//            System.out.println("Book returned: " + book.getTitle() + " by " + member.getName());
//        } else {
//            System.out.println("Book or member not found.");
//        }
//    }

}
