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

            Book book1 = toTest.addBook(title,authors,2020);

            assertEquals(2, toTest.getById(2).getBookId());
            assertEquals("Book", toTest.getById(2).getTitle());
            assertEquals(2020, toTest.getById(2).getPubYear());
            assertEquals(authors, toTest.getById(2).getAuthors());


        } catch(NullWordException | InvalidBookIdException ex ){
            fail();
        }
    }

    //testing null title
    @Test
    public void testAddBookNullTitle() {
            List<String> authors = new ArrayList<>();
            authors.add("AuthorOne");
            authors.add("AuthorTwo");

            assertThrows(NullWordException.class,() -> toTest.addBook(null,authors,2020));
    }

    @Test
    public void testAddBookNullAuthors() {
        String title = "Book";
        assertThrows(NullWordException.class,() -> toTest.addBook(title,null,2020));
    }

    @Test
    public void testAddBookNullYear() {
        String title = "Book";
        List<String> authors = new ArrayList<>();
        authors.add("AuthorOne");
        authors.add("AuthorTwo");
        assertThrows(NullWordException.class,() -> toTest.addBook(title,authors,null));
    }

    @Test
    public void testGetAllBooks() {
        String title = "Book";
        List<String> authors = new ArrayList<>();
        authors.add("AuthorOne");
        authors.add("AuthorTwo");
        Integer year = 2020;
        try {
            Book secondBook = toTest.addBook(title,authors,year);
            //size should equal 2
            assertEquals(2,toTest.getAllBooks().size());
            //check if id matches
            assertEquals(2,toTest.getAllBooks().get(1).getBookId());
            assertEquals(1,toTest.getAllBooks().get(0).getBookId());
            //check if titles are correct
            assertEquals("Book", toTest.getAllBooks().get(1).getTitle());
            assertEquals("The Big Book",toTest.getAllBooks().get(0).getTitle());
            //check if authors are correct
            assertEquals(2,toTest.getAllBooks().get(1).getAuthors().size());
            assertEquals(2,toTest.getAllBooks().get(0).getAuthors().size());
            //check if years are correct
            assertEquals(2020,toTest.getAllBooks().get(1).getPubYear());
            assertEquals(2020,toTest.getAllBooks().get(0).getPubYear());
        } catch (NullWordException | InvalidBookIdException e) {
            fail();
        }

    }

    @Test
    public void testGetByAuthor() {
        String title1 = "Book2";
        List<String> authors1 = new ArrayList<>();
        authors1.add("AuthorOne");
        authors1.add("AuthorTwo");
        Integer year1 = 2020;

        String title2 = "Book3";
        List<String> authors2 = new ArrayList<>();
        authors2.add("AuthorOne");
        Integer year2 = 2020;
        try {
            Book secondBook = toTest.addBook(title1,authors1,year1);
            Book thirdBook = toTest.addBook(title2,authors2,year2);

            //correct amount of books returned
            assertEquals(3, toTest.getByAuthor("AuthorOne").size());
            //should return correct book ids
            assertEquals(2, toTest.getByAuthor("AuthorOne").get(1).getBookId());
            assertEquals(3,toTest.getByAuthor("AuthorOne").get(2).getBookId());
            //should return correct titles
            assertEquals("Book2", toTest.getByAuthor("AuthorOne").get(1).getTitle());
            assertEquals("Book3", toTest.getByAuthor("AuthorOne").get(2).getTitle());
            //correct authors
            assertEquals(true, toTest.getByAuthor("AuthorOne").get(1).getAuthors().contains("AuthorOne"));
            assertEquals(true, toTest.getByAuthor("AuthorOne").get(2).getAuthors().contains("AuthorOne"));
            //correct years
            assertEquals(2020,toTest.getByAuthor("AuthorOne").get(1).getPubYear());
            assertEquals(2020,toTest.getByAuthor("AuthorOne").get(1).getPubYear());
        } catch (NullWordException | InvalidBookIdException | NoBooksException e) {
            fail();
        }

    }
    //test null getByAuthor

    @Test
    public void testGetByTitle() {
        String title1 = "Book2";
        List<String> authors1 = new ArrayList<>();
        authors1.add("AuthorOne");
        authors1.add("AuthorTwo");
        Integer year1 = 2020;

        try {
            Book secondBook = toTest.addBook(title1,authors1,year1);

            //only returns one book with

            //should return correct book ids
            assertEquals(1, toTest.getByTitle("The Big Book").getBookId());
            assertEquals(2,toTest.getByTitle("Book2").getBookId());
            //should return correct titles
            assertEquals("The Big Book", toTest.getByTitle("The Big Book").getTitle());
            assertEquals("Book2", toTest.getByTitle("Book2").getTitle());
            //correct authors
            assertEquals(2, toTest.getByTitle("The Big Book").getAuthors().size());
            assertEquals(2, toTest.getByTitle("Book2").getAuthors().size());
            //correct years
            assertEquals(2020,toTest.getByTitle("The Big Book").getPubYear());
            assertEquals(2020,toTest.getByTitle("Book2").getPubYear());
        } catch (NullWordException | InvalidBookIdException | NoBooksException e) {
            fail();
        }

    }





}
