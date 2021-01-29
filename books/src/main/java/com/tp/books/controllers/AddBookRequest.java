package com.tp.books.controllers;

import java.util.List;

public class AddBookRequest {
    String title;
    List<String> authors;
    Integer pubYear;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Integer getPubYear() {
        return pubYear;
    }

    public void setPubYear(Integer pubYear) {
        this.pubYear = pubYear;
    }
}
