package com.tp.books.persistence;

import com.tp.books.exceptions.InvalidBookIdException;
import com.tp.books.exceptions.NoBooksException;
import com.tp.books.exceptions.NullWordException;
import com.tp.books.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgresLibraryDao implements BookDao{

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book getByTitle(String title) throws NoBooksException, NullWordException {
        return null;
    }

    @Override
    public List<Book> getByAuthor(String author) throws NoBooksException, NullWordException {
        return null;
    }

    @Override
    public List<Book> getByYear(Integer year) throws NoBooksException, NullWordException {
        return null;
    }

    @Override
    public Book getById(Integer id) throws InvalidBookIdException, NullWordException {
        return null;
    }

    @Override
    public void deleteBook(Integer bookId) throws InvalidBookIdException, NullWordException {

    }

    @Override
    public Book updateBook(Integer id, String titleNew, List<String> authorsNew, Integer yearNew) throws InvalidBookIdException, NullWordException {
        return null;
    }

    @Override
    public Book addBook(String title, List<String> authors, Integer pubYear) throws NullWordException, InvalidBookIdException {
        List<Integer> authorList = new ArrayList<>();
        for(String author: authors){
            Integer authorId = addOrRetrieve(author);
            authorList.add(authorId);
        }

    }

    private Integer addOrRetrieve(String author) {
        Integer autherId = getByAuthor(author);
        if(authorId == null){
           authorId  = addAuthor(author);
        }
    }


    //Helper Method
    private Integer addAuthor(String[] author){


       List<Integer> id = template.query("INSERT into public.\"Authors\" (\"authorName\")\n" +
                "VALUES ('"+author+"')\n" +
                "RETURNING \"authorId\";" , new IdMapper());


    }

    private class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("authorId");
        }
    }
}
