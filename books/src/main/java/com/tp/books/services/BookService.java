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
        if(title == null){
            throw new NullWordException("Tried to search a null title" );
        }
        return dao.getByTitle(title);


    }

    public List<Book> getByAuthor(String author) throws NullWordException, NoBooksException {
        if(author == null){
            throw new NullWordException("Tried to search a null author" );
        }
        return dao.getByAuthor(author);
    }

    public List<Book> getByYear(Integer year) throws NullWordException, NoBooksException {
        if(year == null){
            throw new NullWordException("Tried to search a null year" );
        }
        return dao.getByYear(year);

    }

    public Book getById(Integer id) throws NullWordException, InvalidBookIdException {
        if(id == null){
            throw new NullWordException("Tried to search a null id" );
        }
        return dao.getById(id);
    }

    public void deleteBook(Integer bookId) throws InvalidBookIdException {
        dao.deleteBook(bookId);
    }

    public Book editBook(Integer bookId, String title, List<String> authors, Integer pubYear) throws NullWordException, InvalidFieldException, InvalidBookIdException {
        Book found = dao.getById(bookId);
        if(title == null){
            throw new NullWordException("title is null");
        }
        if(title.contains("   ")){
            throw new InvalidFieldException("Title is empty");
        }
        if(authors.isEmpty()){
            throw new NullWordException("Authors is empty");
        }
        for(String name: authors){
            if(authors.contains("   ")){
                throw new InvalidFieldException(" Author name is empty");
            }
        }
        if(pubYear == null){
            throw new NullWordException("Year is null");
        }
        if(pubYear > 1900 && pubYear <= 2021){

        }
        else{
            throw new InvalidFieldException("Publication year is not within range");
        }
        found.setTitle(title);
        found.setAuthors(authors);
        found.setPubYear(pubYear);
        dao.updateBook(found);
        return getById(bookId);
    }

    public Integer addBook(String title, List<String> authors, Integer pubYear) throws InvalidFieldException, NullWordException, InvalidBookIdException {
        if(title == null){
            throw new NullWordException("title is null");
        }
        if(title.contains("   ")){
            throw new InvalidFieldException("Title is empty");
        }
        if(authors.isEmpty()){
            throw new NullWordException("Authors is empty");
        }
        for(String name: authors){
            if(authors.contains("   ")){
                throw new InvalidFieldException(" Author name is empty");
            }
        }
        if(pubYear == null){
            throw new NullWordException("Year is null");
        }
        if(pubYear > 1900 && pubYear <= 2021){

        }
        else{
            throw new InvalidFieldException("Publication year is not within range");
        }

        return dao.addBook(title, authors, pubYear);
    }

}
