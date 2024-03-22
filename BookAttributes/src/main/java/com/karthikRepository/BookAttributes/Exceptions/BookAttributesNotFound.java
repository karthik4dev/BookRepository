package com.karthikRepository.BookAttributes.Exceptions;

public class BookAttributesNotFound extends Exception {
    BookAttributesNotFound(){super();}
    public BookAttributesNotFound(String comments){super(comments);}
}
