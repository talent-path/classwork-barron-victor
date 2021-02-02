package com.tp.books.persistence;

import com.tp.books.exceptions.InvalidBookIdException;
import com.tp.books.exceptions.NoBooksException;
import com.tp.books.exceptions.NullWordException;
import com.tp.books.models.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();

    Book getByTitle(String title) throws NoBooksException, NullWordException;

    List<Book> getByAuthor(String author) throws NoBooksException, NullWordException;

    List<Book> getByYear(Integer year) throws NoBooksException, NullWordException;

    Book getById(Integer id) throws InvalidBookIdException, NullWordException;

    void deleteBook(Integer bookId) throws InvalidBookIdException, NullWordException;

    Book updateBook(Integer id, String titleNew, List<String> authorsNew, Integer yearNew) throws InvalidBookIdException, NullWordException;

    Book addBook(String title, List<String> authors, Integer pubYear) throws NullWordException, InvalidBookIdException;
}
