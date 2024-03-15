package com.example.interviewtrackerdemo.exception;


//creating custom exception as here we need to id 
public class IdNotFoundException extends Exception{
    public IdNotFoundException(String message) {
        super(message);
    }
}
