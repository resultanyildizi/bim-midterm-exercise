package com.example.bookapplication.models;

import java.util.ArrayList;
import java.util.List;

/* Singleton */
public class DBBooks {
    static private List<Book> bookList;

    static private DBBooks instance;

    private DBBooks() {
        bookList = new ArrayList<>();
        bookList.add(new Book("Mamama", "Deneme", 123, "Patates"));
        bookList.add(new Book("Moomom", "Deneme", 123, "Patates"));
        bookList.add(new Book("AASASa", "Deneme", 123, "Patates"));
    }

    public static DBBooks getInstance() {
        if(instance != null) {
            return instance;
        }

        instance = new DBBooks();
        return instance;
    }


    public List<Book> getAllBooks() {
        return bookList;
    }

    public void addBook(Book b) {
        bookList.add(b);
    }

    public void removeBook(Book b) {
        bookList.remove(b);
    }

    public Book getBookByName(String name) {
        for (Book book:  bookList) {
            if(book.getName().equals(name)) {
                return book;
            }
        }

        return null;
    }
}
