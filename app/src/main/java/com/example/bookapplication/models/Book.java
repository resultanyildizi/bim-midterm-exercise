package com.example.bookapplication.models;

public class Book {
    String name;
    String author;
    int pageCount;
    String category;

    public Book(String name, String author, int pageCount, String category) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
        this.category = category;
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

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
