package com.example.demo.exceptions;

public class WeatherRequestException extends Exception {
    public WeatherRequestException(Exception e){
        super(e);
    }
}
