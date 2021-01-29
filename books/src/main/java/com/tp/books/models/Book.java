package com.tp.books.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {
    private Integer bookId;
    private String title;
    private List<String> authors;
    private Integer pubYear;


    public Book(){
        this.authors = new ArrayList<>();
    }
    //constructor for a Book
    public Book(Integer bookId, String title, List<String> authors, Integer pubYear){
        this.bookId = bookId;
        this.title = title;
        this.pubYear = pubYear;
        this.authors = new ArrayList<>();
        for( String toCopy : authors ){
            this.authors.add( toCopy );
        }
    }

    //copy constructor
    public Book(Book that){
        this.bookId = that.bookId;
        this.title = that.title;
        this.pubYear = that.pubYear;
        this.authors = new ArrayList<>();
        for( String toCopy : that.authors ){
            this.authors.add( toCopy );
        }
    }


    //getters
    public Integer getBookId() {
        return bookId;
    }
    public Integer getPubYear() {
        return pubYear;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public String getTitle() {
        return title;
    }

    //setters
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    public void setPubYear(Integer pubYear) {
        this.pubYear = pubYear;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
