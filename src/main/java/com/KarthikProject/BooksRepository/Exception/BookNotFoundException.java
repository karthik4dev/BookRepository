package com.KarthikProject.BooksRepository.Exception;

public class BookNotFoundException extends Exception{
    public BookNotFoundException(){
        super();
    }
    public  BookNotFoundException(String message){
        super(message);
    }
}
