package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
class Main implements Serializable{
    private Double temp;
    private Double temp_min;
    private Double temp_max;
    private Double pressure;
    private Double sea_level;
    private Double grnd_level;
    private Integer humidity;
    private Float temp_kf;

}
