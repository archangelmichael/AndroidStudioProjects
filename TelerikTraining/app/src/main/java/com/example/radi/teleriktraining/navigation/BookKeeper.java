package com.example.radi.teleriktraining.navigation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by radi on 5/15/17.
 */

public class BookKeeper {
    private static ArrayList<Book> books;

    static {
        books = new ArrayList<Book>();
        for (int i=0; i<= 100; i++) {
            books.add(new Book("IBNS " + i, "TITLE " + i));
        }
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public Book getBookByIsbn(String isbn) {
        for (Book book:
             books) {
            if (book.getIbns().equals(isbn)) {
                return book;
            }
        }

        return null;
    }

    public Book createBook(String ibns, String title) {
        Book book = new Book(ibns, title);
        books.add(book);
        return book;
    }

}
