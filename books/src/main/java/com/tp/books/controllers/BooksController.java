package com.tp.books.controllers;


import com.tp.books.exceptions.InvalidBookIdException;
import com.tp.books.exceptions.InvalidFieldException;
import com.tp.books.exceptions.NoBooksException;
import com.tp.books.exceptions.NullWordException;
import com.tp.books.models.Book;
import com.tp.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    BookService service;

    @GetMapping("/allbooks")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/title/{title}")
    public Book getByTitle(@PathVariable String title) throws NullWordException, NoBooksException {
        return service.getByTitle(title);
    }

    @GetMapping("/author/{author}")
    public List<Book> getByAuthor(@PathVariable String author) throws NullWordException, NoBooksException {
        return service.getByAuthor(author);
    }

    @GetMapping("/year/{year}")
    public List<Book> getByYear(@PathVariable Integer year) throws NullWordException, NoBooksException {
        return service.getByYear(year);
    }

    @GetMapping("/id/{id}")
    public Book getById(@PathVariable Integer id) throws NullWordException, InvalidBookIdException {
        return service.getById(id);
    }

    @PutMapping("/edit")
    public Book editSecretWord( @RequestBody UpdateBook request ) throws InvalidFieldException, NullWordException, InvalidBookIdException {
        return service.editBook( request.getBookId(), request.getTitle(), request.getAuthors(), request.getPubYear() );
    }

    @PostMapping("/addbook")
    public Book startBook(@RequestBody AddBookRequest request) throws InvalidBookIdException, NullWordException, InvalidFieldException {
        Book book = null;
           int bookId = service.addBook(request.getTitle(), request.getAuthors(), request.getPubYear());
           book = service.getById(bookId);
        return book;
    }

    @DeleteMapping("/delete/{bookId}")
    public String deleteGame( @PathVariable Integer bookId ) throws InvalidBookIdException {
            service.deleteBook(bookId);
            return "Book " + bookId + " successfully deleted.";
    }

}
