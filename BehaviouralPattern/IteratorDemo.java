package BehaviouralPattern;

import java.util.ArrayList;
import java.util.List;


interface Iterator {
     boolean hasNext();
     Object next();

}

class BookIterator implements Iterator {

    private List<Book> books;
    private int index = 0;
    public BookIterator(List<Book> books) {
        this.books = books;
    }
    @Override
    public boolean hasNext() {
        return this.index < this.books.size();
    }

    @Override
    public Object next() {
        if (this.index < this.books.size()) {
            return this.books.get(index++);
        } else {
            return null;
        }
    }
}


class Library {
    Iterator iterator;


    List<Book> books;
    public Library(List<Book> books) {
        this.books = books;
    }

    public Iterator getIterator() {
        return new BookIterator(books);
    }
}

class Book  {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

public class IteratorDemo {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        Book book1 = new Book("book1", "rohit");
        Book book2 = new Book("book2", "sanjay");
        Book book3 = new Book("book3","madan");
        list.add(book1);
        list.add(book2);
        list.add(book3);
        Iterator iterator = new BookIterator(list);
        while(iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}



