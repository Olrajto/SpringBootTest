package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CombustionRequestDTO {
    private Long id;
    private Date startDate;
    private Date endDate;
    private Integer value;
    private String fuelType;
    private Integer distance;
}
