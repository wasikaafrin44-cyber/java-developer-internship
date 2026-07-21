package com.codeveda.level3.librarymanagement.table;

public class Books {

    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean available;

    public Books() {

    }
    public Books(int bookId, String title, String author, String category, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = available;
    }

    public int getBookId() {
        return bookId;
    }


    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public String getCategory() {
        return category;
    }


    public boolean getAvailable() {
        return available;
    }


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }


    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", available=" + available +
                '}';
    }
}