package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CombustionDTO {
    private Long id;
    private Date date;
    private Integer distance;
    private String fuelType;
    private Integer value;
    private Double combustionValue;
}
