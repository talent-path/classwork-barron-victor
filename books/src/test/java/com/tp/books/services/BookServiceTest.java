package com.tp.books.services;

import com.tp.books.exceptions.InvalidBookIdException;
import com.tp.books.exceptions.InvalidFieldException;
import com.tp.books.exceptions.NullWordException;
import com.tp.books.models.Book;
import com.tp.books.persistence.BookInMemDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class BookServiceTest {

    @Autowired
    BookService service;

    @BeforeEach
    public void setup() throws InvalidBookIdException, NullWordException, InvalidFieldException {
        new BookInMemDao();

        List<String> authors = new ArrayList<>();
        authors.add("AuthorOne");
        authors.add("AuthorTwo");

        service.addBook( "The Big Book", authors, 2020);
    }

    //testAddBookEmptyTitle
    @Test
    public void testAddBookEmptyTitle() {
        List<String> authors1 = new ArrayList<>();
        authors1.add("AuthorOne");
        authors1.add("AuthorTwo");
        assertThrows(InvalidFieldException.class, () -> service.addBook("  ", authors1,2019));
    }

    //test getByTitle
    //test getByAuthor
    //test getByYear
    //test getById
    //test editBook




}
