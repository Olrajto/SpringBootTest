package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
class WeatherList implements Serializable{
    private Long dt;
    private Main main;
    private List<Weather> weather;
}
