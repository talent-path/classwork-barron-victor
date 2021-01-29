package com.tp.books.persistence;

import com.tp.books.exceptions.InvalidBookIdException;
import com.tp.books.exceptions.NoBooksException;
import com.tp.books.exceptions.NullWordException;
import com.tp.books.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BookInMemDao implements BookDao{

    List<Book> collection = new ArrayList<>();

    public BookInMemDao(){
        List<String> authors = new ArrayList<>();
        authors.add("Me");
        authors.add("you");
        Book firstBook = new Book(1,"BookOne", authors,2021);
        collection.add(firstBook);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> copyList = new ArrayList<>();
        for(Book toCopy: collection){
            copyList.add(new Book(toCopy));
        }
        return copyList;
    }

    @Override
    public Book getByTitle(String title) throws NoBooksException{
        Book toReturn = null;
        for(Book toCopy: collection){
            if(toCopy.getTitle().equals(title)){
                toReturn = new Book(toCopy);
            }
        }
        if(toReturn == null){
            throw new NoBooksException("Could not find book with title" + title);
        }
        return toReturn;

    }

    @Override
    public List<Book> getByAuthor(String author) throws NoBooksException{
        List<Book> toReturn = new ArrayList<>();
        for(Book toCopy: collection){
            if(toCopy.getAuthors().contains(author)){
                toReturn.add(new Book(toCopy));
            }
        }
        if(toReturn.isEmpty()){
            throw new NoBooksException("Could not find book with author name" + author );
        }
        return toReturn;
    }

    @Override
    public List<Book> getByYear(Integer year) throws NoBooksException{
        List<Book> toReturn = new ArrayList<>();
        for(Book toCopy: collection){
            if(toCopy.getPubYear().equals(year)){
                toReturn.add(new Book(toCopy));
            }
        }
        if(toReturn.isEmpty()){
            throw new NoBooksException("Could not find book with publication year" + year );
        }
        return toReturn;
    }

    @Override
    public Book getById(Integer id) throws InvalidBookIdException {
        Book toReturn = null;
        for(Book check: collection){
            if(check.getBookId().equals(id)) {
                toReturn = new Book(check);
                break;
            }
        }
        if(toReturn.equals(null)){
            throw new InvalidBookIdException("Book Id is not in collection");
        }
        return toReturn;
    }

    @Override
    public void deleteBook(Integer bookId) throws InvalidBookIdException {

        int removeIndex = -1;

        for( int i = 0; i < collection.size(); i++ ){
            if( collection.get(i).getBookId().equals(bookId)){
                removeIndex = i;
                break;
            }
        }

        if( removeIndex != -1 ){
            collection.remove(removeIndex);
        } else {
            throw new InvalidBookIdException("Could not find game with id " + bookId + "to delete.");
        }
    }

    @Override
    public void updateBook(Book found) {
        for( int i = 0; i < collection.size(); i++){
            if( collection.get(i).getBookId().equals(found.getBookId())){
                collection.set(i, new Book(found) );
            }
        }
    }

    @Override
    public int addBook(String title, List<String> authors, Integer pubYear) throws NullWordException {
        int id = 0;
        for( Book toCheck : collection ){
            if( toCheck.getBookId() > id ){
                id = toCheck.getBookId();
            }
        }
        id++;
        Book toAdd = new Book(id ,title ,authors ,pubYear);
        collection.add( toAdd );
        return id;
    }

}
