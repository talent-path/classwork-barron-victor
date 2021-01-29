package com.tp.books.exceptions;

public class NullWordException extends Exception{
    public NullWordException(String message){
        super(message);
    }

    public NullWordException( String message, Throwable innerException ){
        super( message, innerException );
    }
}
