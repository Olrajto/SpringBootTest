package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity handleNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity not found");
    }
}
