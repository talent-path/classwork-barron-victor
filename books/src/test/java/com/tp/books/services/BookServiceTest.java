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
        List<Book> allBooks = service.getAllBooks();

        for( Book toRemove : allBooks ){
            service.deleteBook(toRemove.getBookId());
        }

        List<String> authors = new ArrayList<>();
        authors.add("AuthorOne");
        authors.add("AuthorTwo");

        service.addBook( "The Big Book", authors, 2020);
    }

    @Test
    public void testAddBookGoldenPath() {
        try {
            //1. Arrange (set up inputs)
            String title = "Book";
            List<String> authors = new ArrayList<>();
            authors.add("AuthorOne");
            authors.add("AuthorTwo");

            int id = service.addBook(title,authors,2020);

            assertEquals(2, id);

        } catch(NullWordException | InvalidFieldException | InvalidBookIdException ex ){
            fail();
        }
    }

    //test getAllBooks
    //test getByTitle
    //test getByAuthor
    //test getByYear
    //test getById
    //test deleteBook
    //test editBook




}
