package com.tp.books.exceptions;

public class InvalidFieldException extends Exception{
    public InvalidFieldException( String message ){
        super( message );
    }

    public InvalidFieldException( String message, Throwable innerException ){
        super( message, innerException);
    }
}
