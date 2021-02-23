package com.sith.challenge.models.entities;

public class Book {

    private int id;
    private String title;
    private String author;
    private String edition;

    public Book() {
    }

    public Book(int id, String title, String author, String edition) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
