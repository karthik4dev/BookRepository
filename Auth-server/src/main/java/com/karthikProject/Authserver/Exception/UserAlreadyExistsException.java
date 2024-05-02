package com.karthikProject.Authserver.Exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){
        super();
    }
    public UserAlreadyExistsException(String Message){
        super(Message);
    }
}
