package com.example.orderswift.exception.user;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer user_id) {super("This user could not found with Id"+ user_id);}
}
