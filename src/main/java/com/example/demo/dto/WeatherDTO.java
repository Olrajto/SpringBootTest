package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WeatherDTO implements Serializable{
    private List<WeatherList> list;
    private String cod;

}
