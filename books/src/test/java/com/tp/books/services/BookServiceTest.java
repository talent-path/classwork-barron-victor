package com.tp.books.services;

import com.tp.books.exceptions.InvalidBookIdException;
import com.tp.books.exceptions.InvalidFieldException;
import com.tp.books.exceptions.NullWordException;
import com.tp.books.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {

    @Autowired
    BookService service;

    @BeforeEach
    public void setup() throws InvalidBookIdException, NullWordException, InvalidFieldException {
        List<Book> allGames = service.getAllBooks();

        for( Book toRemove : allGames ){
            service.deleteBook(toRemove.getBookId());
        }

        List<String> authors = new ArrayList<>();
        authors.add("AuthorOne");
        authors.add("AuthorTwo");

        service.addBook( "The Big Book", authors, 2020);
    }


}
