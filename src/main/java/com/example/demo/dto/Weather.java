package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
class Weather implements Serializable{
    private String main;
    private String description;
}
