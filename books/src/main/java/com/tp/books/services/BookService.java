package com.tp.books.services;

import com.tp.books.exceptions.InvalidBookIdException;
import com.tp.books.exceptions.InvalidFieldException;
import com.tp.books.exceptions.NoBooksException;
import com.tp.books.exceptions.NullWordException;
import com.tp.books.models.Book;
import com.tp.books.persistence.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    @Autowired
    BookDao dao;


    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    public Book getByTitle(String title) throws NullWordException, NoBooksException {
        return dao.getByTitle(title);


    }

    public List<Book> getByAuthor(String author) throws NullWordException, NoBooksException {
        return dao.getByAuthor(author);
    }

    public List<Book> getByYear(Integer year) throws NullWordException, NoBooksException {
        return dao.getByYear(year);

    }

    public Book getById(Integer id) throws NullWordException, InvalidBookIdException {
        return dao.getById(id);
    }

    public void deleteBook(Integer bookId) throws InvalidBookIdException, NullWordException {
        dao.deleteBook(bookId);
    }

    public Book editBook(Integer bookId, String title, List<String> authors, Integer pubYear) throws NullWordException, InvalidFieldException, InvalidBookIdException {

        if(title.contains("   ")){
            throw new InvalidFieldException("Title is empty");
        }
        if(authors.isEmpty()){
            throw new NullWordException("Authors is empty");
        }
        if(authors.contains("   ")) {
            throw new InvalidFieldException(" Author name is empty");
        }

        if(pubYear > 1900 && pubYear <= 2021){

        }
        else{
            throw new InvalidFieldException("Publication year is not within range");
        }
        return dao.updateBook(bookId,title,authors,pubYear);
    }

    public Book addBook(String title, List<String> authors, Integer pubYear) throws InvalidFieldException, NullWordException, InvalidBookIdException {
        if(title.contains("   ")){
            throw new InvalidFieldException("Title is empty");
        }
        if(authors.contains("   ")){
            throw new InvalidFieldException("Author name is empty");
        }
        if(pubYear > 1900 && pubYear <= 2021){

        }
        else{
            throw new InvalidFieldException("Publication year is not within range");
        }

        return dao.addBook(title, authors, pubYear);
    }

}
