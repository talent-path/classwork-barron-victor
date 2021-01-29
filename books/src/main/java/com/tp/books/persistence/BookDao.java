package com.tp.books.persistence;

import com.tp.books.exceptions.InvalidBookIdException;
import com.tp.books.exceptions.NoBooksException;
import com.tp.books.exceptions.NullWordException;
import com.tp.books.models.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();

    Book getByTitle(String title) throws NoBooksException;

    List<Book> getByAuthor(String author) throws NoBooksException;

    List<Book> getByYear(Integer year) throws NoBooksException;

    Book getById(Integer id) throws InvalidBookIdException;

    void deleteBook(Integer bookId) throws InvalidBookIdException;

    void updateBook(Book found);

    int addBook(String title, List<String> authors, Integer pubYear) throws NullWordException;
}
