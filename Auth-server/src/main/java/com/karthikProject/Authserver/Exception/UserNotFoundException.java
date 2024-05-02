package com.karthikProject.Authserver.Exception;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(){
        super();
    }

    public UserNotFoundException(String message){
        super(message);
    }

}
