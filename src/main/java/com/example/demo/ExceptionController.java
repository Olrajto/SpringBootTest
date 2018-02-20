package com.example.demo;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.WeatherRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.PersistenceException;

@ControllerAdvice
@Slf4j
public class ExceptionController extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity handleNotFound(EntityNotFoundException e){
        log.error("Unable to find entity", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Combustion data not found");
    }

    @ExceptionHandler(value = WeatherRequestException.class)
    protected  ResponseEntity handleWeatherException(WeatherRequestException e){
        log.error("Unable to get weather info", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to get weather. Contact administrator");
    }

    @ExceptionHandler(value = PersistenceException.class)
    protected ResponseEntity handleJpaExceptions(PersistenceException e){
        log.error("Database exception", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database exception");
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity handleGenericException(Exception e){
        log.error("Generic exception", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown error");
    }
}
