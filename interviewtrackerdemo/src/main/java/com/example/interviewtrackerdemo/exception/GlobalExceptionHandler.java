package com.example.interviewtrackerdemo.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/*handling all exceptions and giving the handled exception in console or as here we are now using postman 
      for checking RestApi so it will be showing in postman	
	*/
    @ExceptionHandler(IdNotFoundException.class)
    public String handlerForIdNotFoundException(IdNotFoundException e)
    {
        return "Id Notfound Exception: "+e.getMessage();
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public String handlerForConstraintViolationException(ConstraintViolationException e)
    {
        return "Feedback should be maximum of 500 characters.";
    }
}
