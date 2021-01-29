package com.tp.books.exceptions;

public class NoBooksException extends Exception{
    public NoBooksException( String message ){
        super( message );
    }

    public NoBooksException( String message, Throwable innerException ){
        super( message, innerException);
    }
}
