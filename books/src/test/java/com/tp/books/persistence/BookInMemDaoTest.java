package com.tp.books.persistence;

import com.tp.books.exceptions.InvalidBookIdException;
import com.tp.books.exceptions.NoBooksException;
import com.tp.books.exceptions.NullWordException;
import com.tp.books.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BookInMemDaoTest {

    @Autowired
    BookInMemDao toTest;

    @BeforeEach
    public void setup() throws InvalidBookIdException, NullWordException {
        List<Book> allBooks = toTest.getAllBooks();
        for( Book toRemove : allBooks ){
            toTest.deleteBook(toRemove.getBookId());
        }

        List<String> authors = new ArrayList<>();
        authors.add("AuthorOne");
        authors.add("AuthorTwo");

        toTest.addBook( "The Big Book", authors, 2020);
    }


    //test adding a book
    //cannot test null or empty cases here as service layer handles that
    @Test
    public void testAddBookGoldenPath() {
        try {
            //1. Arrange (set up inputs)
            String title = "Book";
            List<String> authors = new ArrayList<>();
            authors.add("AuthorOne");
            authors.add("AuthorTwo");

            int id = toTest.addBook(title,authors,2020);

            assertEquals(2, id);

        } catch( NullWordException ex ){
            fail();
        }
    }

    //test getting by title,author,published year,id
    @Test
    public void testGetting() {
        try{
            String title = "Book";
            List<String> authors = new ArrayList<>();
            authors.add("AuthorOne");
            authors.add("AuthorTwo");

            int id = toTest.addBook(title,authors,2020);

            assertEquals(3, toTest.getByTitle("The Big Book"));

        }catch (NoBooksException | NullWordException e){
            fail();
        }
    }






}
